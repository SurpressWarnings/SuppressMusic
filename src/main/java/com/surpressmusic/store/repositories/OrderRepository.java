package com.surpressmusic.store.repositories;

import com.surpressmusic.store.entity.products.Song;
import com.surpressmusic.store.entity.user.Order;
import com.surpressmusic.store.entity.user.OrderDetail;
import com.surpressmusic.store.entity.user.UserDetailsImpl;
import com.surpressmusic.store.model.*;
import com.surpressmusic.store.services.AlbumService;
import com.surpressmusic.store.services.SongService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public class OrderRepository {

   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private SongService songService;

   @Autowired
   private AlbumService albumService;

   private int getMaxOrderNum() {
      Session session = this.sessionFactory.getCurrentSession();
      Query<Integer> query = session.createQuery(sql, Integer.class);
      Integer value = (Integer) query.getSingleResult();
      if (value == null) {
         return 0;
      }
      return value;
   }

   @Transactional(rollbackFor = Exception.class)
   public void saveOrder(CartInfo cartInfo) {
      Session session = this.sessionFactory.getCurrentSession();

      int orderNum = this.getMaxOrderNum() + 1;
      Order order = new Order();

      order.setId(UUID.randomUUID().toString());
      order.setOrderNum(orderNum);
      order.setOrderDate(new Date());
      order.setTotal(cartInfo.getAmountTotal());

      UserDetailsImpl userDetails = cartInfo.getUserDetails();
      order.setUserDetails(userDetails);

      session.persist(order);

      List<CartLineInfo> lines = cartInfo.getCartLines();

      for (CartLineInfo line : lines) {
         OrderDetail detail = new OrderDetail();
         detail.setId(UUID.randomUUID().toString());
         detail.setOrder(order);
         detail.setQuantity(line.getQuantity());
         detail.setPrice(line.getSongInfo().getPrice());
         detail.setQuantityTotal(line.getQuantity());

         Long id = line.getSongInfo().getId();
         Song song = songService.getSongById(id);
         detail.setSong(song);

         session.persist(detail);
      }

      // Order Number!
      cartInfo.setOrderNum(orderNum);
      // Flush
      session.flush();
   }

   // to be implemented in future
   // @page = 1, 2, ...
//   public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
//      String sql = "Select new " + OrderInfo.class.getName()//
//            + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
//            + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
//            + Order.class.getName() + " ord "//
//            + " order by ord.orderNum desc";
//
//      Session session = this.sessionFactory.getCurrentSession();
//      Query<OrderInfo> query = session.createQuery(sql, OrderInfo.class);
//      return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
//   }

   public Order findOrder(String orderId) {
      Session session = this.sessionFactory.getCurrentSession();
      return session.find(Order.class, orderId);
   }

   public OrderInfo getOrderInfo(String orderId) {
      Order order = this.findOrder(orderId);

      if (order == null) {
         return null;
      }

      return new OrderInfo(order.getId(), order.getOrderDate(), //
            order.getOrderNum(), order.getAmount(), order.getCustomerName(), //
            order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
   }

   public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
      String sql = "Select new " + OrderDetailInfo.class.getName() //
            + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
            + " from " + OrderDetail.class.getName() + " d "//
            + " where d.order.id = :orderId ";

      Session session = this.sessionFactory.getCurrentSession();
      Query<OrderDetailInfo> query = session.createQuery(sql, OrderDetailInfo.class);
      query.setParameter("orderId", orderId);

      return query.getResultList();
   }

   public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
   }

   public UserInfo getCustomerInfo() {
      return userInfo;
   }

   public void setCustomerInfo(UserInfo customerInfo) {
      this.userInfo = customerInfo;
   }

   public List<CartLineInfo> getCartLines() {
      return this.cartLines;
   }

   private CartLineInfo findLineByCode(String id) {
      for (CartLineInfo line : this.cartLines) {
         if (line.getSongInfo().getId().equals(id)) {
            return line;
         }
      }
      return null;
   }

   public void addProduct(SongInfo songInfo, int quantity) {
      CartLineInfo line = this.findLineByCode(songInfo.getId());

      if (line == null) {
         line = new CartLineInfo();
         line.setQuantity(0);
         line.setProductInfo(productInfo);
         this.cartLines.add(line);
      }
      int newQuantity = line.getQuantity() + quantity;
      if (newQuantity <= 0) {
         this.cartLines.remove(line);
      } else {
         line.setQuantity(newQuantity);
      }
   }

   public void validate() {}

   public void updateProduct(String code, int quantity) {
      CartLineInfo line = this.findLineByCode(code);

      if (line != null) {
         if (quantity <= 0) {
            this.cartLines.remove(line);
         } else {
            line.setQuantity(quantity);
         }
      }
   }

   public void removeProduct(ProductInfo productInfo) {
      CartLineInfo line = this.findLineByCode(productInfo.getCode());
      if (line != null) {
         this.cartLines.remove(line);
      }
   }

   public boolean isEmpty() {
      return this.cartLines.isEmpty();
   }

   public boolean isValidCustomer() {
      return this.customerInfo != null && this.customerInfo.isValid();
   }

   public int getQuantityTotal() {
      int quantity = 0;
      for (CartLineInfo line : this.cartLines) {
         quantity += line.getQuantity();
      }
      return quantity;
   }

   public double getAmountTotal() {
      double total = 0;
      for (CartLineInfo line : this.cartLines) {
         total += line.getAmount();
      }
      return total;
   }

   public void updateQuantity(CartInfo cartForm) {
      if (cartForm != null) {
         List<CartLineInfo> lines = cartForm.getCartLines();
         for (CartLineInfo line : lines) {
            this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
         }
      }
   }
}
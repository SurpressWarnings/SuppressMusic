//package com.surpressmusic.store.repositories;
//
//import com.surpressmusic.store.entity.products.Song;
//import com.surpressmusic.store.entity.user.Order;
//import com.surpressmusic.store.entity.user.OrderDetail;
//import com.surpressmusic.store.entity.user.UserBilling;
//import com.surpressmusic.store.model.*;
//import com.surpressmusic.store.services.SongService;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Transactional
//@Repository
//public class OrderRepository {
//
////   @Autowired
//   private SessionFactory sessionFactory;
//
//   @Autowired
//   private SongService songService;
//
//   private int getMaxOrderNum() {
//      String sql = "Select max(o.orderNum) from " + Order.class.getName() +
//            " o ";
//      Session session = this.sessionFactory.getCurrentSession();
//      Query<Integer> query = session.createQuery(sql, Integer.class);
//      Integer value = query.getSingleResult();
//      if (value == null) {
//         return 0;
//      }
//      return value;
//   }
//
//   @Transactional(rollbackFor = Exception.class)
//   public void saveOrder(CartInfo cartInfo) {
//      Session session = this.sessionFactory.getCurrentSession();
//
//      int orderNum = this.getMaxOrderNum() + 1;
//      Order order = new Order();
//
//      order.setId(UUID.randomUUID().toString());
//      order.setOrderNum(orderNum);
//      order.setOrderDate(new Date());
//      order.setTotal(cartInfo.getAmountTotal());
//
//      UserInfo userInfo = cartInfo.getUserInfo();
//      UserBilling userBilling = new UserBilling();
//      userBilling.setFirstName(userInfo.getFirstName());
//      userBilling.setLastName(userInfo.getLastName());
//      userBilling.setStreetAddress(userInfo.getStreetAddress());
//      userBilling.setCity(userInfo.getCity());
//      userBilling.setState(userInfo.getState());
//      userBilling.setZipcode(userInfo.getZipcode());
//      userBilling.setEmail(userInfo.getEmail());
//      userBilling.setPhoneNumber(userInfo.getPhone());
//
//      session.persist(order);
//
//      List<CartLineInfo> lines = cartInfo.getCartLines();
//
//      for (CartLineInfo line : lines) {
//         OrderDetail detail = new OrderDetail();
//         detail.setOrder(order);
//         detail.setQuantity(line.getQuantity());
//         detail.setPrice(line.getSongInfo().getPrice());
//         detail.setQuantityTotal(line.getQuantity());
//
//         Integer id = line.getSongInfo().getId();
//         Song song = songService.getSongById(id);
//         detail.setSong(song);
//
//         session.persist(detail);
//      }
//
//      // Order Number!
//      cartInfo.setOrderNum(orderNum);
//      // Flush
//      session.flush();
//   }
//
//   public Order findOrder(String orderId) {
//      Session session = this.sessionFactory.getCurrentSession();
//      return session.find(Order.class, orderId);
//   }
//
//   public OrderInfo getOrderInfo(String orderId) {
//      Order order = this.findOrder(orderId);
//
//      if (order == null) {
//         return null;
//      }
//
//      UserBilling userBilling = order.getUserDetails()
//      UserInfo userInfo = new UserInfo();
//      userInfo.setAllFields(userBilling.getAllFields());
//
//      OrderInfo orderInfo = new OrderInfo(order.getId(), order.getOrderDate(),
//            order.getOrderNum(), order.getTotal());
//      orderInfo.setUserInfo(userInfo);
//
//      return orderInfo;
//   }
//
//   public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
//      String sql = "Select new " + OrderDetailInfo.class.getName() //
//            + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
//            + " from " + OrderDetail.class.getName() + " d "//
//            + " where d.order.id = :orderId ";
//
//      Session session = this.sessionFactory.getCurrentSession();
//      Query<OrderDetailInfo> query = session.createQuery(sql, OrderDetailInfo.class);
//      query.setParameter("orderId", orderId);
//
//      return query.getResultList();
//   }
//}
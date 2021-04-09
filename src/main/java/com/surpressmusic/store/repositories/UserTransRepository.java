package com.surpressmusic.store.repositories;

import com.surpressmusic.store.entity.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public class UserTransRepository {

   @Autowired
   private SessionFactory sessionFactory;

   public User findUser(String userName) {
      Session session = this.sessionFactory.getCurrentSession();
      return session.find(User.class, userName);
   }
}

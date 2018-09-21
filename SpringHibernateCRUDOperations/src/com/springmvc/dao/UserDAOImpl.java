package com.springmvc.dao;

import java.util.List;

import org.apache.catalina.connector.Request;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springmvc.model.User;

public class UserDAOImpl implements UserDAO {

	SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=sessionFactory.openSession();
	
	@Override
	public void addUser(User user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}

	@Override
	public List<User> getAllUsers() {
		session.beginTransaction();
		Query query=session.createQuery("from User");
		List<User> user_list=query.list();
		
		return user_list;
	}

	public void sessionClose()
	{
		session.close();
	}

	@Override
	public void deleteUser(int id) {
		session.beginTransaction();
		User user=(User) session.get(User.class, id);
		if(user!=null)
		{
			session.delete(user);
		}
		else
		{
			System.out.println("User Object Not Found");
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateUser(int id,User user) {
		session.beginTransaction();
		User olduser=(User) session.get(User.class, id);
		if(user!=null)
		{
			olduser.setName(user.getName());
			olduser.setAge(user.getAge());
			session.update(olduser);
		}
		else
		{
			System.out.println("User Object Not Found");
		}
		session.getTransaction().commit();
	}
}

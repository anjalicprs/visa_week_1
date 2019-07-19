package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext 
	private EntityManager em;


	@Override
	public List<Hotel> findHotels(String criteria) {
		TypedQuery<Hotel> query = em.createQuery("from Hotel where country like :s", Hotel.class);
		query.setParameter("s", "%" + criteria + "%");
		return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
//		String jpql = "select u from User u where u.email= '";
//		jpql+=email;
//		jpql+="' and u.password= '";
//		jpql+=password;
//		jpql+="'";
		TypedQuery<User> query = em.createQuery("from User where email= :e and password= :p", User.class);
		query.setParameter("e", email);
		query.setParameter("p", password);
		return query.getResultList().get(0);
	}

	@Override
	public long createBooking(Booking booking) {
		em.persist(booking);
		return booking.getId();
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
//		String jpql = "select b from Booking b where b.user= '";
//		jpql+=user;
//		jpql+="'";
		TypedQuery<Booking> query = em.createQuery("from Booking where user= :u", Booking.class);
		query.setParameter("u", user);
		return query.getResultList();
	}

}

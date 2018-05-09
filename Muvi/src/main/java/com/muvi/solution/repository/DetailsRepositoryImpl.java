package com.muvi.solution.repository;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.muvi.solution.entity.Email;
import com.muvi.solution.entity.Passport;
import com.muvi.solution.entity.Phone;

@Repository
@Transactional
public class DetailsRepositoryImpl implements DetailsRepository {
	private static final Logger logger = LoggerFactory.getLogger(DetailsRepositoryImpl.class);
	private SessionFactory sessionFactory;

	@Override
	public void addDataToDB(String email, long phone, String passport) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Email.class)
				.addAnnotatedClass(Passport.class).addAnnotatedClass(Phone.class);
		sessionFactory = configuration.buildSessionFactory();
		CompletableFuture<Void> c1 = CompletableFuture.supplyAsync(() -> saveEmail(email))
				.thenAccept(r -> queryEmail());
		CompletableFuture<Void> c2 = CompletableFuture.supplyAsync(() -> savePhone(phone))
				.thenAccept(r -> queryPhone());
		CompletableFuture<Void> c3 = CompletableFuture.supplyAsync(() -> savePassport(passport))
				.thenAccept(r -> queryPassport());
		CompletableFuture<Void> c = CompletableFuture.allOf(c1, c2, c3);
		try {
			c.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void queryPassport() {
		logger.info("Passport Data addition accomplished  ++++++++++" + System.currentTimeMillis());

	}

	private void queryPhone() {
		logger.info("Phone Data addition accomplished  ++++++++++" + System.currentTimeMillis());
	}

	private void queryEmail() {
		logger.info("Email Data addition accomplished  ++++++++++" + System.currentTimeMillis());

	}

	private Passport savePassport(String passport) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Passport passportObject = new Passport(passport, new Date());
		session.save(passportObject);
		tx.commit();
		session.close();
		return passportObject;
	}

	private Phone savePhone(long phone) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Phone phoneObject = new Phone(phone, new Date());
		session.save(phoneObject);
		tx.commit();
		session.close();
		return phoneObject;
	}

	private Email saveEmail(String email) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Email emailObject = new Email(email, new Date());
		session.save(emailObject);
		tx.commit();
		session.close();
		return emailObject;
	}

}

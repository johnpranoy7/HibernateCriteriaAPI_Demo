package com.john.demo.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.john.demo.bean.Entity;

@Repository
public class CriteriaExecutor {

	/*
	 * public static Session getCurrentSession() { // Hibernate 5.4 SessionFactory
	 * example without XML Map<String, String> settings = new HashMap<>();
	 * settings.put("connection.driver_class", "oracle.jdbc.OracleDriver");
	 * settings.put("dialect", "org.hibernate.dialect.Oracle12cDialect");
	 * settings.put("hibernate.connection.url",
	 * "jdbc:oracle:thin:@//localhost:1521/dummy");
	 * settings.put("hibernate.connection.username", "root");
	 * settings.put("hibernate.connection.password", "toor");
	 * settings.put("hibernate.current_session_context_class", "thread");
	 * settings.put("hibernate.show_sql", "true");
	 * settings.put("hibernate.format_sql", "true");
	 * 
	 * ServiceRegistry serviceRegistry = new
	 * StandardServiceRegistryBuilder().applySettings(settings).build();
	 * 
	 * MetadataSources metadataSources = new MetadataSources(serviceRegistry); //
	 * metadataSources.addAnnotatedClass(Player.class); Metadata metadata =
	 * metadataSources.buildMetadata();
	 * 
	 * // here we build the SessionFactory (Hibernate 5.4) SessionFactory
	 * sessionFactory = metadata.getSessionFactoryBuilder().build(); Session session
	 * = sessionFactory.getCurrentSession(); return session; }
	 */

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpademo");
		return emf.createEntityManager();
	}

	public List<Entity> getAllEntities() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		Session session = entityManager.unwrap(org.hibernate.Session.class);
		Criteria criteria = session.createCriteria(Entity.class);
		List<Entity> list = criteria.list();
		if (tx.isActive()) {
			tx.commit();
		}
		return list;
	}
	
	public List<Entity> getAllEntitiesProjections() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		Session session = entityManager.unwrap(org.hibernate.Session.class);
		Criteria criteria = session.createCriteria(Entity.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("ownedBy"));
		criteria.setProjection(projectionList);
		List<Entity> list = criteria.list();
		if (tx.isActive()) {
			tx.commit();
		}
		return list;
	}

	public Entity getAEntity(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		Session session = entityManager.unwrap(org.hibernate.Session.class);
		Criteria criteria = session.createCriteria(Entity.class);
		criteria.add(Restrictions.eq("entityId", id));
		Entity entity = (Entity) criteria.uniqueResult();
		if (tx.isActive()) {
			tx.commit();
		}
		return entity;
	}
	
	public List<Entity> getAllEntitieswithOwnership() {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		Session session = entityManager.unwrap(org.hibernate.Session.class);
		Criteria criteria = session.createCriteria(Entity.class);
		criteria.createCriteria("ownedBy");
		List<Entity> list = criteria.list();
		if (tx.isActive()) {
			tx.commit();
		}
		return list;
	}
	
}

package com.pratiti.component;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component("carPartsInv4")
public class CarPartsInventoryImpl4 implements CarPartsInventory{		//since this class is communicating with database is called DAO calss
	
	@PersistenceContext          //here we do not use @Autowired//but this is dependency injection
	private EntityManager em;
	
	@Transactional  // this is for transaction begin and commit code
	public void addNewPart(CarPart carpart) {
		em.persist(carpart);
	}
	
	
	public List<CarPart> getAvailableParts(){            //we can also write as
		String ql = "select c from CarPart c ";         //return em
		Query q = em.createQuery(ql);                     //        .createQuery("select c from CarPart c", CarPart.class)
		List<CarPart> list = q.getResultList();          //         .getResultList();
		return list;
	}
	
}

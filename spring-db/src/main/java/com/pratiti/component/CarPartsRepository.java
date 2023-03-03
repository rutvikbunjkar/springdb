package com.pratiti.component;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarPartsRepository extends CrudRepository<CarPart, Integer>{          //this is a dao file since it is speaking with 
	
	@Query("select c from CarPart c where c.car_model = ?1")  // like this we can also write our custom query if compiler is unable to write query for us due to bad naming convention 
	public Iterable<CarPart> findByCar_model(String model);  //here findByCarModel it should have been like this because we use the attribute name instead of column name
	                                                          //actually attribute name should have been carModel 
	                                                          //that ?1 is like placeholder so it will take value from first argument of method to which it is bind
	
}

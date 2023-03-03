package App;
 
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pratiti.component.CarPart;
import com.pratiti.component.CarPartsInventory;
import com.pratiti.component.CarPartsRepository; 

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("mySpringConfig.xml");
		CarPartsRepository cpRepo =  ctx.getBean(CarPartsRepository.class);
		//Entity class objects are not given to spring 
		CarPart c = new CarPart();
		c.setPart_name("nana");
		c.setCar_model("aapdipapdi");
		c.setPrice(878473);
		c.setQuantity(46);
		
		cpRepo.save(c);
		
//		List<CarPart> list = car.getAvailableParts();
		for(CarPart ca: cpRepo.findAll()) {
			System.out.println(ca.getPart_no());
			System.out.println(ca.getPart_name());
			System.out.println(ca.getCar_model());
			System.out.println(ca.getPrice());
			System.out.println(ca.getQuantity());
		}
		
		for(CarPart ca: cpRepo.findByCar_model("spider")) {
			System.out.println(ca.getPart_no());
			System.out.println(ca.getPart_name());
			System.out.println(ca.getCar_model());
			System.out.println(ca.getPrice());
			System.out.println(ca.getQuantity());
		}
	}
}

package learn.spring_boot.hands_on;

import learn.spring_boot.hands_on.domain.Car;
import learn.spring_boot.hands_on.domain.Owner;
import learn.spring_boot.hands_on.domain.User;
import learn.spring_boot.hands_on.repository.CarRepository;
import learn.spring_boot.hands_on.repository.OwnerRepository;
import learn.spring_boot.hands_on.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class HandsOnApplication {

 	public static final Logger logger = LoggerFactory.getLogger(HandsOnApplication.class);

	 @Autowired
	 private OwnerRepository ownerRepository;

	 @Autowired
	 private CarRepository carRepository;

	 @Autowired
	 private UserRepository userRepository;

	 public static void main(String[] args) throws Exception {
		SpringApplication.run(HandsOnApplication.class, args);



		logger.info("Application Started");

	}


	@Bean
	CommandLineRunner runner(){
		 return args -> {
			 Owner owner1 = new Owner("Jane","Doe");
			 ownerRepository.save(owner1);
			 Owner owner2 = new Owner("Eddie","Murphy");
			 ownerRepository.save(owner2);

			 Car car1 = new Car("Honda","Civic","Purple","12J-ADD", 2012, 25000, owner1);
			 carRepository.save(car1);
			 Car car2 = new Car("Hummer","H3","Gold","123-HBD", 2010, 15000, owner1);
			 carRepository.save(car2);
			 Car car3 = new Car("Toyota","Camry","Silver","OGG-343", 2022, 45000, owner2);
			 carRepository.save(car3);
			 Car car4 = new Car("Tesla","Y","Red","200-AJA", 2022, 70000, owner1);
			 carRepository.save(car4);
			 Car car5 = new Car("Mitsubishi","Elantra","Brown","114-DBD", 2015, 35000, owner2);
			 carRepository.save(car5);


			 userRepository.save(new User("user","$2a$12$cBn9j7d6aY65n46y7xnURuBYBLBODMRoK5AkzdeedM6mH82LgRZti","USER"));

			 userRepository.save(new User("admin","$2a$12$cBn9j7d6aY65n46y7xnURuBYBLBODMRoK5AkzdeedM6mH82LgRZti","ADMIN"));

		 };
	}

}

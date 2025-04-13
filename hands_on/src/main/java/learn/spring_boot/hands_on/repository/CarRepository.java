package learn.spring_boot.hands_on.repository;

import learn.spring_boot.hands_on.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestController
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByColor(@Param("color") String color);

    List<Car> findByYear(@Param("year") int year);
}

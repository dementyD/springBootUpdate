package spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM cars LIMIT :limit", nativeQuery = true)
    List<Car> getCarLimit(@Param("limit") int count);
}



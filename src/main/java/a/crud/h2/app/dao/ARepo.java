package a.crud.h2.app.dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import a.crud.h2.app.model.Employee;
import reactor.core.publisher.Flux;

@Repository
public interface ARepo extends R2dbcRepository<Employee, Long> { // ReactiveCrudRepository

    @Query("SELECT * FROM employees WHERE last_name = :lastname")
    Flux<Employee> findByLastName(String lastName);
}

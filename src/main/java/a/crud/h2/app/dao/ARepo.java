package a.crud.h2.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import a.crud.h2.app.model.Employee;

@Repository
public interface ARepo extends JpaRepository<Employee, Long> {

}

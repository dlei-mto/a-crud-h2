package a.crud.h2.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a.crud.h2.app.dao.ARepo;
import a.crud.h2.app.model.Employee;

@Service
public class AService {

    @Autowired
    private ARepo repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return repo.findById(id);
    }

    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    public void delete(Employee emp) {
        repo.delete(emp);
    }
}

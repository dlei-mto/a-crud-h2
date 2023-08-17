package a.crud.h2.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.crud.h2.app.dao.ARepo;
import a.crud.h2.app.exception.ResourceNotFoundException;
import a.crud.h2.app.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ARepo repo;

    public Flux<Employee> getAll() {
        return repo.findAll();
    }

    public Mono<Employee> getById(Long id) {
        return repo.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Employee not found for this id :: " + id))) // defaultIfEmpty
                .doOnError(err -> logger.info("[ Find Exception ] {}", err.getMessage()));
    }

    @Transactional
    public Mono<Employee> save(Employee emp) {
        return repo.save(emp);
    }

    public Mono<Employee> update(Long id, Employee emp) {
        return getById(id)
                // .onErrorResume((err) -> {
                //     return Mono.empty();
                // })
                .flatMap(e -> {
                    logger.info("\n\n[ Entity ] {}\n", e);
                    e.setEmail(emp.getEmail());
                    e.setLastName(emp.getLastName());
                    e.setFirstName(emp.getFirstName());
                    return repo.save(e);
                });
    }

    public Mono<Employee> delete(Long id) {
        // repo.deleteById(id)
        return getById(id)
                .doOnError(err -> logger.info("[ Delete Exception ] {}", err.getMessage()))
                .flatMap(e -> repo.delete(e).thenReturn(e));
    }

    public Flux<Employee> getByLastName(String lastName) {
        return repo.findByLastName(lastName);
    }
}

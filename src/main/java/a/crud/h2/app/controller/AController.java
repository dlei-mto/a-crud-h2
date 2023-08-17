package a.crud.h2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import a.crud.h2.app.model.Employee;
import a.crud.h2.app.service.AService;
import a.crud.h2.app.util.ApiPaths;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping(ApiPaths.BASE_PATH)
public class AController {

    @Autowired
    private AService service;

    @GetMapping(ApiPaths.EMPLOYEE_ENDPOINT)
    public Flux<Employee> getAllEmployees() {
        return service.getAll();
    }

    @GetMapping(ApiPaths.EMPLOYEE_ENDPOINT + "/{id}")
    public ResponseEntity<Mono<Employee>> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        return ResponseEntity.ok().body(service.getById(employeeId));
    }

    @PostMapping(ApiPaths.EMPLOYEE_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return service.save(employee);
    }

    @PutMapping(ApiPaths.EMPLOYEE_ENDPOINT + "/{id}")
    // @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Mono<Employee>> updateEmployee(@PathVariable(value = "id") Long employeeId,
            @Valid @RequestBody Employee employeeDetails) {
        return ResponseEntity.ok(service.update(employeeId, employeeDetails));
    }

    @DeleteMapping(ApiPaths.EMPLOYEE_ENDPOINT + "/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        return service.delete(employeeId);
    }

    @GetMapping(ApiPaths.EMPLOYEE_ENDPOINT + "/lname/{name}")
    public Flux<Employee> getEmployees(@PathVariable(value = "name") String lastName) {
        return service.getByLastName(lastName);
    }
}

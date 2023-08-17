package a.crud.h2.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Size;

// @Entity
@Table(name = Employee.TABLE_NAME) // jakarta.persistence.* won't work
public class Employee {
    public static final String TABLE_NAME = "employees";

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column("first_name") // jakarta.persistence.* won't work
    @Size(max = 200, message = "max 200")
    private String firstName;

    @Column("last_name") // jakarta.persistence.* won't work
    @Size(max = 200, message = "max 200")
    private String lastName;

    @Column("email_address") // jakarta.persistence.* won't work
    @Size(max = 200, message = "max 200")
    private String email;

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}

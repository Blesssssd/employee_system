package eam.app.employee_system.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "budget", nullable = false, length = 50)
    private double budget;

    @Column(name = "expenses", nullable = false, length = 50)
    private double expenses;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Office() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    
}

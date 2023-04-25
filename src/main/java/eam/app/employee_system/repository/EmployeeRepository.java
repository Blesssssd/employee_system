package eam.app.employee_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eam.app.employee_system.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}


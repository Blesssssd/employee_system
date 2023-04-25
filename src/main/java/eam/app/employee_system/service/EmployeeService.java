package eam.app.employee_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eam.app.employee_system.models.Employee;

@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee saveEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(Long id);
}

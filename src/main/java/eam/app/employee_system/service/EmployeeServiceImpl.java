package eam.app.employee_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eam.app.employee_system.models.Employee;
import eam.app.employee_system.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

}

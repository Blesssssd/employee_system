package eam.app.employee_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eam.app.employee_system.models.Employee;
import eam.app.employee_system.service.EmployeeService;
import eam.app.employee_system.service.OfficeService;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OfficeService officeService;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/to_list";
    }

    @GetMapping("new/employee")
    public String newEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("offices", officeService.getAllOffices());
        return "employee/new";
    }

    @PostMapping("/employees")
    public String saveEmployee(@Valid Employee employee, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("offices", officeService.getAllOffices());
            return "employees/new";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";

    }

    @GetMapping("/employee/see/{id}")
    public String seeEmployee(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee/see";
        } else {
            return "redirect:/employees";
        }
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("offices", officeService.getOfficeById(id));
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee/edit";
    }

    @PostMapping("/employee/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
        Employee aux = employeeService.getEmployeeById(id);
        aux.setId(id);
        aux.setCode(employee.getCode());
        aux.setNif(employee.getNif());
        aux.setName(employee.getName());
        aux.setSurname1(employee.getSurname1());
        aux.setSurname2(employee.getSurname2());
        aux.setOffice(employee.getOffice());

        employeeService.updateEmployee(aux);
        return "redirect:/employees";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}

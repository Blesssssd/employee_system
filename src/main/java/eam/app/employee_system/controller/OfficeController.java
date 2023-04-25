package eam.app.employee_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eam.app.employee_system.models.Office;
import eam.app.employee_system.service.OfficeService;

@Controller
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @GetMapping({ "/offices", "/" })
    public String listOffices(Model model) {
        model.addAttribute("offices", officeService.getAllOffices());
        return "office/to_list";
    }

    @GetMapping("/office/see/{id}")
    public String seeOffice(@PathVariable("id") long id, Model model) {
        Office office = officeService.getOfficeById(id);
        if (office != null) {
            model.addAttribute("office", office);
            return "office/see";
        } else {
            return "redirect:/offices";
        }
    }

    @GetMapping("/new")
    public String newOffice(Model model) {
        Office office = new Office();
        model.addAttribute("office", office);
        return "office/new";
    }

    @PostMapping("/offices")
    public String saveNewOffice(@ModelAttribute("office") Office office) {
        officeService.saveOffice(office);
        return "redirect:/offices";
    }

    @GetMapping("/office/edit/{id}")
    public String editOffice(@PathVariable("id") Long id, Model model) {
        model.addAttribute("office", officeService.getOfficeById(id));
        return "office/edit";
    }

    @PostMapping("/offices/{id}")
    public String update_Office(@PathVariable Long id, @ModelAttribute("office") Office office,
            Model model) {
        Office officeExistente = officeService.getOfficeById(id);
        officeExistente.setId(id);
        officeExistente.setName(office.getName());
        officeExistente.setCode(office.getCode());
        officeExistente.setBudget(office.getBudget());
        officeExistente.setExpenses(office.getExpenses());
        officeService.updateOffice(officeExistente);
        return "redirect:/offices";
    }

    @GetMapping("/office/delete/{id}")
    public String delete_Office(@PathVariable("id") Long id) {
        officeService.deleteOffice(id);
        return "redirect:/offices";
    }

    // @GetMapping("/employees-office")
    // public String listEmployees(@PathVariable("id") Long id, Model model) {
    //     model.addAttribute("employees_office", officeService.getEmployeeOfTheOffice(id));
    //     return "office/list_employee";
    // }
}

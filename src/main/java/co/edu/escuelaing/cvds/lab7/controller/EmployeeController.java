package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/crud")
    public String getEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("list", employees);
        return "crud";
    }

    @GetMapping("/newPage")
    public String newEmployee() {
        return "newPage";
    }

    @PostMapping("/newPage/confirm")
    public String addEmployee(@RequestParam int employeeId, String firstName,String lastName, String role, String salary){
        employeeService.addEmployee(employeeId, firstName, lastName, role, salary);
        return "redirect:/crud";
    }

    @PostMapping("/update")
    public String updateEmployee(Model model, String employeeId){
        model.addAttribute("employeeId", employeeId);
        return "update";
    }

    @PostMapping("/update/confirm")
    public String updateEmployee(@RequestParam int employeeId, String firstName, String lastName) {
        employeeService.updateEmployee(employeeId, firstName, lastName);
        return "redirect:/crud";
    }

    @PostMapping("/delete/confirm")
    public String updateEmployee(@RequestParam int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/crud";
    }
}

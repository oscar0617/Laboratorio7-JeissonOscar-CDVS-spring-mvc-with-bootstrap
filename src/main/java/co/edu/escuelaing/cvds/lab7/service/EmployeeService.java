package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Adds the employe to the data base
     * @param employeeId
     * @param firstName
     * @param lastName
     * @param role
     * @param salary
     */
    public void addEmployee(String employeeId, String firstName, String lastName, String role, Double salary) {
        Employee empleado = new Employee(employeeId, firstName, lastName, role, salary);
        employeeRepository.save(empleado);
    }

    public void getEmployee(String employeeId) {
        employeeRepository.findByEmployeeId(employeeId).get(1);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public void updateEmployee(Employee empleado){
        if (employeeRepository.findByEmployeeId(empleado.getEmployeeId()).size() == 0) {
            employeeRepository.save(empleado);
        }
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }


}

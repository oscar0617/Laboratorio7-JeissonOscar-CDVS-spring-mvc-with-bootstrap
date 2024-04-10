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
    public void addEmployee(int employeeId, String firstName, String lastName, String role, String salary) {
        double salaryDoble = 0;
        try{
            salaryDoble = Double.parseDouble(salary);
        }catch(Exception e){
            salaryDoble = 100;
        }
        Employee empleado = new Employee(employeeId, firstName, lastName, role, salaryDoble);
        employeeRepository.save(empleado);
    }

    public Employee getEmployee(int employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).get(0);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public void updateEmployee(int id, String firstName, String lastName){
        Employee empleado = getEmployee(id);
        empleado.setFirstName(firstName);
        empleado.setLastName(lastName);
        employeeRepository.save(empleado);
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }


}

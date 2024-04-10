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
    public void addEmployee(String employeeId, String firstName, String lastName, String role, String salary) {
        double salaryDoble = 0;
        int id = 0;
        try{
            salaryDoble = Double.parseDouble(salary);
            id = Integer.parseInt(employeeId);
        }catch(Exception e){
            salaryDoble = 100;
            id = 0;
        }
        Employee empleado = new Employee(id, firstName, lastName, role, salaryDoble);
        employeeRepository.save(empleado);
    }

    public Employee getEmployee(int employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).get(0);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public void updateEmployee(String id, String firstName, String lastName){
        int idInt = Integer.parseInt(id);
        Employee empleado = getEmployee(idInt);
        empleado.setFirstName(firstName);
        empleado.setLastName(lastName);
        employeeRepository.save(empleado);
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }


}

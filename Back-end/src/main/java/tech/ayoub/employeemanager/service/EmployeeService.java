package tech.ayoub.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ayoub.employeemanager.exception.UserNotFoundException;
import tech.ayoub.employeemanager.model.Employee;
import tech.ayoub.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository empRepo;

    @Autowired
    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return empRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return empRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return empRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return empRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User By id"+id+"was not found"));
    }
    public void deleteEmployee(Long id){
        empRepo.deleteEmployeeById(id);
    }
}

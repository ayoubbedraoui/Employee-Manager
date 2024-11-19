package tech.ayoub.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ayoub.employeemanager.model.Employee;
import tech.ayoub.employeemanager.repository.EmployeeRepository;

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
    }
}

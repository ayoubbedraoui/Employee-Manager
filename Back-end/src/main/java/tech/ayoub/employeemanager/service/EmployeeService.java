package tech.ayoub.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ayoub.employeemanager.DTO.EmployeeRequest;
import tech.ayoub.employeemanager.DTO.EmployeeResponse;
import tech.ayoub.employeemanager.exception.UserNotFoundException;
import tech.ayoub.employeemanager.model.Employee;
import tech.ayoub.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository empRepo;

    @Autowired
    public EmployeeService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setImageUrl(employeeRequest.getImageUrl());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        Employee savedEmp = empRepo.save(employee);
        return mapToEmployeeResponse(savedEmp);
    }
    public List<EmployeeResponse> findAllEmployees(){
        List<Employee> employees = empRepo.findAll();
        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest){
        Optional<Employee> employee = empRepo.findById(id);
        employee.get().setName(employeeRequest.getName());
        employee.get().setEmail(employeeRequest.getEmail());
        employee.get().setJobTitle(employeeRequest.getJobTitle());
        employee.get().setPhone(employeeRequest.getPhone());
        employee.get().setImageUrl(employeeRequest.getImageUrl());

        Optional<Employee> updatedEmployee = Optional.of(empRepo.save(employee.get()));
        return mapToEmployeeResponse(updatedEmployee.orElse(null));
    }
    public EmployeeResponse findEmployeeById(Long id){
        Employee emp = empRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User By id"+id+"was not found"));
        return mapToEmployeeResponse(emp);
    }
    public void deleteEmployee(Long id){
        empRepo.deleteEmployeeById(id);
    }
    private EmployeeResponse mapToEmployeeResponse(Employee employee){
        EmployeeResponse response = new EmployeeResponse();
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setJobTitle(employee.getJobTitle());
        response.setPhone(employee.getPhone());
        response.setImageUrl(employee.getImageUrl());
        return response;
    }
}

package tech.ayoub.employeemanager.service;

import tech.ayoub.employeemanager.DTO.EmployeeRequest;
import tech.ayoub.employeemanager.DTO.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
    List<EmployeeResponse> findAllEmployees();
    EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest);
    EmployeeResponse findEmployeeById(Long id);
    void deleteEmployee(Long id);
}

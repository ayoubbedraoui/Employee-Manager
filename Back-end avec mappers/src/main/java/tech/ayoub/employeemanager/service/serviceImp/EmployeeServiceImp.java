package tech.ayoub.employeemanager.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ayoub.employeemanager.DTO.EmployeeRequest;
import tech.ayoub.employeemanager.DTO.EmployeeResponse;
import tech.ayoub.employeemanager.exception.UserNotFoundException;
import tech.ayoub.employeemanager.mappers.EmployeeMapper;
import tech.ayoub.employeemanager.model.Employee;
import tech.ayoub.employeemanager.repository.EmployeeRepository;
import tech.ayoub.employeemanager.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository empRepo;
    private final EmployeeMapper empMap;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository empRepo,EmployeeMapper empMap) {
        this.empRepo = empRepo;
        this.empMap = empMap;
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){
        Employee employee = empMap.toEntity(employeeRequest);
        employee.setEmployeeCode(UUID.randomUUID().toString());
        Employee savedEmp = empRepo.save(employee);
        return empMap.toResponse(savedEmp);
    }

    @Override
    public List<EmployeeResponse> findAllEmployees(){
        List<Employee> employees = empRepo.findAll();
        return employees.stream().map(empMap::toResponse).toList();
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest){
        Employee employee = empRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User By id"+id+"was not found"));;
        empMap.updateEntity(employeeRequest, employee);
        Employee updatedEmployee = empRepo.save(employee);
        return empMap.toResponse(updatedEmployee);
    }
    public EmployeeResponse findEmployeeById(Long id){
        Employee emp = empRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User By id"+id+"was not found"));
        return empMap.toResponse(emp);
    }
    public void deleteEmployee(Long id){
        empRepo.deleteEmployeeById(id);
    }
}

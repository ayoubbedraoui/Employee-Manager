package tech.ayoub.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ayoub.employeemanager.DTO.EmployeeRequest;
import tech.ayoub.employeemanager.DTO.EmployeeResponse;
import tech.ayoub.employeemanager.service.EmployeeService;
import tech.ayoub.employeemanager.service.serviceImp.EmployeeServiceImp;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        List<EmployeeResponse> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Long id){
        EmployeeResponse employee = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse newEmployee = employeeService.addEmployee(employeeRequest);
        return ResponseEntity.ok(newEmployee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.updateEmployee(id, employeeRequest);
        return ResponseEntity.ok(employeeResponse);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}

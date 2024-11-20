package tech.ayoub.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ayoub.employeemanager.DTO.EmployeeRequest;
import tech.ayoub.employeemanager.DTO.EmployeeResponse;
import tech.ayoub.employeemanager.service.serviceImp.EmployeeServiceImp;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeResource(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        List<EmployeeResponse> employees = employeeServiceImp.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Long id){
        EmployeeResponse employee = employeeServiceImp.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse newEmployee = employeeServiceImp.addEmployee(employeeRequest);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeServiceImp.updateEmployee(id, employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

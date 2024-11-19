package tech.ayoub.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ayoub.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

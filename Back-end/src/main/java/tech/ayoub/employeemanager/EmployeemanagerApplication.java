package tech.ayoub.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ayoub.employeemanager.model.Employee;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
		System.out.println("test");

	}

}

package tech.ayoub.employeemanager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tech.ayoub.employeemanager.DTO.EmployeeRequest;
import tech.ayoub.employeemanager.DTO.EmployeeResponse;
import tech.ayoub.employeemanager.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequest employeeRequest);

    EmployeeResponse toResponse(Employee employee);

    void updateEntity(EmployeeRequest employeeRequest, @MappingTarget Employee employee);
}

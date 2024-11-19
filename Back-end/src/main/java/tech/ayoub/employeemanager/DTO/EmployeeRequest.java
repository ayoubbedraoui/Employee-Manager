package tech.ayoub.employeemanager.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
}

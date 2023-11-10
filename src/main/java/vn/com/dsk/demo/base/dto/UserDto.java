package vn.com.dsk.demo.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import vn.com.dsk.demo.feature.model.Branch;

import java.util.Date;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private String id;
    private String username;
    private String email;
    private String role;
    private Branch branch;
    private String fullName;
    private String address;
    private Date dob;
}

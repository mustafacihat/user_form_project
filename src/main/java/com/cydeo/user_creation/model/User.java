package com.cydeo.user_creation.model;


import com.cydeo.user_creation.enums.Gender;
import com.cydeo.user_creation.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @NotBlank(message = "First Name is a required field")
    @Size(max = 15, min = 2, message = "First Name must be between 2 and 15 characters long")
    @Pattern(regexp = "[A-Z]\\w*", message = "First Name must starts with Uppercase character")
    private String firstName;

    @NotBlank(message = "Last Name is a required field")
    @Size(max = 15, min = 2, message = "Last Name must be between 2 and 15 characters long")
    @Pattern(regexp = "[A-Z]\\w*", message = "Last Name must starts with Uppercase character")
    private String lastName;

    @NotNull(message = "Age is a required field")
    @Range(max = 120, min = 18, message = "Age must be between 18 and 120 years old")
    private Integer age;

    @Email(message = "Email is a required field")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Provide a suitable email address ex: michael23jordan23@test.com")
    private String email;

    @Valid
    @NotNull
    private SecurityModel securityModel;

    @NotNull(message = "Please select a Gender")
    private Gender gender;

    @NotBlank(message = "Address is a required field")
    @Size(max = 100, min = 10, message ="Address must be between 10 and 100 characters long" )
    private String address;

    @NotNull(message = "State is a required field")
    private State state;

    private Boolean married;


}

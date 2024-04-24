package com.cydeo.user_creation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecurityModel {

    @NotBlank(message = "Nick Name is a required field")
    @Size(max = 15, min = 2, message = "Nick Name must be between 2 and 15 characters long")
    @Pattern(regexp = "[A-Z]\\w*", message = "Nick Name must starts with Uppercase character")
    private String nickName;


    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Contains at least one digit.\n" +
                    "    Contains at least one lowercase letter.\n" +
                    "    Contains at least one uppercase letter.\n" +
                    "    Contains at least one special character from the provided set.\n" +
                    "    Does not contain any whitespace.\n" +
                    "    Is at least 8 characters long.")
    //Contains at least one digit.
    //Contains at least one lowercase letter.
    //Contains at least one uppercase letter.
    //Contains at least one special character from the provided set.
    //Does not contain any whitespace.
    //Is at least 8 characters long.
    private String password;
}

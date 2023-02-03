package com.estore.entity;

import com.estore.validation.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchPassword", message = "The password fields must match")
public class DefaultUser {
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3, message = "Username must be longer than 2 characters")
    private String username;

    @NotNull
    @Size(min = 3, message = "Minimum of 3 character")
    private String firstName;

    @NotNull
    @Size(min = 3, message = "Minimum of 3 character")
    private String lastName;

    @NotNull
    @Size(min = 4, message = "Minimum of 4 character")
    private String password;

    @NotNull
    @Size(min = 4, message = "Minimum of 4 character")
    private String matchPassword;

    @NotNull
    @Email
    private String email;
}

package net.illa.accountservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String firstname;
    private String lastName;
    private String email;
}

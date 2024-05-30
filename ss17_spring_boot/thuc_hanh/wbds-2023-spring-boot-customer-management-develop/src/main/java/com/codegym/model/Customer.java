package com.codegym.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}

package org.akshat.yummy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "addresslineone", nullable = false)
    private String addressLine1;

    @Column(name = "addresslinetwo", nullable = false)
    private String addressLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "pincode", nullable = false)
    private String pincode;
}

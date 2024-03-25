package org.tesinitsyn.recipefeedrestapi.user.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String roles;
}

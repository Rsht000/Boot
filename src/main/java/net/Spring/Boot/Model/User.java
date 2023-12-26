package net.Spring.Boot.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String LastName;
    @Column(name = "age")
    private int age;

}

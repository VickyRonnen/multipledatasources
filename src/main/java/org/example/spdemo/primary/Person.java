package org.example.spdemo.primary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    private String id;
    private String name;

}

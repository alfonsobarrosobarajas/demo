package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matricula", columnDefinition = "varchar(20)", nullable = false)
    private String matricula;
    @Column(name = "first_name", columnDefinition = "varchar(60)", nullable = false)
    private String firstName;
    @Column(name = "last_name", columnDefinition = "varchar(60)", nullable = false)
    private String lastName;

}

package com.example.schooljpa.school;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "school")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "students_amount")
    private int studentsAmount;
}

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String studentName;
    private int studentRegisterNo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "student_id") // This creates the foreign key in Mark table
    private Student student;


    @ElementCollection
    @MapKeyColumn(name = "subject")
    @Column(name = "marks")
    private Map<String, Integer> subjectMarks;


}

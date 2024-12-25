package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quarterly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;
    private int studentRegisterNo;
    private String studentClass;

    @ElementCollection
    private List<SubjectMarks> subjectMarks; // List of subjects and their marks

    private int totalMark; // Store total marks of the exam

    // Method to calculate the total marks for the Quarterly exam
    public void calculateTotalMark() {
        this.totalMark = subjectMarks.stream().mapToInt(SubjectMarks::getMark).sum();
    }
}
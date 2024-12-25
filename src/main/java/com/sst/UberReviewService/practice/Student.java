package com.sst.UberReviewService.practice;

import com.sst.UberReviewService.models.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Student extends BaseModel {

    private String name;

    private String rollNo;


    @JoinTable(
    name="course_students",
    joinColumns = @JoinColumn(name="student_id"),
    inverseJoinColumns = @JoinColumn(name="course_id")
    )
    @ManyToMany
    private List<Course> courses=new ArrayList<>();

}

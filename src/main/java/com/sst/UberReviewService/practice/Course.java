package com.sst.UberReviewService.practice;

import com.sst.UberReviewService.models.BaseModel;
import jakarta.persistence.Entity;
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
public class Course extends BaseModel {

    private String name;

    @ManyToMany
    private List<Student> students=new ArrayList<>();
}

package com.ibrahimbayburtlu.springdemo.mvc;

import com.ibrahimbayburtlu.springdemo.mvc.validation.CourseCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        return theCode != null ? theCode.startsWith(coursePrefix) : true;
    }
}

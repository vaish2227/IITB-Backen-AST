package com.courses.IITB.controllers;

import com.courses.IITB.Requests.CreateinstanceRequest;
import com.courses.IITB.modal.Course;
import com.courses.IITB.modal.CourseInstance;
import com.courses.IITB.services.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    private final CourseInstanceService courseInstanceService;
    private CreateinstanceRequest createinstanceRequest;

    @Autowired
    public CourseInstanceController(CourseInstanceService courseInstanceService) {
        this.courseInstanceService = courseInstanceService;
    }

    @PostMapping("/addcourseinstance")
    public CourseInstance createCourseInstance(@RequestBody CreateinstanceRequest createinstanceRequest) {
        return courseInstanceService.createCourseInstance(createinstanceRequest);
    }

    @GetMapping("/getcourseinstancelist/{year}/{semester}")
    public List<CourseInstance> getCourseInstancesByYearAndSemester(
            @PathVariable int year,
            @PathVariable int semester
    ) {
        return courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/getcourseinstancelist")
    public List<CourseInstance> getAllCoursesInstances() {return courseInstanceService.getAllCoursesInstances();}



    @GetMapping("/getcourseinstance/{year}/{semester}/{id}")
    public CourseInstance getCourseInstanceByIdAndYearAndSemester(
            @PathVariable int year,
            @PathVariable int semester,
            @PathVariable int id
    ) {
        return courseInstanceService.getCourseInstanceBycourseIdAndYearAndSemester(id, year, semester);
    }

    @Transactional
    @DeleteMapping("/deletecourseinstance/{year}/{semester}/{id}")
    public void deleteCourseInstanceByIdAndYearAndSemester(
            @PathVariable int year,
            @PathVariable int semester,
            @PathVariable int id
    ) {
        courseInstanceService.deleteCourseInstanceByIdAndYearAndSemester(id, year, semester);
    }
}

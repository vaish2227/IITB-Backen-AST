package com.courses.IITB.services;

import com.courses.IITB.Requests.CreateinstanceRequest;
import com.courses.IITB.modal.Course;
import com.courses.IITB.modal.CourseInstance;
import com.courses.IITB.repository.CourseInstanceRepository;
import com.courses.IITB.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    private  CourseInstanceRepository courseInstanceRepository;
    @Autowired
    private CourseRepository courseRepository;



    public CourseInstance createCourseInstance(CreateinstanceRequest createInstanceRequest) {
        // Create a new CourseInstance
        CourseInstance courseInstance = new CourseInstance();

        // Fetch the corresponding Course entity based on createInstanceRequest.getCourseId()
        Course course = courseRepository.findById(createInstanceRequest.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        // Set the Course for the CourseInstance
        courseInstance.setCourseId(course);

        // Set the courseYear and courseSem from the request
        courseInstance.setCourseYear(createInstanceRequest.getCourseYear());
        courseInstance.setCourseSem(createInstanceRequest.getCourseSem());

        // Save the CourseInstance
        return courseInstanceRepository.save(courseInstance);
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByCourseYearAndCourseSem(year, semester);
    }

    public CourseInstance getCourseInstanceBycourseIdAndYearAndSemester(int id, int year, int semester) {
        Optional<CourseInstance> optionalCourseInstance = courseInstanceRepository.findByCourseId_IdAndCourseYearAndCourseSem(id, year, semester);
        return optionalCourseInstance.orElse(null);
    }

    public void deleteCourseInstanceByIdAndYearAndSemester(int id, int year, int semester) {
        courseInstanceRepository.deleteByCourseId_IdAndCourseYearAndCourseSem(id, year, semester);
    }
    public List<CourseInstance> getAllCoursesInstances() {
        return courseInstanceRepository.findAll();
    }

}

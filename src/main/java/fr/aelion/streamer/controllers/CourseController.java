package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.AddCourseDto;
import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.FullCourseDto;
import fr.aelion.streamer.entities.Course;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.CourseService;
import fr.aelion.streamer.services.CourseServiceImpl;
import fr.aelion.streamer.services.exceptions.EmailAlreadyExistsException;
import fr.aelion.streamer.services.exceptions.LoginAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping
    @CrossOrigin
    public List<FullCourseDto> findAll(){
        return service.findAll();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> add(@Valid @RequestBody FullCourseDto course) {
        try{
            Course newCourse= (Course) service.add(course);
            return ResponseEntity.created(null).body(newCourse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}

package fr.aelion.streamer.controllers;

import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")// http://127.0.0.1:8080/api/v1/students
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    @CrossOrigin
    public List<Student> findAll(){

        return studentService.findAll();
    }

    /**
     * POST a new student
     * uri: POST http://127.0.0.1:5000/api/v1/students
     * @param student
     * @return
     */
    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> add(@RequestBody Student student){

        return ResponseEntity.created(null).body(studentService.add(student));
    }
}

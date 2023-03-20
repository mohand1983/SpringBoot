package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.SimpleStudentDto;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")// http://127.0.0.1:8080/api/v1/students
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping()
    @CrossOrigin
    public List<Student> findAll(){

        return studentService.findAll();
    }
    @GetMapping("simple")
    @CrossOrigin
    public List<SimpleStudentDto> findAllSimpleStudent() {
        return this.studentService.findSimpleStudents();
    }
    /**
     * POST a new student
     * uri: POST http://127.0.0.1:5000/api/v1/students
     * @param student
     * @return
     */
    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> add(@RequestBody AddStudentDto student){

        return ResponseEntity.created(null).body(studentService.add(student));
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public Optional<Optional<Student>> findOne(@PathVariable("id") int id) {
        return Optional.ofNullable(this.studentService.findById(id));
    }
    @PostMapping("/create")
    @CrossOrigin
    public Student createStudent(@Valid @RequestBody Student student) {
        return this.studentService.create(student);
    }

    @PutMapping("/update")
    @CrossOrigin
    public Student updateStudent(@RequestBody Student updateStudent) {
        return this.studentService.update(updateStudent);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    public void delete(@PathVariable("id") int studentId) {
        this.studentService.delete(studentId);
    }
}

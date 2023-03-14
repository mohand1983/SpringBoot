package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.SimpleStudentDto;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public List<SimpleStudentDto> findSimpleStudents() {
       return this.findAll()
               .stream()
               .map(s -> {
                   var simpleStudent = new SimpleStudentDto();
                   simpleStudent.setId(s.getId());
                   simpleStudent.setLastName((s.getLastName()));
                   simpleStudent.setFirstName(s.getFirstName());
                   simpleStudent.setEmail(s.getEmail());
                   return simpleStudent;
               }).collect(Collectors.toList());
    }
    public Student add(Student student) {
        student = (Student) repository.save(student);
        return student;
    }

    public Student create(Student studentToCreate) {
        return this.repository.save(studentToCreate);
    }

    public Student update(Student updatedstudent) {
        return this.repository.save(updatedstudent);
    }

    public Page<Student> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Optional<Student> findById(int id) {
        return this.repository.findById(id);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }
}


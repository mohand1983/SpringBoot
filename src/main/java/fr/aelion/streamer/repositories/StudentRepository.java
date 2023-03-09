package fr.aelion.streamer.repositories;

import fr.aelion.streamer.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select id, lastName,firstName, email from Student")
    List<Student> findByIdLastNameFirstNameEmail(Student student);
}

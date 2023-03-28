package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.AddCourseDto;
import fr.aelion.streamer.repositories.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceSimple {
  /*  @Autowired
    private CourseRepository courseRepository;
    public AddCourseDto create(@Valid AddCourseDto addCourseDto) {
        return this.courseRepository.save(addCourseDto);
    }*/
}

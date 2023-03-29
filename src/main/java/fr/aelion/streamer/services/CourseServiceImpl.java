package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.*;
import fr.aelion.streamer.entities.Course;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.repositories.CourseRepository;
import fr.aelion.streamer.services.exceptions.EmailAlreadyExistsException;
import fr.aelion.streamer.services.exceptions.LoginAlreadyExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements  CourseService<Course> {
    @Autowired
    private CourseRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public List<FullCourseDto> findAll(){
        return repository.findAll()
                .stream()
                .map(c->{
                    FullCourseDto fullCourseDto= new FullCourseDto();
                    fullCourseDto.setId(c.getId());
                    fullCourseDto.setTitle(c.getTitle());
                    fullCourseDto.setCreatedAt(c.getCreatedAt());
                    fullCourseDto.setUpdatedAt(c.getUpdatedAt());
                    //make as many moduleDto as needed
                    var modules= c.getModules();
                    for(var module : modules){
                        ModuleDto moduleDto=new ModuleDto();
                        moduleDto.setId(module.getId());
                        moduleDto.setName(module.getName());
                        moduleDto.setObjective(module.getObjective());
                        // media of modules
                        for (var media : module.getMedias()){
                            MediaDto mediaDto = new MediaDto();
                            mediaDto.setId(media.getId());
                            mediaDto.setTitle(media.getTitle());
                            mediaDto.setDuration(media.getDuration());
                            // media type
                            mediaDto.addTypeMediaDto(media.getTypeMedia());
                            moduleDto.addMediaDto(mediaDto);

                        }
                        fullCourseDto.addModule(moduleDto);
                    }
                    return fullCourseDto;
                })
                .collect(Collectors.toList());
    }

    public Course add(FullCourseDto course){
        Course newCourse = modelMapper.map(course, Course.class);
        newCourse = (Course) repository.save(newCourse);

        return newCourse;
    }

    //Delete method

    public void delete(int id) {
        this.repository.deleteById(id);
    }

}

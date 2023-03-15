package fr.aelion.streamer.dto;

import fr.aelion.streamer.entities.Module;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class FullCourseDto {
    private int id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String objective;
    private Set<ModuleDto> modules=new HashSet<>();
    public void addModule(Module module){
        var moduleDto=new ModuleDto();
        moduleDto.setId(moduleDto.getId());
        moduleDto.setName(moduleDto.getName());
        moduleDto.setObjective(moduleDto.getObjective());
        this.modules.add(moduleDto);
    }

}

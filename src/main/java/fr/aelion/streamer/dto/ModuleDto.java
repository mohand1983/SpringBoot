package fr.aelion.streamer.dto;

import fr.aelion.streamer.entities.Media;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ModuleDto {
    private int id;
    private String name;
    private String objective;
    private Set<MediaDto> medias=new HashSet<>();
    public void addMediaDto(MediaDto mediaDto){
        /*var mediaDto=new MediaDto();
        mediaDto.setId(media.getId());
        mediaDto.setTitle(media.getTitle());
        mediaDto.setDuration(media.getDuration());*/
        this.medias.add(mediaDto);
    }

}

package fr.aelion.streamer.dto;
import fr.aelion.streamer.entities.TypeMedia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDto {
    private int id;
    private String title;
    private int duration;
    private TypeMediaDto typeMedia;
    public void addTypeMediaDto(TypeMedia typeMedia){
       var typeMediaDto=new TypeMediaDto();
        typeMediaDto.setId(typeMedia.getId());
        typeMediaDto.setTitle(typeMedia.getTitle());
       this.setTypeMedia(typeMediaDto);
    }

}

package fr.aelion.streamer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String summary;
    @Column(nullable = false)
    private int duration;
    @Column(nullable = false)
    private LocalDate created_at;
    @Column(nullable = false)
    private String url;
    @ManyToOne
    @JoinColumn(name="module_id")
    private Module module;

    @OneToOne
    @JoinColumn(name="type_media_id")
    private TypeMedia typeMedia;


}

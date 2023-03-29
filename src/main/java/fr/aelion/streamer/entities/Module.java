package fr.aelion.streamer.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private String objective;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    } )
    @JoinColumn(name="course_id")
    private Course course;
    @OneToMany(mappedBy = "module")
    private Set<Media> medias;
}

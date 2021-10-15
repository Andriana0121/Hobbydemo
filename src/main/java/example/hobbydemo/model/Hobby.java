package example.hobbydemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hobies")
    public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "text")
    private String text;
}
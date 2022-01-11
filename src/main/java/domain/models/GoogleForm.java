package domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// TODO: think about changing json field

@Getter
@Setter
@Entity
@Table(name = "GOOGLE_FORM")
public class GoogleForm {
    @Id
    @Column(name = "ID")
    private Long id;

    @Lob
    @Column(name = "JSON")
    private String json;

    @Column(name = "NAME")
    private String name;
}

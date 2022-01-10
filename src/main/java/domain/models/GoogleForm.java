package domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "GOOGLE_FORM")
public class GoogleForm {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Lob
    @Column(name = "JSON")
    private String json;

    @Column(name = "NAME")
    private String name;
}

package domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

// TODO: think about changing json field

@Getter
@Setter
@Entity
@Table(name = "GOOGLE_FORM")
public class GoogleForm {
    @Id
    @SequenceGenerator(name = "form_seq", sequenceName = "form_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "form_seq")
    @Column(name = "ID")
    private Long id;

    @Lob
    @Column(name = "JSON")
    private String json;

    @Column(name = "NAME")
    private String name;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;
}

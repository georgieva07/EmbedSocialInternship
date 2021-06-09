package gjeorgieva.anastasija.filter.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;

    public Tag() {
    }

    public Tag(String tag) {
        this.tag = tag;
    }
}

package gjeorgieva.anastasija.filter.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;

    public Photo() {
    }

    public Photo(String photo) {
        this.photo = photo;
    }
}

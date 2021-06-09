package gjeorgieva.anastasija.filter.repository;

import gjeorgieva.anastasija.filter.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}

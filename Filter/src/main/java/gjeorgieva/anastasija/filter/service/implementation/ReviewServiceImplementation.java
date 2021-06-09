package gjeorgieva.anastasija.filter.service.implementation;

import gjeorgieva.anastasija.filter.model.Photo;
import gjeorgieva.anastasija.filter.model.Review;
import gjeorgieva.anastasija.filter.model.Tag;
import gjeorgieva.anastasija.filter.repository.ReviewRepository;
import gjeorgieva.anastasija.filter.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> create(List<Review> reviews) {
        return this.reviewRepository.saveAll(reviews);
    }

    @Override
    public List<Review> listAll() {
        return this.reviewRepository.findAll();
    }
}

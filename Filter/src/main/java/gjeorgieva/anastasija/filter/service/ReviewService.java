package gjeorgieva.anastasija.filter.service;


import gjeorgieva.anastasija.filter.model.Photo;
import gjeorgieva.anastasija.filter.model.Review;
import gjeorgieva.anastasija.filter.model.Tag;

import java.util.Date;
import java.util.List;

public interface ReviewService {

    List<Review> create(List<Review> reviews);
    List<Review> listAll();
}

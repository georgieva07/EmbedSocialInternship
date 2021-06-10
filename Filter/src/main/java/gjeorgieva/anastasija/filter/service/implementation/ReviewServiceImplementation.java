package gjeorgieva.anastasija.filter.service.implementation;

import gjeorgieva.anastasija.filter.model.Review;
import gjeorgieva.anastasija.filter.repository.ReviewRepository;
import gjeorgieva.anastasija.filter.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Review> filter(String orderByRating, String minimumRating, String orderByDate, String prioritizeByText) {
        int minimum = Integer.parseInt(minimumRating);
        //yes, highest first, newest first
        if(prioritizeByText.equals("1") && orderByRating.equals("1") && orderByDate.equals("1")){
            //take the whole db sorted according to the requirements regarding the rating and date
            List<Review> reviewList = this.reviewRepository.highestRatingNewest(minimum);
            //remove the reviews without text
            reviewList=reviewList.stream().filter(r->!r.getReviewFullText().isEmpty()).collect(Collectors.toList());
            //get the reviews without text, sorted according to the requirements regarding the rating and date
            //append them at the end of the list with the sorted reviews with text
            reviewList.addAll(this.reviewRepository.noTextHighestRatingNewest(minimum));
            return reviewList;
        }
        //yes, lowest first, newest first
        if(prioritizeByText.equals("1") && orderByRating.equals("0") && orderByDate.equals("1")) {
            //take the whole db sorted according to the requirements regarding the rating and date
            List<Review> reviewList = this.reviewRepository.lowestRatingNewest(minimum);
            //remove the reviews without text
            reviewList=reviewList.stream().filter(r->!r.getReviewFullText().isEmpty()).collect(Collectors.toList());
            //get the reviews without text, sorted according to the requirements regarding the rating and date
            //append them at the end of the list with the sorted reviews with text
            reviewList.addAll(this.reviewRepository.noTextLowestRatingNewest(minimum));
            return reviewList;
        }
        //yes, highest first, oldest first
        if(prioritizeByText.equals("1") && orderByRating.equals("1") && orderByDate.equals("0")){
            //take the whole db sorted according to the requirements regarding the rating and date
            List<Review> reviewList = this.reviewRepository.highestRatingOldest(minimum);
            //remove the reviews without text
            reviewList=reviewList.stream().filter(r->!r.getReviewFullText().isEmpty()).collect(Collectors.toList());
            //get the reviews without text, sorted according to the requirements regarding the rating and date
            //append them at the end of the list with the sorted reviews with text
            reviewList.addAll(this.reviewRepository.noTextHighestRatingOldest(minimum));
            return reviewList;
        }
        //yes, lowest first, oldest first
        if(prioritizeByText.equals("1") && orderByRating.equals("0") && orderByDate.equals("0")) {
            //take the whole db sorted according to the requirements regarding the rating and date
            List<Review> reviewList = this.reviewRepository.lowestRatingOldest(minimum);
            //remove the reviews without text
            reviewList=reviewList.stream().filter(r->!r.getReviewFullText().isEmpty()).collect(Collectors.toList());
            //get the reviews without text, sorted according to the requirements regaring the rating and date
            //append them at the end of the list with the sorted reviews with text
            reviewList.addAll(this.reviewRepository.noTextLowestRatingOldest(minimum));
            return reviewList;
        }
        //no, highest first, newest first
        if(prioritizeByText.equals("0") && orderByRating.equals("1") && orderByDate.equals("1")){
            return this.reviewRepository.dontPrioritizeTextHighestRatingNewest(minimum);
        }
        //no, lowest first, newest first
        if(prioritizeByText.equals("0") && orderByRating.equals("0") && orderByDate.equals("1")){
            return this.reviewRepository.dontPrioritizeTextLowestRatingNewest(minimum);
        }
        //no, highest first, oldest first
        if(prioritizeByText.equals("0") && orderByRating.equals("1") && orderByDate.equals("0")){
            return this.reviewRepository.dontPrioritizeTextHighestRatingOldest(minimum);
        }
        //no, lowest first, oldest first
        if(prioritizeByText.equals("0") && orderByRating.equals("0") && orderByDate.equals("0")) {
            return this.reviewRepository.dontPrioritizeTextLowestRatingOldest(minimum);
        }

        return this.reviewRepository.findAll();
    }
}

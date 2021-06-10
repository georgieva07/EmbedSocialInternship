package gjeorgieva.anastasija.filter.repository;

import gjeorgieva.anastasija.filter.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.reviewFullText DESC, R.rating DESC, R.reviewCreatedOnDate DESC")
    List<Review> prioritizeTextHighestRatingNewest(int minimalRating);

    //doesn't sort the ones with text by rating
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.reviewFullText DESC, R.rating ASC, R.reviewCreatedOnDate DESC")
    List<Review> prioritizeTextLowestRatingNewest(int minimalRating);

    //buggy1
    @Query("SELECT R FROM Review R WHERE R.rating >= ?1 ORDER BY R.reviewFullText DESC, R.rating DESC,  R.reviewCreatedOnDate ASC")
    List<Review> prioritizeTextHighestRatingOldest(int minimalRating);

    //buggy2
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.reviewFullText DESC, R.rating ASC,  R.reviewCreatedOnDate ASC")
    List<Review> prioritizeTextLowestRatingOldest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating DESC, R.reviewCreatedOnDate DESC")
    List<Review> dontPrioritizeTextHighestRatingNewest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating >=?1 ORDER BY R.rating ASC, R.reviewCreatedOnDate DESC")
    List<Review> dontPrioritizeTextLowestRatingNewest(int minimalRating);

    //buggy3
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating DESC,  R.reviewCreatedOnDate ASC")
    List<Review> dontPrioritizeTextHighestRatingOldest(int minimalRating);

    //buggy4
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating ASC,  R.reviewCreatedOnDate ASC")
    List<Review> dontPrioritizeTextLowestRatingOldest(int minimalRating);
}

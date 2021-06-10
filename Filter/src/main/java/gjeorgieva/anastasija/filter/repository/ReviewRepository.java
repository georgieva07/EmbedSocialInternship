package gjeorgieva.anastasija.filter.repository;

import gjeorgieva.anastasija.filter.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating DESC, R.reviewCreatedOnDate DESC")
    List<Review> highestRatingNewest(int minimalRating);
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 AND R.reviewFullText = '' ORDER BY R.rating DESC, R.reviewCreatedOnDate DESC")
    List<Review> noTextHighestRatingNewest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating ASC, R.reviewCreatedOnDate DESC")
    List<Review> lowestRatingNewest(int minimalRating);
    @Query("SELECT R FROM Review R WHERE R.rating >= ?1 AND R.reviewFullText = '' ORDER BY R.rating ASC, R.reviewCreatedOnDate DESC")
    List<Review> noTextLowestRatingNewest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating >= ?1 ORDER BY R.rating DESC, R.reviewCreatedOnDate ASC")
    List<Review> highestRatingOldest(int minimalRating);
    @Query("SELECT R FROM Review R WHERE R.rating >= ?1 AND R.reviewFullText = '' ORDER BY R.rating DESC, R.reviewCreatedOnDate ASC")
    List<Review> noTextHighestRatingOldest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating ASC,  R.reviewCreatedOnDate ASC")
    List<Review> lowestRatingOldest(int minimalRating);
    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 AND R.reviewFullText = '' ORDER BY R.rating ASC,  R.reviewCreatedOnDate ASC")
    List<Review> noTextLowestRatingOldest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating DESC, R.reviewCreatedOnDate DESC")
    List<Review> dontPrioritizeTextHighestRatingNewest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating >=?1 ORDER BY R.rating ASC, R.reviewCreatedOnDate DESC")
    List<Review> dontPrioritizeTextLowestRatingNewest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating DESC,  R.reviewCreatedOnDate ASC")
    List<Review> dontPrioritizeTextHighestRatingOldest(int minimalRating);

    @Query("SELECT R FROM Review R WHERE R.rating>= ?1 ORDER BY R.rating ASC,  R.reviewCreatedOnDate ASC")
    List<Review> dontPrioritizeTextLowestRatingOldest(int minimalRating);
}

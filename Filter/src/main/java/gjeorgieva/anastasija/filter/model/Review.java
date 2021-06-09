package gjeorgieva.anastasija.filter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {

    @Id
    private Long id;
    private String reviewId;
    private String reviewFullText;
    private String reviewText;
    private int numLikes;
    private int numComments;
    private int numShares;
    private int rating;
    private String reviewCreatedOn;
    private Date reviewCreatedOnDate;
    private int reviewCreatedOnTime;
    private Long reviewerId;
    private String reviewerUrl;
    private String reviewerName;
    private String reviewerEmail;
    private String sourceType;
    private boolean isVerified;
    private String source;
    private String sourceName;
    private String sourceId;
    @ManyToMany
    private List<Tag> tags;
    private String href;
    private String logoHref;
    @ManyToMany
    private List<Photo> photos;

    public Review() {
    }

    public Review(Long id, String reviewId, String reviewFullText, String reviewText, int numLikes, int numComments, int numShares, int rating, String reviewCreatedOn, Date reviewCreatedOnDate, int reviewCreatedOnTime, Long reviewerId, String reviewerUrl, String reviewerName, String reviewerEmail, String sourceType, boolean isVerified, String source, String sourceName, String sourceId, List<Tag> tags, String href, String logoHref, List<Photo> photos) {
        this.id = id;
        this.reviewId = reviewId;
        this.reviewFullText = reviewFullText;
        this.reviewText = reviewText;
        this.numLikes = numLikes;
        this.numComments = numComments;
        this.numShares = numShares;
        this.rating = rating;
        this.reviewCreatedOn = reviewCreatedOn;
        this.reviewCreatedOnDate = reviewCreatedOnDate;
        this.reviewCreatedOnTime = reviewCreatedOnTime;
        this.reviewerId = reviewerId;
        this.reviewerUrl = reviewerUrl;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.sourceType = sourceType;
        this.isVerified = isVerified;
        this.source = source;
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.tags = tags;
        this.href = href;
        this.logoHref = logoHref;
        this.photos = photos;
    }
}

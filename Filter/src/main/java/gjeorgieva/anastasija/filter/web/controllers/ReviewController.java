package gjeorgieva.anastasija.filter.web.controllers;

import gjeorgieva.anastasija.filter.model.Review;
import gjeorgieva.anastasija.filter.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String listReviews(Model model){
        List<Review> reviewList = this.reviewService.listAll();
        model.addAttribute("reviews", reviewList);
        return "home";
    }

    @PostMapping
    public String listReviews(@RequestParam String orderByRating,
                         @RequestParam String minimumRating,
                         @RequestParam String orderByDate,
                         @RequestParam String prioritizeByText,
                         Model model) {

        List<Review> reviewList = this.reviewService.filter(orderByRating, minimumRating, orderByDate, prioritizeByText);
        model.addAttribute("reviews", reviewList);
        return "home";
    }
}

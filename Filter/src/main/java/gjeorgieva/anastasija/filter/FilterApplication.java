package gjeorgieva.anastasija.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gjeorgieva.anastasija.filter.model.Review;
import gjeorgieva.anastasija.filter.service.ReviewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class FilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ReviewService reviewService){
        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Review>> typeReference = new TypeReference<List<Review>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/reviews.json");
            try {
                List<Review> reviews = objectMapper.readValue(inputStream,typeReference);
                reviewService.create(reviews);
                System.out.println("Reviews Saved!");
            } catch (IOException e){
                System.out.println("Unable to save reviews: " + e.getMessage());
            }
        };
    }
}

package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/{userid}")
	public List<CatalogItem> listOfCatalog(@PathVariable("userid") String userid) {

		

		restTemplate = new RestTemplate();
		// calling other service

		// get all rated movie IDs as a wrapper UserRating
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userid, UserRating.class);

		//unwrap the classes
		return ratings.getRatings().stream().map(rating -> {
			// for each movie ID, call movie info service to get the details\
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			
			//body to mono is converting the response to the class's type/instance
			//MONO : Reactive way of saying you will get an object in future not instantly
			
		/*	Movie movie	=	webClientBuilder.build()
			.get()
			.uri("http://localhost:8082/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();*/
			
			
			//put them all together
			return new CatalogItem(movie.getName(), "Description", rating.getRating());
		}).collect(Collectors.toList());
	}
}

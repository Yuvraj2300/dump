package io.javabrains.movieinfoservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@GetMapping("{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		if (movieId.equals("1")) {
			return new Movie(movieId, "To Kill a Mocking Bird");
		} else if (movieId.equals("2")) {
			return new Movie(movieId, "Seven");
		} else {
			return new Movie(movieId, "DEFAULT");
		}
	}
}

package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@GetMapping("/{userid}")
	public List<CatalogItem> listOfCatalog(@PathVariable("userid") String userid) {
		
		//get all rated movie IDs
		List<Rating>	ratings	=	Arrays.asList(
				new	Rating("123",4),
				new	Rating("456",3)
			);
		//for each movie ID, call movie info service to get the details\
		
		//Put them all together.
		
		
		//hardcoded list
		return Collections.singletonList
				(new CatalogItem("Once upon a time in Hollywood", "Brad Pitt !!!", 4));
	}
}

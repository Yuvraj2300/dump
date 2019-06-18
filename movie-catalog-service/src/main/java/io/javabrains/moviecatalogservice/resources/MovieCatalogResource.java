package io.javabrains.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@GetMapping("/{userid}")
	public List<CatalogItem> listOfCatalog(@PathVariable("userid") String userid) {
		//hardcoded list
		return Collections.singletonList
				(new CatalogItem("Once upon a time in Hollywood", "Brad Pitt !!!", 4));
	}
}

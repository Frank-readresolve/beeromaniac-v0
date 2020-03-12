package fr.formation.beeromaniac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.beeromaniac.services.QueryResult;
import fr.formation.beeromaniac.services.QueryService;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private QueryService service;

    @RequestMapping("/execute")
    public QueryResult execute() {
	return service.execute();
    }

}

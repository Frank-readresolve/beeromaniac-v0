package fr.formation.beeromaniac.services;

import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {
    // Inject required repositories

    @Override
    public QueryResult execute() {
	// Query repositories:
	// Return encapsulated result:
	return new QueryResult(null);
    }

}

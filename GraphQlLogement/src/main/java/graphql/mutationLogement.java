package graphql;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import repository.LogementRepository;

public class mutationLogement implements GraphQLRootResolver {

	private final LogementRepository logementRepos;
	
	
	public mutationLogement(LogementRepository logementRepository) {
		super();
		this.logementRepos = logementRepository;
	}


	public void saveLogement(Logement logement) {
		logementRepos.saveLogement(logement);		
		
	}
}

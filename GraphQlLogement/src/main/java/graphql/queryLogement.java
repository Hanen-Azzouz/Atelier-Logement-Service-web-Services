package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import entite.Logement.Type;
import repository.LogementRepository;

public class queryLogement implements GraphQLRootResolver {
	
	private final LogementRepository logementRepos;

	public queryLogement(LogementRepository logementRepository) {
		
		this.logementRepos=logementRepository;
		
	}
	
	
	public List<Logement> findAllLogements(){
		return logementRepos.getAllLogements();
	}

	public List<Logement> findLogementsByType(Type type){
		return logementRepos.getLogementsByType(type);
		
		
	}

	

	public Logement getLogementsByReference(int reference) {
		
		
		return logementRepos.getLogementsByReference(reference);
	}



}




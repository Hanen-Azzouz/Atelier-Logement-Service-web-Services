package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.RendezVous;
import repository.RendezVousRepository;

public class mutationRDV implements GraphQLRootResolver{

	private final RendezVousRepository rdvRepos;
	public mutationRDV(RendezVousRepository rdvRepository) 
	{
		this.rdvRepos=rdvRepository;
	}	
	
	
	public boolean addRendezVous(RendezVous rendezVous) {
		return rdvRepos.addRendezVous(rendezVous);
	}
	
	public boolean updateRendezVous(RendezVous rendezVous) {
		return rdvRepos.updateRendezVous(rendezVous);
	}
	
      public boolean deleteRendezVous(int id) {
		
		return rdvRepos.deleteRendezVous(id);
		
	}
	
	
	
}

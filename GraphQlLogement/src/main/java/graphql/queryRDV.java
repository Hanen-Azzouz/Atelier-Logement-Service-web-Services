package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import entite.RendezVous;
import repository.RendezVousRepository;

public class queryRDV implements GraphQLRootResolver{
	
	private final RendezVousRepository rdvRepos;
	
	
	public queryRDV(RendezVousRepository rdvRepository) {
		this.rdvRepos=rdvRepository;
	}
	
	
	
	public List<RendezVous> getListeRendezVous(){
		return rdvRepos.getListeRendezVous();
	}
	
	
	public List<RendezVous> getListeRendezVousByLogementRef(int reference){
		return rdvRepos.getListeRendezVousByLogementRef(reference);
	}
	
	
	
	public Logement getLogementByRDV(int idRDV) {
		
		return rdvRepos.getLogementByRDV(idRDV);
		
	}
	
	
	

}

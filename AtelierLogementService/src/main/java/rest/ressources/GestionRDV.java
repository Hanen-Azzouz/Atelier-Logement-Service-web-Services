package rest.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import rest.business.LogementBusiness;
import rest.business.RendezVousBusiness;


@Path("rendezvous")
public class GestionRDV {

	
	private RendezVousBusiness rdb=new RendezVousBusiness();
	private LogementBusiness lgb = new LogementBusiness();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response displayRDV() {
		if(rdb.getListeRendezVous().size()!=0)
		{return Response.status(Status.OK).entity(rdb.getListeRendezVous()).build();}
		return Response.status(Status.NOT_FOUND).entity("liste vide").build();}
}

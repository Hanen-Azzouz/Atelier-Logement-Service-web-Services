package rest.ressources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import rest.business.LogementBusiness;
import rest.business.RendezVousBusiness;
import rest.entites.RendezVous;


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
	
	
	//Ajouter RDV
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addRDV(RendezVous rdv) {
		if(rdb.addRendezVous(rdv)) {
			return Response.status(Status.CREATED).entity(rdb.getListeRendezVous()).build();
		}
		return Response.status(Status.NOT_FOUND).entity("Failed").build();
		
	}
	
	// Liste de RDV par réference de logement
	@GET
	@Path("conflit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRDVByRefLogement(@QueryParam("refLogement")int reference) {
		if(rdb.getListeRendezVousByLogementReference(reference).size()!=0)
         {return Response.status(Status.OK).entity(rdb.getListeRendezVousByLogementReference(reference)).build();}
		return Response.status(Status.NOT_FOUND).entity("404 NOT FOUND").build();
		
		}
	//Liste de RDV par identifiant
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	
	public Response getRDVById(@PathParam("id") int id) {
		if(rdb.getRendezVousById(id)!=null)
		{
			return Response.status(Status.OK).entity(rdb.getRendezVousById(id)).build();
		}
		return Response.status(Status.NOT_FOUND).entity("404 NOT FOUND").build();
		
				
	}
	
	//Supprimer un RDV par id
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRDVById(@PathParam("id") int id)
	{
		if(rdb.deleteRendezVous(id)  ) {
			
			
			{//return Response.status(Status.OK).entity("RDV deletetd").build();
				return Response.status(Status.OK).entity(rdb.getListeRendezVous()).build();}
			}
			
		
		return Response.status(Status.NOT_FOUND).entity("not found").build();	
	
	}
	
	//Modifier un RDV par id
	
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public Response updateRDVById(@PathParam("id") int id,RendezVous rdv)
	{
		if(rdb.updateRendezVous(id, rdv))
		{
			return Response.status(Status.OK).entity("update ok").build();
		}
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	//http://localhost:8082/AtelierLogementService/api/rendezvous/3
	
	
	
	
	
}

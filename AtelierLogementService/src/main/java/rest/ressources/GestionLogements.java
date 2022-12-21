package rest.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import rest.entites.Logement.Type;

import rest.business.LogementBusiness;

@Path("logements")
public class GestionLogements {

	private LogementBusiness lgb=new LogementBusiness();
	
	//Afficher tous les logements
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLogements() {
		
		if(lgb.getLogements().size()!=0)
		{
			
			return Response.status(Status.OK).entity(lgb.getLogements()).build();
		}
		
		return Response.status(Status.NOT_FOUND).entity("Liste Vide").build();
		
		
		
		//http://localhost:8082/AtelierLogementService/api/logements
	}
	
	//Afficher les Logements par délégation passée en paramétre (Query Param)
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("getByDelegation")
	public Response getLogementByDelegation(@QueryParam("delegation")   String delegation)
	{
		if(lgb.getLogementsByDeleguation(delegation).size()!=0)
		{
			return Response.status(Status.OK).entity(lgb.getLogementsByDeleguation(delegation)).build();
		}
		return Response.status(Status.NOT_FOUND).entity("Logement inexistant").build();
		
		
		//http://localhost:8082/AtelierLogementService/api/logements/getByDelegation?delegation=El ghazela(sur postman)
		
	}
	
	//Afficher les Logements par gouvernorat passée en paramétre (Query Param)
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("getByGouvernorat")
	
	public Response getLogementByGouvernorat(@QueryParam ("gouvernorat") String gouvernorat) 
	{
		if(lgb.getLogementsByGouvernorat(gouvernorat).size()!=0) 
		{
		   return Response.status(Status.OK).entity(lgb.getLogementsByGouvernorat(gouvernorat)).build();	
		}
		
		return Response.status(Status.NOT_FOUND).entity("Logement inexistant").build();
		
		//http://localhost:8082/AtelierLogementService/api/logements/getByGouvernorat?gouvernorat=Ariana
	}
	
	
	//Afficher les Logements par type passé en paramétre (Query Param)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("getByType")
	
	public Response getLogementByType(@QueryParam ("type") Type type) 
	{
		if(lgb.getLogementsByType(type).size()!=0) 
		{
		   return Response.status(Status.OK).entity(lgb.getLogementsByType(type)).build();	
		}
		
		return Response.status(Status.NOT_FOUND).entity("Logements inexistants").build();
		
		//http://localhost:8082/AtelierLogementService/api/logements/getByType?type=Studio
	}
	
	//Afficher les Logements ayant un prix maximal passé en paramétre (Query Param)
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("getByPrix")
	public Response getLogementsByPrice(@QueryParam("prix") float prix)
	{
		if(lgb.getLogementsByPrix(prix).size()!=0)
		{
			return Response.status(Status.OK).entity(lgb.getLogementsByPrix(prix)).build();
		}
		return Response.status(Status.NOT_FOUND).entity("Logements inexistants").build();
		
	}
	//Afficher les Logements ayant réference passée en paramétre (Query Param)
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("getByReference")
	public Response getLogementsByPrice(@QueryParam("reference") int reference)
	{
		
		if(lgb.getLogementsByReference(reference)!=null)
		{
			return Response.status(Status.OK).entity(lgb.getLogementsByReference(reference)).build();
		}
		return Response.status(Status.NOT_FOUND).entity("Logement inexistant").build();
	}
	
}

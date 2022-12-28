package graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

@WebServlet(urlPatterns = "/graphql")
public class graphqlEndPoint extends SimpleGraphQLServlet{

	
   public graphqlEndPoint() {
		super(buildSchema());
		// TODO Auto-generated constructor stub
	}

   public static GraphQLSchema buildSchema() {
	
	LogementRepository logementRepo=new LogementRepository();
	RendezVousRepository rdvRepo=new RendezVousRepository();
	
	
	return SchemaParser.newParser().file("schema.graphql")
	.resolvers(new queryLogement(logementRepo),new queryRDV(rdvRepo),new mutationLogement(logementRepo),new mutationRDV(rdvRepo))
	.build().makeExecutableSchema();
	
}
	
	
	
	
}

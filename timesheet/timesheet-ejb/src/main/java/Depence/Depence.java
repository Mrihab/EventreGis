package Depence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class Depence
 */
@Stateless
@LocalBean
public class Depence implements DepenceRemote, DepenceLocal {

   
static javax.ws.rs.client.Client c= ClientBuilder.newClient();
	
	public String getDepence(){
		
		String lr = c.target("http://localhost:51056/api/depence/getdepence").request().get().readEntity(String.class);
		System.out.println("test0");

		return lr;
	}
	
	
	public String Add(String s )
	{
	
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:51056/api/depence/post/");
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.post(Entity.entity(s, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}

	
//	public void changeState(int id,int days){
//		System.err.println("***********************"+days);
//		c.target("http://localhost:50065/api/Event/ChangeS?id="+id+"&nb="+days).request().get();
//	}
	
	
	
	

}



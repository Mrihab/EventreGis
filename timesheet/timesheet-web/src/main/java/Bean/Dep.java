package Bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import Depence.Depence;
import Depence.DepenceRemote;

@ManagedBean
@SessionScoped
public class Dep implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int DepenceID;
	private String Objectif;
	private float Valeur;
	private String Description;
	private int EventID;
	
	
	
	
	public int getEventID() {
		return EventID;
	}



	public void setEventID(int eventID) {
		EventID = eventID;
	}



	public Dep(int depenceID, String objectif, float valeur, String description, int eventID, DepenceRemote e) {
		super();
		DepenceID = depenceID;
		Objectif = objectif;
		Valeur = valeur;
		Description = description;
		EventID = eventID;
		this.e = e;
	}



	public Dep() {
		super();
	}



	@EJB
	private DepenceRemote e;
	
	
	
	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getDepence(){
		
		String lr= e.getDepence();	
		System.out.println(lr);
		JSONArray  array = new JSONArray(lr);
		ArrayList<Object> al=new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            al.add(array.get(i));
    		System.out.println("test");

        }
		return al;
	}
	


	
	@POST
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public void add()
	{
		 String jsonString = new JSONObject()
                 .put("objectif", Objectif)
                 .put("valeur", Valeur)
                 .put("description", Description)
                 .put("event_id", EventID)
                 .toString();
		e.Add(jsonString);
		System.out.println(jsonString);
		 //rec.getByUser();
	}

	


	public int getDepenceID() {
		return DepenceID;
	}



	public void setDepenceID(int depenceID) {
		DepenceID = depenceID;
	}



	public String getObjectif() {
		return Objectif;
	}



	public void setObjectif(String objectif) {
		Objectif = objectif;
	}



	public float getValeur() {
		return Valeur;
	}



	public void setValeur(float valeur) {
		Valeur = valeur;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public DepenceRemote getE() {
		return e;
	}



	public void setE(DepenceRemote e) {
		this.e = e;
	}
//	 public float DepenceDanger(Dep d)
//     {
//		 Depence k = new Depence();
//		  for(int i = 0; i<3; i++) { 
//			  
//              
//	       //   if( k.getDepence() == getValeur())
//	        	  
//         
//         }
//         
//
//     }

	
	
	
	
	
	
	
	
	
	

}

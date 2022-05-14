package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.User; 

@Path("/user")
public class UserService {
	User userObj = new User();
	
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertUser(String insertData)
	 {
			//Convert the input string to a JSON object 
		 JsonObject insertObject = new JsonParser().parse(insertData).getAsJsonObject();
		 
		 String name = insertObject.get("name").getAsString();
		 String date = insertObject.get("date").getAsString();
		 String nic = insertObject.get("nic").getAsString();
		 String password = insertObject.get("password").getAsString();
		

		 String output = userObj.insertUser(name, date, nic, password);
		 return output; 
	 }
	 
	 @GET
	 @Path("/") 
	 @Produces(MediaType.TEXT_HTML) 
	 public String readUser() 
	  { 
		  return userObj.readUser(); 
	  }
	 
	 @PUT
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateUser(String updateData)
	 {
		 JsonObject updateObject = new JsonParser().parse(updateData).getAsJsonObject();
		 
		 String iduser = updateObject.get("iduser").getAsString();
		 String name = updateObject.get("name").getAsString();
		 String date = updateObject.get("date").getAsString();
		 String nic = updateObject.get("nic").getAsString();
		 String password = updateObject.get("password").getAsString();
		 
		 String output = userObj.updateUser(iduser, name, date, nic, password);
		 return output;
	 }
	 
	 @DELETE
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String deleteUser(String deleteData)
	 {
		 JsonObject updateObject = new JsonParser().parse(deleteData).getAsJsonObject();
		 
		 String iduser = updateObject.get("iduser").getAsString();
		 
		 String output = userObj.deleteUser(iduser);
		 return output;

	 }
	

	 
}

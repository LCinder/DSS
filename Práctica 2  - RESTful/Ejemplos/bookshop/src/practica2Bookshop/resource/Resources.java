
package practica2Bookshop.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import practica2Bookshop.DAO;
import practica2Bookshop.model.Model;

@Path("/todos")
public class Resources {
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Model> getModelsBrowser() {
    	List<Model> models = new ArrayList<Model>();
    	models.addAll(DAO.INSTANCE.getModel().values());
        return models;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Model> getModels() {
    	List<Model> models = new ArrayList<Model>();
        models.addAll(DAO.INSTANCE.getModel().values());
        return models;
    }
	
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Model getXML() {
        Model model = new Model();
        model.setSummary("FirstModel");
        model.setDescription("FirstModel");
        return model;
    }

    @GET
    @Path("cont")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return String.valueOf(DAO.INSTANCE.getModel().size());
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newModel(@FormParam("id") String id, @FormParam("description") String description, @FormParam("summary") String summary,
	@Context HttpServletResponse response) throws IOException {
    }
    
    @Path("{todo}")
    public Resource getResource(@PathParam("todo") String id) {
    	return new Resource(uriInfo, request, id);
    }
}
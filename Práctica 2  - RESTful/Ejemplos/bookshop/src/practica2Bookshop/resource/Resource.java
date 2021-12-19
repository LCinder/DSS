
package practica2Bookshop.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import practica2Bookshop.model.Model;

@Path("/todo")
public class Resource {

	@GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Model getXML() {
        Model model = new Model();
        model.setSummary("FirstModel");
        model.setDescription("FirstModel");
        return model;
    }

    @GET
    @Produces({MediaType.TEXT_XML})
    public Model getHTML() {
        Model model = new Model();
        model.setSummary("FirstModel2");
        model.setDescription("FirstModel2");
        return model;
    }
}
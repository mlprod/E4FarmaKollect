package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.dao.RoleDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/role")
public class RoleController {

    RoleDao rDao;

    //Retourne la liste de médicament
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String viewRoles(){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(rDao.getRoles());
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;
    }
}

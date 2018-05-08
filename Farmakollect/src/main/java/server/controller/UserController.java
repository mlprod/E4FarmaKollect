package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.dao.UserDao;
import server.model.mapping.Etablissement;
import server.model.mapping.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/user")
public class UserController {

    UserDao uDao;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/log/{login}/{password}")
    public String logUser(@PathParam("login") String login, @PathParam("password") String password){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(uDao.logUser(login, password));
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;

    }

    //Retourne la liste de médicament
    @GET
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String viewUser(){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(uDao.getUser());
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;
    }




    //Ajoute un établissement
    @PUT
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveUser(User user) {
        uDao.saveUser(
                user.getNom(),
                user.getPrenom(),
                user.getLogin(),
                user.getPassword(),
                user.getIdRole(),
                user.getIdEtab());
    }

    }



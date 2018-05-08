package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.dao.EtablissementDao;
import server.model.dao.StockDao;
import server.model.mapping.Etablissement;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/etablissement")
public class EtablissementController {

    EtablissementDao etablissementDao;

    //Retourne la liste des établissements
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String viewEtablissement(){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(etablissementDao.getEtablissements());
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;
    }

    //Ajoute un établissement
    @PUT
    @Path("/save")
    public void saveEtablissement(Etablissement etablissement) {
        etablissementDao.saveEtablissement(
                etablissement.getId(),
                etablissement.getNom(),
                etablissement.getAdresse(),
                etablissement.getCp(),
                etablissement.getVille());

    }
}
package server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import server.model.dao.MedicamentDao;
import server.model.dao.StockDao;
import server.model.mapping.Medicament;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/medicament")
public class MedicamentController {

    MedicamentDao mDao;
    StockDao sDao;

    //Retourne la liste de médicament
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String viewMedicament(){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(mDao.getMedicaments());
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;
    }

    //Retourne un médicament en fonction de son id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMedicament(@PathParam("id") String id){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(mDao.getMedicament(id));
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;
    }

    //Ajoute un médicament
    @PUT
    @Path("/save")
    public void saveMedicament(Medicament medicament) {
        mDao.saveMedicament(medicament.getId(),
                medicament.getLabel(),
                medicament.getCode().getFamilleCode(),
                medicament.getComposition(),
                medicament.getEffets(),
                medicament.getContreIndic());

        sDao.saveStock(medicament.getId(),
                medicament.getStock().getNombre(),
                medicament.getStock().getPrix());
    }

    //Edite un médicament
    @PUT
    @Path("/edit/{id}")
    public void editMedicament(Medicament medicament) {
        mDao.editMedicament(medicament.getId(),
                medicament.getLabel(),
                medicament.getCode().getFamilleCode(),
                medicament.getComposition(),
                medicament.getEffets(),
                medicament.getContreIndic());

        sDao.editStock(medicament.getId(),
                medicament.getStock().getNombre(),
                medicament.getStock().getPrix());
    }

    //Supprime un médicament
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public void deleteMedicament(@PathParam("id") String id){
        sDao.deleteStock(id);
        mDao.deleteMedicament(id);
    }


    //Retourne les familles de médicament
    @GET
    @Path("/familleMedicament")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFamilleMedicament(){

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {

            jsonInString = mapper.writeValueAsString(mDao.getFamilleMedicaments());
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return jsonInString;
    }

    /*
    //Ajoute une famille de médicament
    @RequestMapping(value = "admin/medic/save", method = RequestMethod.POST)
    public String saveFamilleMedicament(@RequestParam(value = "code") String code,
                                        @RequestParam(value = "libelle") String libelle)throws SQLException{

        mDao.saveFamilleMedicament(code, libelle);

        return "OK";
    }

    //Supprime une famille de médicament
    @RequestMapping(value = "admin/famille/{code:[\\d]+}/delete", method = RequestMethod.POST)
    public String deleteFamilleMedicament(@RequestParam(value = "code") String code)throws SQLException{

        mDao.deleteFamilleMedicament(code);

        return "OK";
    }
*/
}
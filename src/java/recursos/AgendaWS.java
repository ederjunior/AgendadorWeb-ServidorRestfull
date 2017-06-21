/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import classePrincipal.Agenda;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author Eder
 */
@Path("agendaWS")
public class AgendaWS {

    @Context
    private UriInfo context;

    @GET
    @Path("getAgendaPorId/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Agenda getAgendaPorId(@PathParam(value = "id") int id) {
        Agenda a = new Agenda();
        return a.listarAgendaPorId(id);
    }
    
    @GET
    @Path("getListaAgenda")
    @Produces("application/json")
    @Consumes("application/json")
    public List<Agenda> getListaAgenda() {
        Agenda l = new Agenda();
        return l.listarAgendas();
    }
    

    @POST
    @Path("setAgenda")
    @Consumes("application/json")
    public void setAgenda(Agenda a) {
        Agenda nAgenda = new Agenda();
        
        nAgenda.setAgenda(a.getDataHora(),a.getStatus(), a.getVentilador(), a.getLuzDaSala(),
                a.getTv(), a.getLuzDoQuarto());
        System.out.println(a.getDataHora());
    }
    
    @DELETE
    @Path("deletarAgenda/{idAgenda}")
    @Produces("application/json")
    @Consumes("application/json")
    public void deletarAgenda(@PathParam(value="idAgenda") int idAgenda) {
        Agenda l = new Agenda();
        l.deletarAgenda(idAgenda);
    }
    
    @PUT
    @Path("editarAgenda")
    @Produces("application/json")
    @Consumes("application/json")
    public void editarAgenda(Agenda a) {
        Agenda l = new Agenda();
         System.out.println(" aqui "+a.getDataHora().toString());
        System.out.println(" aqui "+a.getVentilador());
        l.editarAgenda(a.getId(),a.getStatus(),a.getDataHora(), a.getVentilador(), a.getLuzDaSala(),
                a.getTv(), a.getLuzDoQuarto());
       
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}

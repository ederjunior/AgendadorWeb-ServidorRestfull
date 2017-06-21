/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classePrincipal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Timestamp;

/**
 *
 * @author Eder
 */
public class Agenda {

    private int id;
    private Timestamp dataHora;
    private String status;
    private String ventilador;
    private String luzDaSala;
    private String tv;
    private String luzDoQuarto;

    public List<Agenda> listarAgendas() {
        try {
            List<Agenda> l = new ArrayList<>();
            Agenda a;
            ConexaoMySQL c = new ConexaoMySQL();
            c.conexao();
            ResultSet r = c.retornarAgenda();
            while (r.next()) {
                a = new Agenda();
                a.id = r.getInt("id_a");
                a.dataHora = r.getTimestamp("dataHora_a");
                a.status = r.getString("status_a");
                a.ventilador = r.getString("ventilador_a");
                a.luzDaSala = r.getString("luz_sala_a");
                a.tv = r.getString("tv_a");
                a.luzDoQuarto = r.getString("luz_quarto_a");

                l.add(a);

            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Agenda listarAgendaPorId(int id) {
        try {
            
            Agenda a;
            ConexaoMySQL c = new ConexaoMySQL();
            c.conexao();
            ResultSet r = c.retornarAgendaPorId(id);
            if (r.next()) {
                a = new Agenda();
                a.id = r.getInt("id_a");
                a.dataHora = r.getTimestamp("dataHora_a");
                a.status = r.getString("status_a");
                a.ventilador = r.getString("ventilador_a");
                a.luzDaSala = r.getString("luz_sala_a");
                a.tv = r.getString("tv_a");
                a.luzDoQuarto = r.getString("luz_quarto_a");

                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setAgenda(Timestamp dataHora, String status, String ventilador,
            String luzDaSala, String tv, String luzDoQuarto){
        
        
        ConexaoMySQL c = new ConexaoMySQL();
        try {
            c.conexao();
            c.setAgenda(dataHora, status, ventilador, luzDaSala, tv, luzDoQuarto);
            
        } catch (SQLException ex) {
            System.out.println("Erro no setAgenda");
        }
    }
    
    public void deletarAgenda(int idAgenda){
        ConexaoMySQL c = new ConexaoMySQL();
        try {
            c.conexao();
            c.deletarAgenda(idAgenda);
            
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar - classe Agenda");
        }
    }
    
    public void editarAgenda(int id,String status, Timestamp dataHora, String ventilador,
            String luzDaSala, String tv, String luzDoQuarto){
        
        ConexaoMySQL c = new ConexaoMySQL();
        try {
            c.conexao();
            c.editarAgenda(id, status, dataHora, ventilador, luzDaSala, tv, luzDoQuarto);
            
        } catch (SQLException ex) {
            System.out.println("Erro no setAgenda");
        }
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVentilador() {
        return ventilador;
    }

    public void setVentilador(String ventilador) {
        this.ventilador = ventilador;
    }

    public String getLuzDaSala() {
        return luzDaSala;
    }

    public void setLuzDaSala(String luzDaSala) {
        this.luzDaSala = luzDaSala;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getLuzDoQuarto() {
        return luzDoQuarto;
    }

    public void setLuzDoQuarto(String luzDoQuarto) {
        this.luzDoQuarto = luzDoQuarto;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classePrincipal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eder
 */
public class Teste {

    public static void main(String[] args) {
        try {
            Agenda a = new Agenda();
            ConexaoMySQL c = new ConexaoMySQL();
            c.conexao();
            ResultSet r = c.retornarAgendaPorId(1);
            if (r.next()) {
                
                a.setId(r.getInt("id_a"));
//                a.setDataHora(r.getDate("dataHora_a"));
                a.setStatus(r.getString("status_a"));
                a.setVentilador(r.getString("ventilador_a"));
                a.setLuzDaSala(r.getString("luz_sala_a"));
                a.setTv(r.getString("tv_a"));
                a.setLuzDoQuarto(r.getString("luz_quarto_a"));

            }
            System.out.println(a.getId());
            System.out.println(a.getDataHora());
            System.out.println(a.getStatus());
            System.out.println(a.getVentilador());
            System.out.println(a.getLuzDaSala());
            System.out.println(a.getTv());
            System.out.println(a.getLuzDoQuarto());
            

        } catch (SQLException ex) {
            System.out.println("Erro na classe Teste");
        }

    }
}

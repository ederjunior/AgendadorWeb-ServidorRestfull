package classePrincipal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ConexaoMySQL {

    Connection connection;
    
    public Connection getConnection() {
        return connection;
    }

    public void conexao() throws SQLException {
        connection = null;
        try {

            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost:3306";
            String mydatabase = "agendadorweb";// nome do banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase+"?useSSL=false";
            
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("conectado.");
        } catch (ClassNotFoundException e) {
            System.out.println("erro de conexão");
            
        }
    }
    
    //Retorna Agenda ----------------------------------------------------------------------------------------------------
    
    public ResultSet retornarAgenda() {
        ResultSet r = null;
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM agendadorweb.agenda order by dataHora_a;";
            stmt.executeQuery(sql);
            r = stmt.getResultSet();
            System.out.println("Retornado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("erro de retorno - banco de dados");
        }
        return r;
    }
    
    public ResultSet retornarAgendaPorId(int id) {
        ResultSet r = null;
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM agendadorweb.agenda where id_a="+id+";";
            stmt.executeQuery(sql);
            r = stmt.getResultSet();
            System.out.println("Retornado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("erro de retorno - banco de dados");
        }
        return r;
    }
    
    
    
//Agendar --------------------------------------------------------------------------------------------------
    
    public void setAgenda(Timestamp dataHora, String status, String ventilador,
            String luzDaSala, String tv, String luzDoQuarto) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO agenda(id_a, dataHora_a,"
                    + " status_a, ventilador_a, luz_sala_a, tv_a, luz_quarto_a) "
                    + "VALUES(default, '"+dataHora+"', '"+status+"', '"+ventilador+"', '"+luzDaSala+"',"
                    + " '"+tv+"', '"+luzDoQuarto+"');";
            stmt.executeUpdate(sql);
            
            System.out.println("Inserido com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("erro de inserção - banco de dados");
        }
    }

//Deletar -------------------------------------------------------------------------------------------------
    
    public void deletarAgenda(int idAgenda) {
        
        try {
            Statement stmt = connection.createStatement();
            String sql = "DELETE FROM agenda WHERE id_a="+idAgenda+";";
            stmt.executeUpdate(sql);
            
            System.out.println("deletado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("erro ao deletar - banco de dados");
        }
    }
    
    //Editar Agenda --------------------------------------------------------------------------------------------------
    
    public void editarAgenda(int id, String status, Timestamp dataHora, String ventilador,
            String luzDaSala, String tv, String luzDoQuarto) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "UPDATE agenda SET status_a = '"+status+"', dataHora_a = '"+dataHora+"', ventilador_a = '"+ventilador+"',"
                    + " luz_sala_a = '"+luzDaSala+"', tv_a = '"+tv+"', luz_quarto_a = '"+luzDoQuarto+"' WHERE id_a = '"+id+"';";
            stmt.executeUpdate(sql);
            
            System.out.println("Editado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("erro de edição - banco de dados");
        }
    }
    
  }
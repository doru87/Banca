/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controale;

import baza.de.date.ConexiuneBazaDate;
import static baza.de.date.ConexiuneBazaDate.obtineInstanta;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Clienti;
import modele.Utilizatori;

/**
 *
 * @author pc
 */
public class ClientiController {
    private ArrayList<Clienti> clienti;

    public void inregistrareClient(Clienti client){
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
        String inserare = "insert into clienti(numar_cont,nume,adresa,tip_cont,sex,data_nasterii,parola,data_crearii) values (?,?,?,?,?,?,?,?)";
       
        try {
            PreparedStatement pstmt = conexiune.prepareStatement(inserare);
            
                pstmt.setInt(1, client.getNumar_cont());
                pstmt.setString(2, client.getNume());
                pstmt.setString(3, client.getAdresa());
                pstmt.setString(4, "Client");
                pstmt.setString(5, client.getSex());
                pstmt.setDate(6, (Date) client.getData_nasterii());
                pstmt.setString(7,client.getParola());
                pstmt.setTimestamp(8, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            
            pstmt.execute();
            pstmt.close();
            conexiune.close();
            
       } catch (SQLException ex) {
            System.out.println("SQL Erro: " + ex);
        }
    }
    
    public ArrayList<Clienti> totiClientii(){
        try {
            ConexiuneBazaDate con = obtineInstanta();
            Connection conexiune = con.creazaConexiune();
            String selectare = "select * from clienti";
            
            if(clienti == null){
                clienti = new ArrayList();
            }
            
            Statement statement = conexiune.createStatement();
            ResultSet rs = statement.executeQuery(selectare);
            
            while(rs.next()){
                clienti.add(obtineDateClienti(rs));
            }
            statement.close();
            rs.close();
            conexiune.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClientiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienti;
        
    }
    
    public Clienti obtineDateClienti(ResultSet resultSet) throws SQLException{
        
        Clienti clienti = new Clienti();
        clienti.setNumar_cont(resultSet.getInt("numar_cont"));
        clienti.setNume(resultSet.getString("nume"));
        clienti.setAdresa(resultSet.getString("adresa"));
        clienti.setTip_cont(resultSet.getString("tip_cont"));
        clienti.setSex(resultSet.getString("sex"));
        clienti.setData_nasterii(resultSet.getDate("data_nasterii"));
        clienti.setParola(resultSet.getString("parola"));
        return clienti;
        
    }
}

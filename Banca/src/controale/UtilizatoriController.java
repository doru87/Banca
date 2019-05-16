/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controale;

import baza.de.date.ConexiuneBazaDate;
import static baza.de.date.ConexiuneBazaDate.obtineInstanta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Depunere;
import modele.Retragere;
import modele.Utilizatori;

/**
 *
 * @author pc
 */
public class UtilizatoriController {
    String nume;
    private ArrayList<Utilizatori> utilizatori;
    Integer numar_cont;
    Integer numar;
    Double suma;
    Date data;
    Depunere depunere;
    private ArrayList<Depunere> depuneri;
    private ArrayList<Retragere> retrageri;
    
    public void logareUtilizator(Utilizatori utilizatori) throws SQLException{
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
        
        String insereaza = "insert into utilizatori(nume,numar_cont,parola,functie,status) values(?,?,?,?,?)";
        
        try{
            PreparedStatement pstmt = conexiune.prepareStatement(insereaza);
            pstmt.setString(1, utilizatori.getNume());
                pstmt.setInt(2, utilizatori.getNumar_cont());
                pstmt.setString(3, utilizatori.getParola());
                pstmt.setString(4, utilizatori.getFunctie());
                pstmt.setString(5, utilizatori.getStatus());

            pstmt.execute();
            pstmt.close();
            conexiune.close();
        }catch(NullPointerException | NumberFormatException ex){
                
        }    
    }
    
    public String getNumeUtilizator(Integer number) throws SQLException{
       
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
        String selectare = "select * from utilizatori where numar_cont="+number;
        
            Statement statement = conexiune.createStatement();
            ResultSet rs = statement.executeQuery(selectare);
            
            while(rs.next()){
                nume = rs.getString("nume");
            }
            return nume;   
    }
    
    public ArrayList<Utilizatori> totiUtilizatorii(){
        try {
            ConexiuneBazaDate con = obtineInstanta();
            Connection conexiune = con.creazaConexiune();
            String selectare = "select * from utilizatori";
            
            if(utilizatori == null){
                utilizatori = new ArrayList();
            }
            
            Statement statement = conexiune.createStatement();
            ResultSet rs = statement.executeQuery(selectare);
            
            while(rs.next()){
                utilizatori.add(obtineDateUtilizatori(rs));
            }
            statement.close();
            rs.close();
            conexiune.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClientiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilizatori;
        
    }
        
    public Utilizatori obtineDateUtilizatori(ResultSet resultSet) throws SQLException{
        
        Utilizatori utilizatori = new Utilizatori();
        
        utilizatori.setNume(resultSet.getString("nume"));
        utilizatori.setNumar_cont(resultSet.getInt("numar_cont"));
        utilizatori.setParola(resultSet.getString("parola"));
        utilizatori.setFunctie(resultSet.getString("functie"));
        utilizatori.setStatus(resultSet.getString("status"));
       
        return utilizatori;
        
    }
    
    public ArrayList<Depunere> cautaUtilizatorDepuneri(String nume) throws SQLException{
   
        depuneri = new ArrayList();
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
       
           String selectare1 = "select * from utilizatori where nume='"+nume+"'";
           Statement statement = conexiune.createStatement();
           ResultSet rs1 = statement.executeQuery(selectare1);
            
            while(rs1.next()){
               numar_cont = rs1.getInt("numar_cont");
               System.out.println(numar_cont);
            }
            
             String selectare2 = "select * from depuneri where numar_cont='"+numar_cont+"'";
             ResultSet rs2 = statement.executeQuery(selectare2);
            
            while(rs2.next()){
               numar = rs2.getInt("numar_cont");
               suma = rs2.getDouble("suma_depunere");
               data = rs2.getDate("data_crearii");

                   depuneri.add(new Depunere(numar,suma,data));
            }
        return depuneri;
        
    }
    
     public ArrayList<Retragere> cautaUtilizatorRetrageri(String nume) throws SQLException{
   
        retrageri = new ArrayList();
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
       
           String selectare1 = "select * from utilizatori where nume='"+nume+"'";
           Statement statement = conexiune.createStatement();
           ResultSet rs1 = statement.executeQuery(selectare1);
            
            while(rs1.next()){
               numar_cont = rs1.getInt("numar_cont");
               System.out.println(numar_cont);
            }
            
             String selectare2 = "select * from retrageri where numar_cont='"+numar_cont+"'";
             ResultSet rs2 = statement.executeQuery(selectare2);
            
            while(rs2.next()){
               numar = rs2.getInt("numar_cont");
               suma = rs2.getDouble("suma_retragere");
               data = rs2.getDate("data_crearii");
        
               retrageri.add(new Retragere(numar,suma,data));
            }    
        return retrageri;
        
    }
}

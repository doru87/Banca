/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controale;

import baza.de.date.ConexiuneBazaDate;
import static baza.de.date.ConexiuneBazaDate.obtineInstanta;
import com.mysql.jdbc.Connection;
import modele.Retragere;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import modele.Depunere;

/**
 *
 * @author pc
 */
public class OperatiiBancareController {
    
    ArrayList<Depunere> depuneri;
    ArrayList<Retragere> retrageri;
    
    
    public void depunereCont(Depunere depozit) throws SQLException{
        
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
        
        String inserare = "insert into depuneri(numar_cont,suma_depunere,data_crearii) values (?,?,?)";
        PreparedStatement pstmt = conexiune.prepareStatement(inserare);
            
            pstmt.setInt(1, depozit.getNumar_cont());
            pstmt.setDouble(2, depozit.getSuma());
            pstmt.setTimestamp(3, (Timestamp) depozit.getData());
            
        pstmt.execute();
        pstmt.close();
        conexiune.close();
    }
    
    
    public Double depunerePrecedenta(Integer number) throws SQLException{
        Double sumaPrecedenta = null;
        ConexiuneBazaDate con = obtineInstanta();
            Connection conexiune = con.creazaConexiune();
            String selectare = "select * from depuneri where numar_cont="+number;
            
            if(depuneri == null){
                depuneri = new ArrayList();
            }
            
            Statement statement = conexiune.createStatement();
            ResultSet rs = statement.executeQuery(selectare);
            
            while(rs.next()){
                Double suma = rs.getDouble("suma_depunere");
                Date data = rs.getDate("data_crearii");
                depuneri.add(new Depunere(number,suma,data));
            }
            
            for(int i=1; i<depuneri.size(); i++){
                sumaPrecedenta = depuneri.get(i).getSuma();
                System.out.println(sumaPrecedenta);
            }
        return sumaPrecedenta;
}
    
        public void retragereCont(Retragere retragere) throws SQLException{
            
            ConexiuneBazaDate con = obtineInstanta();
            Connection conexiune = con.creazaConexiune();
            
            String inserare = "insert into retrageri(numar_cont,suma_retragere,data_crearii) values (?,?,?)";
            PreparedStatement pstmt = conexiune.prepareStatement(inserare);
            
                pstmt.setInt(1, retragere.getNumar_cont());
                pstmt.setDouble(2, retragere.getSuma());
                pstmt.setTimestamp(3, (Timestamp) retragere.getData());
            
            pstmt.execute();
            pstmt.close();
            conexiune.close();
    }
    
    
    public Double retragerePrecedenta(Integer number) throws SQLException{
        
        ArrayList<Depunere> depuneri = null;
        ArrayList<Retragere> retrageri = null;
        Double sumaPrecedenta = null;
        
            ConexiuneBazaDate con = obtineInstanta();
            Connection conexiune = con.creazaConexiune();
            
            String selectare = "select * from retrageri where numar_cont="+number;
            
            if(retrageri == null){
                retrageri = new ArrayList();
            }
            
            Statement statement = conexiune.createStatement();
            ResultSet rs = statement.executeQuery(selectare);
            
            while(rs.next()){
                Double suma = rs.getDouble("suma_retragere");
                Date data = rs.getDate("data_crearii");
                retrageri.add(new Retragere(number,suma,data));
            }
            
            for(int i=1; i<retrageri.size(); i++){
                sumaPrecedenta = retrageri.get(i).getSuma();
                System.out.println(sumaPrecedenta);
            }
        return sumaPrecedenta;
}
    
    public Double sold_total(Integer number) throws SQLException{
        
        Double total_depuneri = 0.0,total_retrageri = 0.0;
        ConexiuneBazaDate con = obtineInstanta();
        Connection conexiune = con.creazaConexiune();
        
        String depunere = "select * from depuneri where numar_cont="+number;
            
            if(depuneri == null){
                depuneri = new ArrayList();
            }
            
            Statement statement = conexiune.createStatement();
            ResultSet rs1 = statement.executeQuery(depunere);
            
            while(rs1.next()){
                Double suma = rs1.getDouble("suma_depunere");
                Date data = rs1.getDate("data_crearii");
                depuneri.add(new Depunere(number,suma,data));
            }
            
            for(int i=0; i<depuneri.size(); i++){
               total_depuneri += depuneri.get(i).getSuma();
               System.out.println(total_depuneri);
            }
            
            
            String retragere = "select * from retrageri where numar_cont="+number;
            
            if(retrageri == null){
                retrageri = new ArrayList();
            }

            ResultSet rs2 = statement.executeQuery(retragere);
            
            while(rs2.next()){
                Double suma = rs2.getDouble("suma_retragere");
                Date data = rs2.getDate("data_crearii");
                retrageri.add(new Retragere(number,suma,data));
            }
            
            for(int i=0; i<retrageri.size(); i++){
                total_retrageri += retrageri.get(i).getSuma();
            }
            
        return total_depuneri-total_retrageri;
        
    }
}



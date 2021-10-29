/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Exemplo;

/**
 *
 * @author Tong
 */
public class ExemploDAO {
    public Boolean inserir(Exemplo exemplo) throws SQLException
    {
        Boolean retorno = false;
       
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try
        {
            String sql = "INSERT INTO exemplo (imagem) values (?)";
            stmt = con.prepareStatement(sql);
            stmt.setBytes(1, exemplo.getImagem());
            stmt.executeUpdate();
            retorno = true;
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return retorno;
    
    }
    
    public Exemplo buscar(Integer id) throws SQLException
    {
        Exemplo retorno = null;
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "SELECT id,imagem from exemplo where id=?";
       
        try {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {       
                retorno = new Exemplo();
                retorno.setId(rs.getInt("id"));
                retorno.setImagem(rs.getBytes("imagem"));
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }
        
        return retorno;
    
    }
}

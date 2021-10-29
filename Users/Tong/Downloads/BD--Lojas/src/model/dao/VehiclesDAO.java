/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Vehicles;
import java.sql.ResultSet;
import java.util.List;
import model.bean.Clients;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class VehiclesDAO {

    public void create(Vehicles v) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO vehicles (model,brand,plate,year,"
                    + "km_current,color,type_fuel,clients_id) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getModel());
            stmt.setString(2, v.getBrand());
            stmt.setString(3, v.getPlate());
            stmt.setInt(4, v.getYear());
            stmt.setDouble(5, v.getKm_current());
            stmt.setString(6, v.getColor());
            stmt.setString(7, v.getType_fuel());
            stmt.setInt(8, v.getClient().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void alter(Vehicles v) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE vehicles SET model=?,brand=?,plate=?,year=?,"
                    + "km_current=?,color=?,type_fuel=?,clients_id=? "
                    + "WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getModel());
            stmt.setString(2, v.getBrand());
            stmt.setString(3, v.getPlate());
            stmt.setInt(4, v.getYear());
            stmt.setDouble(5, v.getKm_current());
            stmt.setString(6, v.getColor());
            stmt.setString(7, v.getType_fuel());
            stmt.setInt(8, v.getClient().getId());
            stmt.setInt(9, v.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Vehicles p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM vehicles WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Vehicles> list() throws Exception {
        ArrayList<Vehicles> lista = new ArrayList<Vehicles>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM vehicles";
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicles v = new Vehicles();
                v.setId(rs.getInt("id"));
                v.setModel(rs.getString("model"));
                v.setBrand(rs.getString("brand"));
                v.setPlate(rs.getString("plate"));
                v.setYear(rs.getInt("year"));
                v.setKm_current(rs.getDouble("km_current"));
                v.setColor(rs.getString("color"));
                v.setType_fuel(rs.getString("type_fuel"));

                Clients c = new Clients();
                c.setId(rs.getInt("id"));
                c.load();
                v.setClient(c);

                lista.add(v);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public Vehicles loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        Vehicles v = new Vehicles();

        try {
            String sql = "SELECT * FROM clients WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setModel(rs.getString("model"));
                v.setBrand(rs.getString("brand"));
                v.setPlate(rs.getString("plate"));
                v.setYear(rs.getInt("year"));
                v.setKm_current(rs.getDouble("km_current"));
                v.setColor(rs.getString("color"));
                v.setType_fuel(rs.getString("type_fuel"));

                Clients c = new Clients();
                c.setId(rs.getInt("id"));
                c.load();
                v.setClient(c);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return v;
    }
    
    public List<Vehicles> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Vehicles> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vehicles");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                Vehicles v = new Vehicles();

                v.setId(rs.getInt("id"));
                v.setModel(rs.getString("model"));
                v.setBrand(rs.getString("brand"));
                v.setPlate(rs.getString("plate"));
                v.setYear(rs.getInt("year"));
                v.setColor(rs.getString("color"));
                v.setType_fuel(rs.getString("type_fuel"));
                v.setKm_current(rs.getDouble("km_current"));
                v.setClientId(rs.getInt("clients_id"));

                produtos.add(v);
              
            }
            
          } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return produtos;

    }
    public List<Vehicles> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Vehicles> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vehicles WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Vehicles v = new Vehicles();

                v.setId(rs.getInt("id"));
                v.setModel(rs.getString("model"));
                v.setBrand(rs.getString("brand"));
                v.setPlate(rs.getString("plate"));
                v.setYear(rs.getInt("year"));
                v.setColor(rs.getString("color"));
                v.setType_fuel(rs.getString("type_fuel"));
                v.setKm_current(rs.getDouble("km_current"));
                v.setClientId(rs.getInt("clients_id"));

                produtos.add(v);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return produtos;

    }
}

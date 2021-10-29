/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;
import model.bean.Budgets;
import model.bean.Clients;
import model.bean.Services;
import model.bean.Vehicles;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class BudgetsDAO {

    public void create(Budgets b) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO budgets (date,price_services,total_items,total,id_vehicle,"
                    + "id_service,id_client) VALUES (now(),?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, b.getPrice_services());
            stmt.setDouble(2, b.getTotal_items());
            stmt.setDouble(3, b.getTotal());
            stmt.setInt(4, b.getVehicle().getId());
            stmt.setInt(5, b.getService().getId());
            stmt.setInt(6, b.getClient().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Budgets b) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE budgets SET date = now(),price_services = ?,"
                    + "total_items = ?,total = ?,id_vehicle = ?,id_service = ?,"
                    + "id_client = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, b.getPrice_services());
            stmt.setDouble(2, b.getTotal_items());
            stmt.setDouble(3, b.getTotal());
            stmt.setInt(4, b.getVehicle().getId());
            stmt.setInt(5, b.getService().getId());
            stmt.setInt(6, b.getClient().getId());
            stmt.setInt(7, b.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Budgets p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM budget WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Budgets> list() throws Exception {
        ArrayList<Budgets> lista = new ArrayList<Budgets>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM budgets";
            stmt = con.prepareStatement(sql);
            /*
            ResultSet é uma interface utilizada pra guardar dados vindos 
            de um banco de dados.
            
            Basicamente, ela guarda o resultado de uma pesquisa numa estrutura 
            de dados que pode ser percorrida, de forma que você possa ler os 
            dados do banco.
             */
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Budgets b = new Budgets();
                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));

                Vehicles v = new Vehicles();
                v.setId(rs.getInt("id_vehicle"));
                v.load();
                b.setVehicle(v);

                Services s = new Services();
                s.setId(rs.getInt("id_service"));
                s.load();
                b.setService(s);

                Clients c = new Clients();
                c.setId(rs.getInt("id_client"));
                c.load();
                b.setClient(c);

                lista.add(b);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public Budgets loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        Budgets b = new Budgets();

        try {
            String sql = "SELECT * FROM orders WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));

                Vehicles v = new Vehicles();
                v.setId(rs.getInt("id_vehicle"));
                v.load();
                b.setVehicle(v);

                Services s = new Services();
                s.setId(rs.getInt("id_service"));
                s.load();
                b.setService(s);

                Clients c = new Clients();
                c.setId(rs.getInt("id_client"));
                c.load();
                b.setClient(c);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return b;
    }
    
    public List<Budgets> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Budgets> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budget");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Budgets b = new Budgets();

                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));
                b.setVehiclesId(rs.getInt("id_vehicle"));
                b.setClientsId(rs.getInt("id_client"));
                b.setServicesId(rs.getInt("id_service"));
                produtos.add(b);
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }
    
    public List<Budgets> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Budgets> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budget WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Budgets b = new Budgets();

                b.setId(rs.getInt("id"));
                b.setDate(rs.getDate("date"));
                b.setPrice_services(rs.getDouble("price_services"));
                b.setTotal_items(rs.getDouble("total_items"));
                b.setTotal(rs.getDouble("total"));
                b.setVehiclesId(rs.getInt("id_vehicle"));
                b.setClientsId(rs.getInt("id_client"));
                b.setServicesId(rs.getInt("id_service"));
                produtos.add(b);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;

    }
     
}

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
import model.bean.BudgetsDetails;
import model.bean.Clients;
import model.bean.Products;
import model.bean.Services;
import model.bean.Vehicles;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class BudgetsDetailsDAO {

    public void create(BudgetsDetails bd) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO budgets_details (price,amount,subtotal,"
                    + "id_budget,id_product) VALUES (?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, bd.getPrice());
            stmt.setDouble(2, bd.getAmount());
            stmt.setDouble(3, bd.getSubtotal());
            stmt.setInt(4, bd.getBudget().getId());
            stmt.setInt(5, bd.getProduct().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(BudgetsDetails bd) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE budgets_details SET price = ?,amount = ?,"
                    + "subtotal = ?,id_budget = ?,id_product = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, bd.getPrice());
            stmt.setDouble(2, bd.getAmount());
            stmt.setDouble(3, bd.getSubtotal());
            stmt.setInt(4, bd.getBudget().getId());
            stmt.setInt(5, bd.getProduct().getId());
            stmt.setInt(6, bd.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(BudgetsDetails p) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM budgets_details WHERE id = ?");
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<BudgetsDetails> list() throws Exception {
        ArrayList<BudgetsDetails> lista = new ArrayList<BudgetsDetails>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM budgets_details";
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
                BudgetsDetails bd = new BudgetsDetails();
                bd.setId(rs.getInt("id"));
                bd.setPrice(rs.getDouble("price"));
                bd.setAmount(rs.getDouble("amount"));
                bd.setSubtotal(rs.getDouble("subtotal"));

                Budgets b = new Budgets();
                b.setId(rs.getInt("id_budget"));
                b.load();
                bd.setBudget(b);

                Products p = new Products();
                p.setId(rs.getInt("id_client"));
                p.load();
                bd.setProduct(p);

                lista.add(bd);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public BudgetsDetails loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        BudgetsDetails bd = new BudgetsDetails();

        try {
            String sql = "SELECT * FROM budgets_details WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bd.setId(rs.getInt("id"));
                bd.setPrice(rs.getDouble("price"));
                bd.setAmount(rs.getDouble("amount"));
                bd.setSubtotal(rs.getDouble("subtotal"));

                Budgets b = new Budgets();
                b.setId(rs.getInt("id_budget"));
                b.load();
                bd.setBudget(b);

                Products p = new Products();
                p.setId(rs.getInt("id_client"));
                p.load();
                bd.setProduct(p);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return bd;
    }
    
     public List<BudgetsDetails> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BudgetsDetails> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budgets_details");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BudgetsDetails bd = new BudgetsDetails();

                bd.setId(rs.getInt("id"));
                bd.setPrice(rs.getDouble("price"));
                bd.setAmount(rs.getDouble("amount"));
                bd.setSubtotal(rs.getDouble("subtotal"));
                bd.setBudgetsId(rs.getInt("id_budget"));
                bd.setProductsId(rs.getInt("id_product"));
                
                produtos.add(bd);
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }
     
     public List<BudgetsDetails> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BudgetsDetails> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM budgets_details WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                BudgetsDetails bd = new BudgetsDetails();

                bd.setId(rs.getInt("id"));
                bd.setPrice(rs.getDouble("price"));
                bd.setAmount(rs.getDouble("amount"));
                bd.setSubtotal(rs.getDouble("subtotal"));
                bd.setBudgetsId(rs.getInt("id_budget"));
                bd.setProductsId(rs.getInt("id_product"));
                produtos.add(bd);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return produtos;

    }
}

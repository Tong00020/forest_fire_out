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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Products;
import model.bean.Providers;

/**
 *
 * @author Tong
 */
public class ProductsDAO {

    public void create(Products p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO products (name,description,category,"
                    + "price,barcode,quantity,id_provider) VALUES (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setString(3, p.getCategory());
            stmt.setDouble(4, p.getPrice());
            stmt.setInt(5, p.getBarcode());
            stmt.setInt(6, p.getQuantity());
            stmt.setInt(7, p.getProvider().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Products p) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE products SET name = ?,description = ?,"
                    + "category = ?,price = ?,barcode = ?,quantity = ?,"
                    + "id_provider = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setString(3, p.getCategory());
            stmt.setDouble(4, p.getPrice());
            stmt.setInt(5, p.getBarcode());
            stmt.setInt(6, p.getQuantity());
            stmt.setInt(7, p.getProvider().getId());
            stmt.setInt(8, p.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Products p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Products> list() throws Exception {
        ArrayList<Products> lista = new ArrayList<Products>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM products";
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

                Products p = new Products();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setBarcode(rs.getInt("barcode"));
                p.setQuantity(rs.getInt("quantity"));

                Providers pv = new Providers();
                pv.setId(rs.getInt("id"));
                pv.load();
                p.setProvider(pv);

                lista.add(p);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public Products loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        Products p = new Products();

        try {
            String sql = "SELECT * FROM products WHERE id=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setBarcode(rs.getInt("barcode"));
                p.setQuantity(rs.getInt("quantity"));

                Providers pv = new Providers();
                pv.setId(rs.getInt("id"));
                pv.load();
                p.setProvider(pv);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return p;
    }

    public List<Products> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Products> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Products p = new Products();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setBarcode(rs.getInt("barcode"));
                p.setQuantity(rs.getInt("quantity"));
                p.setProvidersId(rs.getInt("id_provider"));

                produtos.add(p);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }

    public List<Products> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Products> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE id LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Products p = new Products();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setBarcode(rs.getInt("barcode"));
                p.setQuantity(rs.getInt("quantity"));
                p.setProvidersId(rs.getInt("id_provider"));
                produtos.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Employees;
import connection.ConnectionFactory;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import model.bean.Privileges;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class EmployeesDAO {

    public void create(Employees e) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO employees (name,photo,email,cpf,"
                    + "cell_phone,fixed_phone,cep,address,address_number,"
                    + "complement,city,state,status,login,password,job_title,"
                    + "report_to,id_privilege) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getPhoto());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getCpf());
            stmt.setString(5, e.getCell_phone());
            stmt.setString(6, e.getFixed_phone());
            stmt.setString(7, e.getCep());
            stmt.setString(8, e.getAddress());
            stmt.setInt(9, e.getAddress_number());
            stmt.setString(10, e.getComplement());
            stmt.setString(11, e.getCity());
            stmt.setString(12, e.getState());
            stmt.setString(13, e.getStatus());
            stmt.setString(14, e.getLogin());
            stmt.setString(15, e.getPassword());
            stmt.setString(16, e.getJob_title());
            stmt.setInt(17, e.getReport_to().getId());
            stmt.setInt(18, e.getPrivilege().getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alter(Employees e) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE employees SET name = ?,photo = ?,email = ?,"
                    + "cpf = ?,cell_phone = ?,fixed_phone = ?,cep = ?,address = ?,"
                    + "address_number = ?,complement = ?,city = ?,state = ?,"
                    + "status = ?,login = ?,password = ?,job_title = ?,"
                    + "report_to = ?,id_privilege = ? WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getName());
            stmt.setString(2, e.getPhoto());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getCpf());
            stmt.setString(5, e.getCell_phone());
            stmt.setString(6, e.getFixed_phone());
            stmt.setString(7, e.getCep());
            stmt.setString(8, e.getAddress());
            stmt.setInt(9, e.getAddress_number());
            stmt.setString(10, e.getComplement());
            stmt.setString(11, e.getCity());
            stmt.setString(12, e.getState());
            stmt.setString(13, e.getStatus());
            stmt.setString(14, e.getLogin());
            stmt.setString(15, e.getPassword());
            stmt.setString(16, e.getJob_title());
            stmt.setInt(17, e.getReport_to().getId());
            stmt.setInt(18, e.getPrivilege().getId());
            stmt.setInt(19, e.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Employees p) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM employees WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Employees> list() throws Exception {
        ArrayList<Employees> lista = new ArrayList<Employees>();

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM employees";
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

                Employees e = new Employees();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setPhoto(rs.getString("photo"));
                e.setEmail(rs.getString("email"));
                e.setCpf(rs.getString("cpf"));
                e.setCell_phone(rs.getString("cell_phone"));
                e.setFixed_phone(rs.getString("fixed_phone"));
                e.setCep(rs.getString("cep"));
                e.setAddress(rs.getString("address"));
                e.setAddress_number(rs.getInt("address_number"));
                e.setComplement(rs.getString("complement"));
                e.setCity(rs.getString("city"));
                e.setState(rs.getString("state"));
                e.setStatus(rs.getString("status"));
                e.setLogin(rs.getString("login"));
                e.setPassword(rs.getString("password"));
                e.setJob_title(rs.getString("job_title"));

                Employees em = new Employees();
                em.setId(rs.getInt("report_to"));
                em.load();
                e.setReport_to(em);

                Privileges p = new Privileges();
                p.setId(rs.getInt("id_privilege"));
                p.load();
                e.setPrivilege(p);

                lista.add(e);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return lista;
    }

    public Employees loadById(int id) throws Exception {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        Employees e = new Employees();

        try {
            String sql = "SELECT * FROM employees WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setPhoto(rs.getString("photo"));
                e.setEmail(rs.getString("email"));
                e.setCpf(rs.getString("cpf"));
                e.setCell_phone(rs.getString("cell_phone"));
                e.setFixed_phone(rs.getString("fixed_phone"));
                e.setCep(rs.getString("cep"));
                e.setAddress(rs.getString("address"));
                e.setAddress_number(rs.getInt("address_number"));
                e.setComplement(rs.getString("complement"));
                e.setCity(rs.getString("city"));
                e.setState(rs.getString("state"));
                e.setStatus(rs.getString("status"));
                e.setLogin(rs.getString("login"));
                e.setPassword(rs.getString("password"));
                e.setJob_title(rs.getString("job_title"));

                Employees em = new Employees();
                em.setId(rs.getInt("report_to"));
                em.load();
                e.setReport_to(em);

                Privileges p = new Privileges();
                p.setId(rs.getInt("id_privilege"));
                p.load();
                e.setPrivilege(p);
            }

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return e;
    }

    public List<Employees> read() throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Employees> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM employees");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Employees e = new Employees();

                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setPhoto(rs.getString("photo"));
                e.setEmail(rs.getString("email"));
                e.setCpf(rs.getString("cpf"));
                e.setCell_phone(rs.getString("cell_phone"));
                e.setFixed_phone(rs.getString("fixed_phone"));
                e.setCep(rs.getString("cep"));
                e.setAddress(rs.getString("address"));
                e.setAddress_number(rs.getInt("address_number"));
                e.setComplement(rs.getString("complement"));
                e.setCity(rs.getString("city"));
                e.setState(rs.getString("state"));
                e.setStatus(rs.getString("status"));
                e.setLogin(rs.getString("login"));
                e.setPassword(rs.getString("password"));
                e.setJob_title(rs.getString("job_title"));
                e.setEmployeesId(rs.getInt("report_to"));
                e.setPrivilegesId(rs.getInt("id_privilege"));
                produtos.add(e);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }

    public List<Employees> readForDesc(String desc) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Employees> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM employees WHERE id LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Employees e = new Employees();

                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setPhoto(rs.getString("photo"));
                e.setEmail(rs.getString("email"));
                e.setCpf(rs.getString("cpf"));
                e.setCell_phone(rs.getString("cell_phone"));
                e.setFixed_phone(rs.getString("fixed_phone"));
                e.setCep(rs.getString("cep"));
                e.setAddress(rs.getString("address"));
                e.setAddress_number(rs.getInt("address_number"));
                e.setComplement(rs.getString("complement"));
                e.setCity(rs.getString("city"));
                e.setState(rs.getString("state"));
                e.setStatus(rs.getString("status"));
                e.setLogin(rs.getString("login"));
                e.setPassword(rs.getString("password"));
                e.setJob_title(rs.getString("job_title"));
                e.setEmployeesId(rs.getInt("report_to"));
                e.setPrivilegesId(rs.getInt("id_privilege"));
                produtos.add(e);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return produtos;

    }

    public boolean checkLogin(String login, String password) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM employees WHERE login = ? and password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
}

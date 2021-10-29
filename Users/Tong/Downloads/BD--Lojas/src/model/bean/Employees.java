/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.dao.EmployeesDAO;
import java.util.ArrayList;

/**
 *
 * @author Tong
 */
public class Employees {

    private int id;
    private String name;
    private String photo;
    private String email;
    private String cpf;
    private String cell_phone;
    private String fixed_phone;
    private String cep;
    private String address;
    private int address_number;
    private String complement;
    private String city;
    private String state;
    private String status;
    private String login;
    private String password;
    private String job_title;
    private Employees report_to;
    private Privileges privilege;
    
    public int getEmployeesId() {
        return report_to.getId();
    }
    
    public void setEmployeesId(int id) {
        this.report_to.setId(id);
    }
    
    public int getPrivilegesId() {
        return privilege.getId();
    }
    
    public void setPrivilegesId(int id) {
        this.privilege.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getFixed_phone() {
        return fixed_phone;
    }

    public void setFixed_phone(String fixed_phone) {
        this.fixed_phone = fixed_phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddress_number() {
        return address_number;
    }

    public void setAddress_number(int address_number) {
        this.address_number = address_number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Employees getReport_to() {
        return report_to;
    }

    public void setReport_to(Employees report_to) {
        this.report_to = report_to;
    }

    public Privileges getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privileges privilege) {
        this.privilege = privilege;
    }

    public void create() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        eDAO.create(this);
    }

    public void alter() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        eDAO.alter(this);
    }

    public void delete() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        eDAO.delete(this);
    }

    public ArrayList<Employees> list() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        return eDAO.list();
    }

    public void load() throws Exception {
        EmployeesDAO eDAO = new EmployeesDAO();
        this.id = eDAO.loadById(this.id).getId();
        this.cpf = eDAO.loadById(this.id).getCpf();
        this.name = eDAO.loadById(this.id).getName();
        this.address_number = eDAO.loadById(this.id).getAddress_number();
        this.fixed_phone = eDAO.loadById(this.id).getFixed_phone();
        this.cell_phone = eDAO.loadById(this.id).getCell_phone();
        this.email = eDAO.loadById(this.id).getEmail();
        this.cep = eDAO.loadById(this.id).getCep();
        this.state = eDAO.loadById(this.id).getState();
        this.city = eDAO.loadById(this.id).getCity();
        this.complement = eDAO.loadById(this.id).getComplement();
        this.address = eDAO.loadById(this.id).getAddress();
        this.status = eDAO.loadById(this.id).getStatus();
        this.job_title = eDAO.loadById(this.id).getJob_title();
        this.login = eDAO.loadById(this.id).getLogin();
        this.password = eDAO.loadById(this.id).getPassword();
        this.photo = eDAO.loadById(this.id).getPhoto();
        this.report_to = eDAO.loadById(this.id).getReport_to();
        this.privilege = eDAO.loadById(this.id).getPrivilege();
    }

}

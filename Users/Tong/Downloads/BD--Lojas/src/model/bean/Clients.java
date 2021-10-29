/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.dao.ClientsDAO;
import java.util.ArrayList;

/**
 *
 * @author Tong
 */
public class Clients {

    private int id;
    private String cpf;
    private String name;
    private String address;
    private String address_number;
    private String complement;
    private String state;
    private String city;
    private String cep;
    private String fixed_phone;
    private String cell_phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFixed_phone() {
        return fixed_phone;
    }

    public void setFixed_phone(String fixed_phone) {
        this.fixed_phone = fixed_phone;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void create() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        cDAO.create(this);
    }

    public void alter() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        cDAO.alter(this);
    }

    public void delete() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        cDAO.delete(this);
    }

    public ArrayList<Clients> list() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        return cDAO.list();
    }

    public void load() throws Exception {
        ClientsDAO cDAO = new ClientsDAO();
        this.id = cDAO.loadById(this.id).getId();
        this.cpf = cDAO.loadById(this.id).getCpf();
        this.name = cDAO.loadById(this.id).getName();
        this.address = cDAO.loadById(this.id).getAddress();
        this.address_number = cDAO.loadById(this.id).getAddress_number();
        this.complement = cDAO.loadById(this.id).getComplement();
        this.state = cDAO.loadById(this.id).getState();
        this.city = cDAO.loadById(this.id).getCity();
        this.cep = cDAO.loadById(this.id).getCep();
        this.fixed_phone = cDAO.loadById(this.id).getFixed_phone();
        this.cell_phone = cDAO.loadById(this.id).getCell_phone();
        this.email = cDAO.loadById(this.id).getEmail();
    }

}

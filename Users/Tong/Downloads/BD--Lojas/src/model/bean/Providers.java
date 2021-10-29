/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.dao.ProvidersDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tong
 */
public class Providers {

    private int id;
    private String name;
    private String cnpj;
    private String cell_phone;
    private String fixed_phone;
    private String cep;
    private String address;
    private int address_number;
    private String complement;
    private String city;
    private String state;
    private String url_site;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getUrl_site() {
        return url_site;
    }

    public void setUrl_site(String url_site) {
        this.url_site = url_site;
    }

    public void create() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        pDAO.delete(this);
    }

    public ArrayList<Providers> list() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        return pDAO.list();
    }
    
    public List<Providers> read() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        return pDAO.read();
    }

    public void load() throws Exception {
        ProvidersDAO pDAO = new ProvidersDAO();
        this.id = pDAO.loadID(this.id).getId();
        this.name = pDAO.loadID(this.id).getName();
        this.cnpj = pDAO.loadID(this.id).getCnpj();
        this.cell_phone = pDAO.loadID(this.id).getCell_phone();
        this.fixed_phone = pDAO.loadID(this.id).getFixed_phone();
        this.cep = pDAO.loadID(this.id).getCep();
        this.address = pDAO.loadID(this.id).getAddress();
        this.address_number = pDAO.loadID(this.id).getAddress_number();
        this.complement = pDAO.loadID(this.id).getComplement();
        this.city = pDAO.loadID(this.id).getCity();
        this.state = pDAO.loadID(this.id).getState();
        this.url_site = pDAO.loadID(this.id).getUrl_site();
    }
}

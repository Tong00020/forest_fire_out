/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.ArrayList;
import java.util.List;
import model.dao.ServicesDAO;

/**
 *
 * @author Vinícius Vasconcelos
 */
public class Services {

    private int id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void create() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        sDAO.create(this);
    }

    public void alter() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        sDAO.alter(this);
    }

    public void delete() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        sDAO.delete(this);
    }

    public ArrayList<Services> list() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        return sDAO.list();
    }
    
    public List<Services> read() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        return sDAO.read();
    }
    public void load() throws Exception {
        ServicesDAO sDAO = new ServicesDAO();
        this.id = sDAO.loadById(this.id).getId();
        this.name = sDAO.loadById(this.id).getName();
        this.description = sDAO.loadById(this.id).getDescription();
    }
}

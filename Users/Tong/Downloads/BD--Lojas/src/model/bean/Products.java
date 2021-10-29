/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import static com.sun.tools.attach.spi.AttachProvider.providers;
import model.dao.ProductsDAO;
import java.util.ArrayList;
import model.dao.ProvidersDAO;

/**
 *
 * @author Tong
 */
public class Products {

    private int id;
    private String name;
    private String description;
    private String category;
    private double price;
    private int barcode;
    private int quantity;
    private Providers provider;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public Providers getProvider() {
        return provider;
    }

    public void setProvider(Providers provider) {
        this.provider = provider;
    }

    public int getProvidersId() {
        return provider.getId();
    }

    public void setProvidersId(int id) {
        this.provider.setId(id);
    }

    public void create() throws Exception {
        ProductsDAO pDAO = new ProductsDAO();
        pDAO.create(this);
    }

    public void alter() throws Exception {
        ProductsDAO pDAO = new ProductsDAO();
        pDAO.alter(this);
    }

    public void delete() throws Exception {
        ProductsDAO pDAO = new ProductsDAO();
        pDAO.delete(this);
    }

    public ArrayList<Products> list() throws Exception {
        ProductsDAO pDAO = new ProductsDAO();
        return pDAO.list();
    }

    public void load() throws Exception {
        ProductsDAO pDAO = new ProductsDAO();
        this.id = pDAO.loadById(this.id).getId();
        this.name = pDAO.loadById(this.id).getName();
        this.description = pDAO.loadById(this.id).getDescription();
        this.category = pDAO.loadById(this.id).getCategory();
        this.price = pDAO.loadById(this.id).getPrice();
        this.barcode = pDAO.loadById(this.id).getBarcode();
        this.quantity = pDAO.loadById(this.id).getQuantity();
        this.provider = pDAO.loadById(this.id).getProvider();
    }

}

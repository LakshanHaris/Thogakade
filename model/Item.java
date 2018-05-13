/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.thogakade_home.model;

/**
 *
 * @author Lakshan Ranasinghe
 */
public class Item {

    private String code;
    private String description;
    private String unitPrice;
    private String qtyOnHand;

    public Item() {

    }

    public Item(String code, String description, String unitPrice, String qtyOnHand) {

        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;

    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unitPrice
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qtyOnHan
     */
    public String getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHan the qtyOnHan to set
     */
    public void setQtyOnHand(String qtyOnHan) {
        this.qtyOnHand = qtyOnHan;
    }
}

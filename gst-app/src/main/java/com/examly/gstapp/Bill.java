package com.examly.gstapp;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {

    @Id
    private int id;
    private String name;
    private int gst;
    private double price;
    private double netprice;
    private int qty;

    public Bill() {
        super();
    }

    public Bill(int id, String name, int gst, double price, int qty,double netprice) {
        setId(id);setName(name);setGst(gst);setPrice(price);setQty(qty);setNetprice(netprice);
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

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getNetprice() {
        return netprice;
    }

    public void setNetprice(double netprice) {
        this.netprice = netprice;
    }
}

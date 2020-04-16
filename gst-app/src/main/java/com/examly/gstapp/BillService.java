package com.examly.gstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    BillRepo repo;

    public List<Bill> getBillOfAllProducts(){
        return repo.findAll();
    }

    public void addProductToBill(int qty,Product p){
        Bill b = new Bill(p.getId(),p.getName(),p.getGst(),p.getPrice(),qty,netPriceCalc(qty,p.getGst(),p.getPrice()));
        repo.save(b);
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }

    public double netPriceCalc(int qty,int gst, double price){
        double np;
        np = price*(100+gst)/100;
        return (qty==0)?np:np*qty;
    }

    public double getTotalAmount() {
        double amt = repo.getTotalAmount();
        System.out.println(amt);
        return amt;
    }
}

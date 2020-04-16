package com.examly.gstapp;

import com.fasterxml.jackson.databind.deser.CreatorProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;
    @Autowired
    BillService billService;

    // ========   Product Page Controls ---
    @GetMapping("/")
    public String viewProductHomePage(Model model){
        List<Product> p = productService.getListAllProducts();
        model.addAttribute("productlist",p);
        return "index";
    }
    @GetMapping("/new")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "addProduct";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView updateProduct(@PathVariable int id){
        ModelAndView model = new ModelAndView("editProduct");
        model.addObject("product",productService.getById(id));
        return model;
    }
    @PostMapping("/save")
    public String addProduct(@ModelAttribute("product") Product p){
        productService.saveByProduct(p);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteById(id);
        return "redirect:/";
    }


    // ========   Bill Page Controls ---
    @GetMapping("/bill")
    public String viewBillHomePage(Model model){
        List<Bill> b = billService.getBillOfAllProducts();
        model.addAttribute("billlist",b);
        double netAmt = billService.getTotalAmount();
        model.addAttribute("netAmt",netAmt);
        return "bill";
    }
    @GetMapping("/newitem")
    public String addProductToBill(Model model){
        List<Product> p = productService.getListAllProducts();
        model.addAttribute("productlist",p);
        return "search";
    }
    @GetMapping("/qty/{id}")
    public ModelAndView getQtyProduct(@PathVariable int id){
        ModelAndView model = new ModelAndView("addQuantity");
        model.addObject("product",productService.getById(id));
        return model;
    }
    @PostMapping("/saveitem/{id}")
    public String addProductToBill(@PathVariable("id") int id, @RequestParam("qty") int qty){
        billService.addProductToBill(qty,productService.getById(id));
        return "redirect:/bill";
    }
    @GetMapping("/deleteitem/{id}")
    public String deleteProductFromBill(@PathVariable int id){
        billService.deleteById(id);
        return "redirect:/bill";
    }



}

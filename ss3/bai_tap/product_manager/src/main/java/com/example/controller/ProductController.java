package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @GetMapping("/showList")
    public String showListProduct(@RequestParam(name = "search", required = false) String search, Model model){
        model.addAttribute("listProduct", iProductService.listAllProducts(search));
        return "/index";
    }
    @GetMapping("/createProduct")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/saveProduct")
    public String createProduct(Product product){
        product.setId(iProductService.listAllProducts(null).size()+1);
        iProductService.createProduct(product);
        return "redirect:/product/showList";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        iProductService.deleteProduct(id);
        return "redirect:/product/showList";
    }
    @GetMapping("/information/{id}")
    public String showInformation(@PathVariable int id,Model model){
        model.addAttribute("productInform",iProductService.findProductById(id));
        return "/information";
    }
    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findProductById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String editProduct(Product product){
        iProductService.editProduct(product);
        return "redirect:/product/showList";
    }
}

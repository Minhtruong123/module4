package com.example.product.controller;

import com.example.product.model.Cart;
import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/inform/{id}")
    public ModelAndView informationOfTheProduct(Model model, @PathVariable int id, HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("id", id+"");
        cookie.setMaxAge(60*60^24);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        return new ModelAndView("information","product", productService.findById(id));
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!((Optional<?>) productOptional).isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("list")){
            cart.addProduct(productOptional.get());
            return "redirect:/shop";
        }
        cart.decreaseProduct((productOptional.get()));
        return "redirect:/shopping-cart";
    }
}
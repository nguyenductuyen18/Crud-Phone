package com.example.crudproduct.controller;

import com.example.crudproduct.model.Phone;
import com.example.crudproduct.sevice.IProductSevice;
//import com.example.crudproduct.sevice.ProductSevice;
import com.example.crudproduct.sevice.ProductSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductSevice productService=new ProductSevice();
    @GetMapping("")
    public String showProduct(Model model){
        List<Phone> phone = productService.finAll();
        model.addAttribute("phone",phone);
        return "index";
    }

    @GetMapping ("/add")
    public String addProduct(Model model){
        model.addAttribute("phone",new Phone());
        return "add";
    }
    @PostMapping("/save")
    public String saveProduct(Phone phone){
        phone.setId((int) (Math.random() * 100));
        productService.add(phone);
        return "redirect:/product";
    }

    @GetMapping ("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("phone",productService.fileById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Phone phone){
        productService.update(phone.getId(),phone);
        return "redirect:/product";
    }
    @GetMapping ("/{id}/remote")
    public String remote(@PathVariable int id, Model model){
        model.addAttribute("phone",productService.fileById(id));
        return "remote";
    }
    @PostMapping("/delete")
    public String delete(Phone phone){
        productService.delete(phone.getId());
        return "redirect:/product";
    }
    @GetMapping ("/{id}/show")
    public String show(@PathVariable int id, Model model){
        model.addAttribute("phone",productService.fileById(id));
        return "show";
    }

    @PostMapping ("/search")
    public String search1(@RequestParam("name") String name, Model model){
        model.addAttribute("Phone",productService.search(name));
        return "search";
    }



}

package com.yangyang.controller;

import com.yangyang.model.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller@RequestMapping("/product")
public class ProductController {
    private static final Log log = LogFactory.getLog(ProductController.class);

    private static final Map<String,Object> maps = new HashMap<>();

    @GetMapping("/add")
    public String getProduct(){
        log.info("input product controller called ... ");
        return "productFrom";
    }
    @PostMapping("/save")
    public String saveProduct(
            HttpServletRequest request,
            Model model,
            RedirectAttributes redirectAttributes
    ){
        log.info("save product ... ");
        Product product = new Product(
                request.getParameter("name"),
                request.getParameter("description"),
                Double.parseDouble(request.getParameter("price"))
        );
        redirectAttributes.addFlashAttribute("message","The product was successfully saved!");
        product.setId(1);
        model.addAttribute("product",product);
        maps.put("product",product);

        return "redirect:/product/view/"+product.getId();
    }
    @RequestMapping("/view/{id}")
    public String viewProduct(@PathVariable("id") Integer id,@ModelAttribute("message")String message, Model model){
        model.addAttribute("product",maps.get("product"));

        System.out.println("id: "+id+" -> "+message);

        return "productDetails";
    }

    @GetMapping(value = "/bookInput")
    public String inputBook(Model model){
        model.addAttribute("book",new Product("name","description",123.123));
        return "BookAdd";
    }
}

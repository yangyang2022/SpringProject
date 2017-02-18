package com.yangyang.controller;

import com.yangyang.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller@RequestMapping("/file")
public class ProductFileController {


    @GetMapping("/input")
    public String saveFile(Model model){
        model.addAttribute("product",new Product());
        return "ProductFileFrom";
    }

    @PostMapping("/save")
    public String saveFile(
            HttpServletRequest request,
            @ModelAttribute Product product,
            BindingResult result,
            Model model
    ){
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<>();
        System.out.println("product: "+product.getImages());
        if(files != null && files.size() > 0){
            for(MultipartFile file : files){
                String fileName = file.getOriginalFilename();
                fileNames.add(fileName);
                //File imageFile = new File(request.getServletContext().getRealPath("/image"),fileName);
                System.out.println("path: "+request.getServletContext().getRealPath("/iamge"));
                String path = "C:\\code\\";
                File destFile = new File(path+fileName);
                try {
                    //file.transferTo(imageFile);
                    file.transferTo(destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("product",product);
        return "FileDetails";
    }

}

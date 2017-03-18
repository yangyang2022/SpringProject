package com.yangyang.controller;

import com.yangyang.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
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

    @PostMapping("/save2")
    public String saveFile2(MultipartHttpServletRequest request,Product product,Model model){
        String path = "C:\\code\\";
        MultiValueMap<String, MultipartFile> mpMap = request.getMultiFileMap();

        mpMap.values().forEach(e->e.forEach(i -> {
            try {
                FileCopyUtils.copy(i.getInputStream(), new FileOutputStream(path + i.getOriginalFilename()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }));

        System.out.println(product);
        model.addAttribute("product",product);
        return "FileDetails";
    }
    @PostMapping("/save")
    public String saveFile(
            HttpServletRequest request,
            @ModelAttribute Product product,
            BindingResult result,
            Model model
    ) throws IOException, ServletException {

        Part images = request.getPart("images");
        images.write("hello-");

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
        }else {
            System.out.println("images is null ... ");
        }

        System.out.println("afterProduct: "+product);
        model.addAttribute("product",product);
        model.addAttribute("hello","yangyang");
        return "FileDetails";
    }

}

package com.yangyang.controller;

import com.yangyang.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ResourcController {

    @RequestMapping("/login")
    public String login(@ModelAttribute("login")Login login, HttpSession session, Model model){
        model.addAttribute("login",new Login());
        if("admin".equals(login.getUsername()) && "123123".equals(login.getPassword())){
            session.setAttribute("loginin",Boolean.TRUE);
            return "/login/Main";
        }
        return "/login/LogInForm";
    }

    @GetMapping("/resource/download")
    public String download(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        if(session == null || session.getAttribute("loginin") == null){
            return "/login/LogInForm";
        }
        String dataDir = request.getServletContext().getRealPath("/WEB-INF/data");
        File file = new File(dataDir,"test.pdf");
        if(file.exists()){
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition","attachment;filename=test.pdf");
            try {
                Files.copy(file.toPath(),response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

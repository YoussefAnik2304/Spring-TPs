package com.Peche.Controller;

import com.Peche.Service.ILieuPecheService;
import com.Peche.bo.LieuPeche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LieuPecheController {
    @Autowired
    private ILieuPecheService service;

    @PostMapping("/AddLocation")
    public String addLocation( LieuPeche lieuPeche,Model model){
        service.add_location(lieuPeche);
        model.addAttribute("test",123);

        return "search";
    }
    @GetMapping("/")
    public String showForm(Model model){
        //model.addAttribute("lieuPeche",new LieuPeche()) ;
        return "AddLocation";
    }
}

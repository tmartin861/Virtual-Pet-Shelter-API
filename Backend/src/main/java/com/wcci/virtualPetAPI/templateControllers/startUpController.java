package com.wcci.virtualPetAPI.templateControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class startUpController {

    @GetMapping
    public String getShelterView(){
        return "shelterView.html";
    }
}

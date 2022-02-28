/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.ipersonaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class personascontroller {
    
  @Autowired
  private ipersonaservice personaservice;
  
  @GetMapping("/personas")
  public String index(Model model){
      List<Persona> listapersonas=personaservice.getAllPerson();
      model.addAttribute("titulo","Personas");
      model.addAttribute("personas", listapersonas);
      return "personas";
      
   }
}
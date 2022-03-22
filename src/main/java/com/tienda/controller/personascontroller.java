/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.PaisService;
import com.tienda.service.PersonaService;
import com.tienda.service.ipersonaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class personascontroller {
    
  @Autowired
  private ipersonaservice personaservice;
  
   @Autowired
   private IPaisService paisService;
  
  @GetMapping("/personas")
  public String index(Model model){
      List<Persona> listapersonas=personaservice.getAllPerson();
      model.addAttribute("titulo","Personas");
      model.addAttribute("personas", listapersonas);
      return "personas";
      
  }   
  
  @GetMapping("/nuevaPersona")
   public String crearPersona(Model model){
   model.addAttribute("persona", new Persona());
   return "crear";
   }
   
   @PostMapping("/guardarPersona")
   public String savePerson(@ModelAttribute Persona persona){
   personaservice.savePerson(persona);
    return "redirect:/persona";
   }
   
      @GetMapping("/modificaPersona/ {id}")
   public String modificaPersona(@PathVariable("id") long id, Model model){
      Persona persona =personaservice.getPersonaById (id);
     List<Pais> listaPais=paisService.listCountry();
      model.addAttribute("persona",persona);
      model.addAttribute("paises", listaPais);
      return "crear";

   
   }
   

   
   @GetMapping("/delete/{id}")
   public String eliminarPersona(@PathVariable("id") Long idPersona){
    personaservice.delete(idPersona);
    return "redirect:/persona";
    
   }
   
 
}
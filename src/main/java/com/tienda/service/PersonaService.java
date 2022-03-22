/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.personarepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PersonaService implements ipersonaservice{
    
      @Autowired
      
      private personarepository personarepository;
      
       @Override
       
    public List<Persona> getAllPerson(){
        return (List<Persona>)personarepository.findAll();
        
    }
    
     @Override
        
        public void savePerson(Persona persona){
            personarepository.save(persona);
            
        }

    @Override
    public Persona getPersonaById(long id) {
        return personarepository.findById(id).orElse(null);
    }
    
  @Override        
  public void delete(long id) {
        personarepository.deleteById(id);
    }
  }
 

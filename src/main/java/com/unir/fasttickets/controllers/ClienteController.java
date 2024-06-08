package com.unir.fasttickets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.fasttickets.repository.ClienteEntity;
import com.unir.fasttickets.services.ClienteService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClienteController {
    @Autowired

    ClienteService clienteService;


    @GetMapping("/all")
    public List<ClienteEntity> getAll() {
        return clienteService.findAll();
    }

    @PostMapping("/save")
    public ClienteEntity save(@Valid @RequestBody ClienteEntity clienteEntity) {
        return clienteService.save(clienteEntity);
    }
    
    @PutMapping("/update/{id}")
    public ClienteEntity update(@RequestBody ClienteEntity personaEntity, @PathVariable(name = "id") int id ) {
        ClienteEntity persona = new ClienteEntity();
        persona = personaEntity;
        persona.setId(id);
        
        return clienteService.save(persona);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        return clienteService.delete(id);
    } 
 

}

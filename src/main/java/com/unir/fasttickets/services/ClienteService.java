package com.unir.fasttickets.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unir.fasttickets.repository.ClienteEntity;
import com.unir.fasttickets.repository.entity.ClienteRepository;
import java.util.List;

@Service

public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteEntity> findAll(){
        return (List<ClienteEntity>) clienteRepository.findAll();
    } 

    public ClienteEntity save (ClienteEntity clienteEntity){
        return clienteRepository.save(clienteEntity);
    }

    public String delete (int id){
        clienteRepository.deleteById(id);
        return "Registro eliminado";
    }


}

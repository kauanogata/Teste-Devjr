package br.com.backendjr.service;

import br.com.backendjr.dto.ClienteDTO;
import br.com.backendjr.entity.CLienteRepository;
import br.com.backendjr.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteFacade {
    @Autowired
    private CLienteRepository repository;

    public ClienteDTO criar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setFirstName(clienteDTO.getFirstName());
        cliente.setLastName(clienteDTO.getLastName());
        cliente.setAge(clienteDTO.getAge());
        cliente.setCountry(clienteDTO.getCountry());
        repository.save(cliente);
        clienteDTO.setId(cliente.getId());
        return  clienteDTO;
    }

    public ClienteDTO atualizar(ClienteDTO clienteDTO, Long clienteId) {
        Cliente clienteDataBase = repository.getOne(clienteId);
        clienteDataBase.setFirstName(clienteDTO.getFirstName());
        clienteDataBase.setLastName(clienteDTO.getLastName());
        clienteDataBase.setAge(clienteDTO.getAge());
        clienteDataBase.setCountry(clienteDTO.getCountry());
        repository.save(clienteDataBase);
        return clienteDTO;
    }



    private ClienteDTO converter(Cliente cliente) {
        ClienteDTO result = new ClienteDTO();
        result.setId(cliente.getId());
        result.setFirstName(cliente.getFirstName());
        result.setLastName(cliente.getLastName());
        result.setAge(cliente.getAge());
        result.setCountry(cliente.getCountry());
        return result;
    }

    public List<ClienteDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public List<ClienteDTO> encontrarId(Long i)

    public String delete(Long clienteId) {
        repository.deleteById(clienteId);
        return "DELETED";
    }
}

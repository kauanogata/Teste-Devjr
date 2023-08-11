package br.com.backendjr.controller;

import br.com.backendjr.dto.ClienteDTO;
import br.com.backendjr.service.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteAPI {
    @Autowired
    private ClienteFacade clienteFacade;

    @PostMapping
    @ResponseBody
    public ClienteDTO criar(@RequestBody ClienteDTO clienteDTO) {
        return clienteFacade.criar(clienteDTO);
    }

    @PutMapping("/{clienteId}")
    @ResponseBody
    public ClienteDTO atualizar(@PathVariable("clienteId") Long clienteId, @RequestBody ClienteDTO clienteDTO) {
        return clienteFacade.atualizar(clienteDTO, clienteId);
    }

    @GetMapping
    @ResponseBody
    public List<ClienteDTO> getAll() {
        return clienteFacade.getAll();
    }

    @DeleteMapping("/{clienteId}")
    @ResponseBody
    public String deletar(@PathVariable("clienteId") Long clieteId) {
        return clienteFacade.delete(clieteId);
    }

}

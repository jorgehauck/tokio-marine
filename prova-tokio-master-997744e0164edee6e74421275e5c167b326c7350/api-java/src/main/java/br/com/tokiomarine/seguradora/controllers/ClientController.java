package br.com.tokiomarine.seguradora.controllers;

import br.com.tokiomarine.seguradora.dto.ClientDTO;
import br.com.tokiomarine.seguradora.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
@Api(value = "Usuários", description = "Operações para gerenciar usuários")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping
    @ApiOperation(value = "Lista todos os usuários")
    public ResponseEntity<Page<ClientDTO>> getClients(Pageable pageable) {
        Page<ClientDTO> pageDto = clientService.getClients(pageable);
        return ResponseEntity.ok(pageDto);
    }
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busca o usuário pelo id")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.findById(id);
        return ResponseEntity.ok(clientDTO);
    }
    @PostMapping
    @ApiOperation(value = "Cria um novo usuário")
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.insert(clientDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(clientDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(clientDTO);
    }
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um usuário pelo id")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.update(id, clientDTO);
        return ResponseEntity.ok(clientDTO);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete o usuário pelo id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

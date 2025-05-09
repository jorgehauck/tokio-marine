package br.com.tokiomarine.seguradora.controllers;

import br.com.tokiomarine.seguradora.dto.AddressDTO;
import br.com.tokiomarine.seguradora.services.AddressService;
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
@RequestMapping(value = "/addresses")
@Api(value = "Endereços", description = "Operações para gerenciar endereços")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping
    @ApiOperation(value = "Lista todos os endereços")
    public ResponseEntity<Page<AddressDTO>> getAddress(Pageable pageable) {
        Page<AddressDTO> addressDto = addressService.getAddresses(pageable);
        return ResponseEntity.ok(addressDto);
    }
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busca pelo endereço pelo id")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        AddressDTO addressDto = addressService.findById(id);
        return ResponseEntity.ok(addressDto);
    }
    @PostMapping
    @ApiOperation(value = "Cria um novo endereço")
    public ResponseEntity<AddressDTO> insert(@Valid @RequestBody AddressDTO addressDTO) {
        addressDTO = addressService.insert(addressDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(addressDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(addressDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza o endereço pelo id")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @Valid @RequestBody AddressDTO addressDTO) {
        addressDTO = addressService.update(id, addressDTO);
        return ResponseEntity.ok(addressDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete o endereço pelo id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

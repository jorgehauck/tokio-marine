package br.com.tokiomarine.seguradora.controllers;

import br.com.tokiomarine.seguradora.dto.ApiResponseDTO;
import br.com.tokiomarine.seguradora.services.ApiResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zip-code")
@Api(value = "Serviço de CEP", description = "Busca informações do endereço a partir do CEP pela API Brasil Aberto.")
public class ApiResponseController {
    @Autowired
    private ApiResponseService apiResponseService;
    @GetMapping("/{cep}")
    @ApiOperation(value = "Busca informações do endereço a partir de um CEP informado")
    public ResponseEntity<ApiResponseDTO> getAddress(@PathVariable String cep) {
        ApiResponseDTO response = apiResponseService.getDataAddresses(cep);
        return ResponseEntity.ok(response);
    }
}

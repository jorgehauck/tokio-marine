package br.com.tokiomarine.seguradora.services;

import br.com.tokiomarine.seguradora.dto.ApiResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class ApiResponseService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.key}")
    private String apiKey;

    public ApiResponseDTO getDataAddresses(String zipCode) {
        String url = apiUrl + "/" + zipCode;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ApiResponseDTO> entity = new HttpEntity<>(headers);

        ResponseEntity<ApiResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, ApiResponseDTO.class);

        return response.getBody();
    }
}

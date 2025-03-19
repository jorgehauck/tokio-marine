package br.com.tokiomarine.seguradora.services;

import br.com.tokiomarine.seguradora.dto.AddressDTO;
import br.com.tokiomarine.seguradora.dto.ClientDTO;
import br.com.tokiomarine.seguradora.entities.Address;
import br.com.tokiomarine.seguradora.entities.Client;
import br.com.tokiomarine.seguradora.repositories.ClientRepository;
import br.com.tokiomarine.seguradora.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Transactional(readOnly = true)
    public Page<ClientDTO> getClients(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(x -> new ClientDTO(x));
    }
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }
    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        copyDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }
    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Optional<Client> client = clientRepository.findById(id);

        if (!client.isPresent()) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        copyDtoToEntity(clientDTO, client.get());
        clientRepository.save(client.get());
        return new ClientDTO(client.get());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não econtrado!");
        }
        clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());

        client.getAddresses().clear();
        for (AddressDTO addressDTO : clientDTO.getAddresses()) {
            Address address = new Address();
            address.setId(addressDTO.getId());
            client.getAddresses().add(address);
        }
    }
}

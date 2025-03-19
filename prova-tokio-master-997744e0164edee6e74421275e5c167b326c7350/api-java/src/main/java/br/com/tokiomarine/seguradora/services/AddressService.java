package br.com.tokiomarine.seguradora.services;

import br.com.tokiomarine.seguradora.dto.AddressDTO;
import br.com.tokiomarine.seguradora.dto.ClientDTO;
import br.com.tokiomarine.seguradora.entities.Address;
import br.com.tokiomarine.seguradora.entities.Client;
import br.com.tokiomarine.seguradora.repositories.AddressRepository;
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
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Transactional(readOnly = true)
    public Page<AddressDTO> getAddresses(Pageable pageable) {
        Page<Address> addresses = addressRepository.findAll(pageable);
        return addresses.map(x -> new AddressDTO(x));
    }
    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new AddressDTO(address);
    }
    @Transactional
    public AddressDTO insert(AddressDTO addressDTO) {
        Address address = new Address();
        copyDtoToEntity(addressDTO, address);
        address = addressRepository.save(address);
        return new AddressDTO(address);
    }
    @Transactional
    public AddressDTO update(Long id, AddressDTO addressDTO) {
        Optional<Address> address = addressRepository.findById(id);

        if (!address.isPresent()) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        copyDtoToEntity(addressDTO, address.get());
        addressRepository.save(address.get());
        return new AddressDTO(address.get());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        addressRepository.deleteById(id);
    }
    private void copyDtoToEntity(AddressDTO addressDTO, Address entity) {
        entity.setAddress(addressDTO.getAddress());
        entity.setNumber(addressDTO.getNumber());
        entity.setComplement(addressDTO.getComplement());
        entity.setPostalCode(addressDTO.getPostalCode());
        entity.setCity(addressDTO.getCity());
        entity.setState(addressDTO.getState());
        entity.setCountry(addressDTO.getCountry());

        if (addressDTO.getClientId() != null) {
            Client client = clientRepository.findById(addressDTO.getClientId())
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
            entity.setClient(client);
        }
    }
}

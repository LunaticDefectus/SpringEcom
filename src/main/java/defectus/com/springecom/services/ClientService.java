package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Client;

import defectus.com.springecom.dao.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements  ClientManager{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client Save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }
}

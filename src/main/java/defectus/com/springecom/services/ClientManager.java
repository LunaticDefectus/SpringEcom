package defectus.com.springecom.services;


import defectus.com.springecom.dao.entities.Cart;
import defectus.com.springecom.dao.entities.Client;
import defectus.com.springecom.dao.entities.Product;

import java.util.List;

public interface ClientManager {
    public Client Save(Client client);
    public List<Client> getAllClients();
    public Client getClientById(Integer id);
    public void deleteClientById(Integer id);
}

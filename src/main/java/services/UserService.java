package services;

import dto.AdminRecord;
import dto.ClientRecord;
import dto.OrderRecord;
import entities.Client;
import entities.Order;

public interface UserService {

    ClientRecord register(ClientRecord record);

    ClientRecord clientToClientRecord(Client client);

    void saveClient(ClientRecord clientRecord);

    AdminRecord getAdminRecord (Long id);

    ClientRecord getClientRecord (Long id);

    AdminRecord getAdminRecord (String login, String password);

    ClientRecord getClientRecord (String login, String password);

}

package services.implementations;

import dao.services.AdminRepository;
import dao.services.ClientRepository;
import dto.AdminRecord;
import dto.ClientRecord;
import entities.Client;
import services.UserService;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    @Inject
    private ClientRepository clientRepository;

    @Inject
    private AdminRepository adminRepository;

    @Override
    public ClientRecord register(ClientRecord record) {
        saveClient(record);
        return record;
    }

    @Override
    public ClientRecord clientToClientRecord(Client client) {
        return new ClientRecord(client);
    }

    @Override
    public void saveClient(ClientRecord clientRecord) {
        clientRepository.save(new Client(clientRecord));
    }

    @Override
    public AdminRecord getAdminRecord(Long id) {
        return new AdminRecord(adminRepository.findById(id));
    }

    @Override
    public AdminRecord getAdminRecord(String login, String password) {
        return new AdminRecord(adminRepository.findByLoginAndPassword(login, password));
    }

    @Override
    public ClientRecord getClientRecord(Long id) {
        return new ClientRecord(clientRepository.findById(id));
    }

    @Override
    public ClientRecord getClientRecord(String login, String password) {
        return new ClientRecord(clientRepository.findByLoginAndPassword(login, password));
    }
}

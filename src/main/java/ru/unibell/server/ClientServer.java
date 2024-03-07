package ru.unibell.server;

import ru.unibell.dto.ClientContactDto;
import ru.unibell.dto.ClientDto;
import ru.unibell.dto.ClientFullDto;
import ru.unibell.model.Type;

import java.util.List;

public interface ClientServer {
    ClientFullDto saveClient(ClientDto clientDto);

    ClientFullDto patchClient(String phone, String email, long clientId);

    List<ClientFullDto> findClients();

    ClientFullDto findClient(long clientId);

    ClientContactDto findClientByContactType(long clientId, Type type);
}

package ru.unibell.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unibell.dto.*;
import ru.unibell.mapper.ClientMapper;
import ru.unibell.mapper.EmailAddressMapper;
import ru.unibell.mapper.PhoneMapper;
import ru.unibell.model.Client;
import ru.unibell.model.EmailAddress;
import ru.unibell.model.Phone;
import ru.unibell.model.Type;
import ru.unibell.repository.ClientRepository;
import ru.unibell.repository.EmailAddressesRepository;
import ru.unibell.repository.PhoneRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServerImpl implements ClientServer {
    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;
    private final EmailAddressesRepository emailRepository;

    @Override
    public ClientFullDto saveClient(ClientDto clientDto) {
        Client client = clientRepository.save(new Client());
        ClientFullDto clientFullDto = ClientFullDto.builder()
                .client(ClientMapper.toClientShortDto(client))
                .build();
        if (clientDto.getPhone() != null) {
            Phone phone = preparePhone(clientDto.getPhone(), client);
            phone = phoneRepository.save(phone);
            clientFullDto.setPhones(List.of(PhoneMapper.toPhoneDto(phone)));
        }
        if (clientDto.getEmail() != null) {
            EmailAddress email = prepareEmail(clientDto.getEmail(), client);
            email = emailRepository.save(email);
            clientFullDto.setEmails(List.of(EmailAddressMapper.toEmailAddressDto(email)));
        }
        return clientFullDto;
    }

    @Override
    public ClientFullDto patchClient(String phoneString, String emailString, long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            ClientFullDto clientFullDto = ClientFullDto.builder()
                    .client(ClientMapper.toClientShortDto(client))
                    .build();
            if (!phoneString.equals("0")) {
                Phone phone = preparePhone(phoneString, client);
                phoneRepository.save(phone);
            }
            if (!emailString.equals("0")) {
                EmailAddress email = prepareEmail(emailString, client);
                emailRepository.save(email);
            }
            List<PhoneDto> phoneDtos = phoneRepository.findAllByClientId(clientId).stream()
                    .map(PhoneMapper::toPhoneDto)
                    .collect(Collectors.toList());
            List<EmailAddressDto> emailDtos = emailRepository.findAllByClientId(clientId).stream()
                    .map(EmailAddressMapper::toEmailAddressDto)
                    .collect(Collectors.toList());
            clientFullDto.setPhones(phoneDtos);
            clientFullDto.setEmails(emailDtos);
            return clientFullDto;
        } else {
            throw new RuntimeException("Клиент с id = " + clientId + " нe найден в базе данных.");
        }
    }

    @Override
    public List<ClientFullDto> findClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientMapper::toClientFullDto).collect(Collectors.toList());
    }

    @Override
    public ClientFullDto findClient(long clientId) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return ClientMapper.toClientFullDto(client);
        } else {
            throw new RuntimeException("Клиент с id = " + clientId + " нe найден в базе данных.");
        }

    }

    @Override
    public ClientContactDto findClientByContactType(long clientId, Type type) {
        if (type.equals(Type.EMAIL)) {
            List<EmailAddress> emails = emailRepository.findAllByClientId(clientId);
            List<String> emailsString = emails.stream().map(EmailAddress::getEmail).collect(Collectors.toList());
            return ClientEmailDto.builder()
                    .id(clientId)
                    .emails(emailsString)
                    .build();
        } else if (type.equals(Type.PHONE)) {
            List<Phone> phones = phoneRepository.findAllByClientId(clientId);
            List<String> phonesString = phones.stream().map(Phone::getPhone).collect(Collectors.toList());
            return ClientPhoneDto.builder()
                    .id(clientId)
                    .phones(phonesString)
                    .build();
        } else {
            throw new RuntimeException("Неверно задан тип контактов для выгрузки");
        }
    }

    private EmailAddress prepareEmail(String emailString, Client client) {
        EmailAddress email = new EmailAddress();
        email.setEmail(emailString);
        email.setClient(client);
        return email;
    }

    private Phone preparePhone(String phoneString, Client client) {
        Phone phone = new Phone();
        phone.setPhone(phoneString);
        phone.setClient(client);
        return phone;
    }
}
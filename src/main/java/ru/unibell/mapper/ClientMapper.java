package ru.unibell.mapper;

import lombok.experimental.UtilityClass;
import ru.unibell.dto.ClientFullDto;
import ru.unibell.dto.ClientShortDto;
import ru.unibell.model.Client;
import ru.unibell.model.EmailAddress;
import ru.unibell.model.Phone;

import java.util.List;

@UtilityClass
public class ClientMapper {

    public static ClientShortDto toClientShortDto(Client client) {
        return ClientShortDto.builder()
                .id(client.getId())
                .build();
    }

    public static ClientFullDto toClientFullDto(Client client) {
        List<Phone> phones = client.getPhones();
        List<EmailAddress> emails = client.getEmails();
        return ClientFullDto.builder()
                .client(toClientShortDto(client))
                .phones(PhoneMapper.toPhonesDto(phones))
                .emails(EmailAddressMapper.toEmailAddressesDto(emails))
                .build();
    }
}
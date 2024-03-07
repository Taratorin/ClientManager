package ru.unibell.mapper;

import lombok.experimental.UtilityClass;
import ru.unibell.dto.EmailAddressDto;
import ru.unibell.model.EmailAddress;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class EmailAddressMapper {
    public static EmailAddressDto toEmailAddressDto(EmailAddress emailAddress) {
        return EmailAddressDto.builder()
                .id(emailAddress.getId())
                .email(emailAddress.getEmail())
                .build();

    }

    public static List<EmailAddressDto> toEmailAddressesDto(List<EmailAddress> emailAddresses) {
        List<EmailAddressDto> list = new ArrayList<>();
        for (EmailAddress emailAddress : emailAddresses) {
            EmailAddressDto emailAddressDto = EmailAddressDto.builder()
                    .id(emailAddress.getId())
                    .email(emailAddress.getEmail())
                    .build();
            list.add(emailAddressDto);
        }
        return list;
    }
}

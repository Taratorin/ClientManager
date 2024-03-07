package ru.unibell.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientFullDto {
    private ClientShortDto client;
    private List<PhoneDto> phones;
    private List<EmailAddressDto> emails;
}

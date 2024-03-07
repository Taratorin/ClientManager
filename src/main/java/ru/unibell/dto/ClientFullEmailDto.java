package ru.unibell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClientFullEmailDto extends ClientFullDto {
    private ClientShortDto client;
    private List<EmailAddressDto> emails;
}

package ru.unibell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClientFullPhoneDto extends ClientFullDto {
    private ClientShortDto client;
    private List<PhoneDto> phones;
}

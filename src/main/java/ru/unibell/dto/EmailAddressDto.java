package ru.unibell.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailAddressDto {
    private Long id;
    private String email;
}

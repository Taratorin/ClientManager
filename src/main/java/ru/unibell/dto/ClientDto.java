package ru.unibell.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
public class ClientDto {
    private long id;
    @Length(min = 5, max = 15)
    private String phone;
    @Email
    @Length(min = 6, max = 254)
    private String email;
}

package ru.unibell.mapper;

import lombok.experimental.UtilityClass;
import ru.unibell.dto.PhoneDto;
import ru.unibell.model.Phone;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PhoneMapper {

    public static PhoneDto toPhoneDto(Phone phone) {
        return PhoneDto.builder()
                .id(phone.getId())
                .phone(phone.getPhone())
                .build();
    }

    public static List<PhoneDto> toPhonesDto(List<Phone> phones) {
        List<PhoneDto> list = new ArrayList<>();
        for (Phone phone : phones) {
            PhoneDto phoneDto = PhoneDto.builder()
                    .id(phone.getId())
                    .phone(phone.getPhone())
                    .build();
            list.add(phoneDto);
        }
        return list;
    }

}

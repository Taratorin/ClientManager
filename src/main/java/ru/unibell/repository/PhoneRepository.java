package ru.unibell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unibell.model.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findAllByClientId(long clientId);
}

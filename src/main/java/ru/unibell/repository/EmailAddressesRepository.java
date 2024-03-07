package ru.unibell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unibell.model.EmailAddress;

import java.util.List;

public interface EmailAddressesRepository extends JpaRepository<EmailAddress, Long> {

    List<EmailAddress> findAllByClientId(long clientId);

}

package ru.unibell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unibell.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

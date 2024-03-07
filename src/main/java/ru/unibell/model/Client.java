package ru.unibell.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "clients", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Phone> phones;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<EmailAddress> emails;
}

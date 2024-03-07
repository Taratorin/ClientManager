package ru.unibell.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "emails", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class EmailAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
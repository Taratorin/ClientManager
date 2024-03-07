DROP TABLE IF EXISTS emails, phones, clients;

CREATE TABLE IF NOT EXISTS clients (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  CONSTRAINT pk_clients PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS phones (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  client_id BIGINT NOT NULL REFERENCES clients(id),
  phone VARCHAR(15) NOT NULL UNIQUE,
  CONSTRAINT pk_phones PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS emails (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  client_id BIGINT NOT NULL REFERENCES clients(id),
  email VARCHAR(254) NOT NULL UNIQUE,
  CONSTRAINT pk_emails PRIMARY KEY (id)
);
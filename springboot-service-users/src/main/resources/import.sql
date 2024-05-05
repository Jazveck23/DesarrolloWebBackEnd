insert into users (username, password, enabled, nombre, apellido, email) values ('gustavoo', '$2a$10$NsEu/V62/snrc9UppLP4SOEzzjEwo0elHQ0XvAlXoz3n8yaG31um2', 1, 'Gustavo', 'Rodriguez', 'gustavo@uanl.com');
insert into users (username, password, enabled, nombre, apellido, email) values ('nissan', '$2a$10$koBCixEX0P4Wf.oau/9XbehazVAXqhwnxLWDly/nUee4rImdPv85.', 1, 'Nissan', 'Gtr', 'nissan@uanl.com');

insert into roles (nombre) values ('ROLE_USER');
insert into roles (nombre) values ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) values (1,1);
INSERT INTO usuarios_to_roles (user_id, rooles_id) values (2,2);
INSERT INTO usuarios_to_roles (user_id, rooles_id) values (2,1);

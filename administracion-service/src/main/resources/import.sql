INSERT INTO users (enabled, password, username) VALUES (1, '$2a$10$G7qLnrOi5uQtzoQvNaBTAOq5b2GrImyAWEDN2iMDv4cp0ZAuKoHYC', 'admin');
INSERT INTO users (enabled, password, username) VALUES (1, '$2a$10$e8hSR..DYKE/8o1hIuxFRuLBUAj8/gqrzpahF8azajZIV5AAqI9C2', 'sec');
INSERT INTO users (enabled, password, username) VALUES (1, '$2a$10$e8hSR..DYKE/8o1hIuxFRuLBUAj8/gqrzpahF8azajZIV5AAqI9C2', 'age');
INSERT INTO users (enabled, password, username) VALUES (1, '$2a$10$e8hSR..DYKE/8o1hIuxFRuLBUAj8/gqrzpahF8azajZIV5AAqI9C2', 'cliente');

INSERT INTO authorities (authority, user_id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO authorities (authority, user_id) VALUES ('ROLE_SECRETARIA', 2);
INSERT INTO authorities (authority, user_id) VALUES ('ROLE_AGENTE', 3);
INSERT INTO authorities (authority, user_id) VALUES ('ROLE_USER', 4);
INSERT INTO USUARIO(nome, email, perfil, senha) VALUES('Admin', 'admin@email.com', 'ADMIN', '$2a$12$XbfMZaznPJ6GIdLhthHEZuT4nmjEne0lkJAsoGnbyT2R3xV0nJa/m');
INSERT INTO USUARIO(nome, email, perfil, senha) VALUES('Triador', 'triador@email.com', 'USUARIO_TRIADOR', '$2a$12$XbfMZaznPJ6GIdLhthHEZuT4nmjEne0lkJAsoGnbyT2R3xV0nJa/m');
INSERT INTO USUARIO(nome, email, perfil, senha) VALUES('Finalizador 1', 'final1@email.com', 'USUARIO_FINALIZADOR', '$2a$12$XbfMZaznPJ6GIdLhthHEZuT4nmjEne0lkJAsoGnbyT2R3xV0nJa/m');
INSERT INTO USUARIO(nome, email, perfil, senha) VALUES('Finalizador 2', 'final2@email.com', 'USUARIO_FINALIZADOR', '$2a$12$XbfMZaznPJ6GIdLhthHEZuT4nmjEne0lkJAsoGnbyT2R3xV0nJa/m');
INSERT INTO USUARIO(nome, email, perfil, senha) VALUES('Finalizador 3', 'final3@email.com', 'USUARIO_FINALIZADOR', '$2a$12$XbfMZaznPJ6GIdLhthHEZuT4nmjEne0lkJAsoGnbyT2R3xV0nJa/m');
INSERT INTO PROCESSO(titulo, ds_parecer) VALUES('Processo 1', 'Parecer 1');
INSERT INTO PROCESSO(titulo, ds_parecer) VALUES('Processo 2', 'Parecer 2');
INSERT INTO PROCESSO(titulo) VALUES('Processo 3');
INSERT INTO PROCESSO(titulo, ds_parecer) VALUES('Processo 4', 'Parecer 4');
INSERT INTO PROCESSO(titulo) VALUES('Processo 5');
INSERT INTO USUARIO_PROCESSO(processo_id, usuario_id) VALUES(1,3);
INSERT INTO USUARIO_PROCESSO(processo_id, usuario_id) VALUES(2,3);
INSERT INTO USUARIO_PROCESSO(processo_id, usuario_id) VALUES(4,4);
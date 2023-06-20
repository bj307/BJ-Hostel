/***** INSERE USUÁRIO ADM *****/
INSERT INTO `tb_funcionarios`(`nome`, `rg`, `cpf`, `email`, `senha`, `cargo`, `celular`, `cep`, `endereco`, `complemento`, `cidade`, `estado`) VALUES ('Usuário ADM',1234567,'700.600.500-40','adm@email.com','senha','ADM','(64) 9 9275-2317','75.790-000','Rua do IF','IF Goiano','Urutaí','GO')

/***** ADICIONA SERVIÇOS DISPONIVEIS *****/
INSERT INTO tb_servicosdisponivel (nome, preco) VALUES 
('Limpeza','90'),
('Troca de itens', '50'),
('Entrega', '30'),
('Bebida', '20'),
('Massagem', '120'),
('Lavanderia', '70'),
('Aluguel de bicicletas', '40'),
('Serviço de quarto 24 horas', '80'),
('Organização de eventos', '150'),
('Café da manhã', '25'),
('Vaga de estacionamento extra', '85'),
('Academia', '50'),
('Aluguel de carros', '80'),
('Traslado para o aeroporto', '60'),
('Sala de reuniões', '70'),
('Serviço de lavagem a seco', '30'),
('Spa', '100');

/***** ADICIONA QUARTOS DISPONIVEIS *****/
INSERT INTO `tb_quartos` (`tipo_quarto`, `num_camas`, `descricao`, `preco`, `tamanho`, `status`) VALUES
('Quarto Simples', 1, 'Bloco C', 150.90, 2, 'desocupado'),
('Quarto Simples', 1, 'Bloco C', 150.90, 2, 'desocupado'),
('Quarto Simples', 1, 'Bloco C', 150.90, 2, 'desocupado'),
('Quarto Simples', 1, 'Bloco C', 150.90, 2, 'desocupado'),
('Quarto Simples', 1, 'Bloco C', 150.90, 2, 'desocupado'),
('Quarto Duplo', 2, 'Bloco B', 210.90, 4, 'desocupado'),
('Quarto Duplo', 2, 'Bloco B', 210.90, 4, 'desocupado'),
('Quarto Duplo', 2, 'Bloco B', 210.90, 4, 'desocupado'),
('Quarto Duplo', 2, 'Bloco B', 210.90, 4, 'desocupado'),
('Quarto Duplo', 2, 'Bloco B', 210.90, 4, 'desocupado'),
('Suíte Especial ', 4, 'Bloco A', 290.90, 8, 'desocupado'),
('Suíte Especial ', 4, 'Bloco A', 290.90, 8, 'desocupado'),
('Suíte Especial ', 4, 'Bloco A', 290.90, 8, 'desocupado'),
('Suíte Especial ', 4, 'Bloco A', 290.90, 8, 'desocupado'),
('Suíte Especial ', 4, 'Bloco A', 290.90, 8, 'desocupado');

/***** ADICIONA CLIENTES *****/
INSERT INTO tb_clientes (nome, dataNasc, rg, cpf, email, celular, cep, endereco, complemento, cidade, estado)
VALUES
('Augusto Nascimento', '22/07/1991', '1234567', '700.600.500-40', 'augusto@email.com', '(64) 9 9999-9999', '75.790-000', 'Rua 5', 'Quadra 10', 'São Paulo', 'SP'),
('Carolina Fernandes', '05/12/1987', '9876543', '111.222.333-44', 'carolina@email.com', '(21) 9 8765-4321', '22.000-001', 'Avenida Central', 'Apartamento 201', 'Rio de Janeiro', 'RJ'),
('Lucas Silva', '15/03/1995', '5678912', '555.666.777-88', 'lucas.silva@email.com', '(31) 9 1234-5678', '32.100-200', 'Rua das Flores', 'Casa 10', 'Belo Horizonte', 'MG'),
('Isabela Oliveira', '10/09/1990', '3456789', '999.888.777-66', 'isabela.oliveira@email.com', '(51) 9 2468-1357', '90.000-012', 'Travessa das Palmeiras', 'Apartamento 502', 'Porto Alegre', 'RS'),
('Rafael Santos', '25/06/1988', '2345678', '222.333.444-55', 'rafael.santos@email.com', '(11) 9 1357-2468', '11.000-789', 'Avenida Principal', 'Casa 15', 'São Paulo', 'SP'),
('Fernanda Costa', '12/04/1992', '8765432', '777.888.999-00', 'fernanda.costa@email.com', '(41) 9 1234-5678', '80.000-123', 'Rua dos Sonhos', 'Casa 20', 'Curitiba', 'PR'),
('André Almeida', '07/09/1985', '2345678', '111.222.333-44', 'andre.almeida@email.com', '(85) 9 8765-4321', '60.000-456', 'Avenida das Palmeiras', 'Apartamento 101', 'Fortaleza', 'CE'),
('Mariana Sousa', '23/08/1993', '3456789', '555.666.777-88', 'mariana.sousa@email.com', '(21) 9 1357-2468', '22.000-789', 'Rua das Flores', 'Bloco B', 'Rio de Janeiro', 'RJ'),
('Ricardo Lima', '18/02/1997', '6543210', '999.888.777-66', 'ricardo.lima@email.com', '(31) 9 2468-1357', '30.000-987', 'Avenida Central', 'Apartamento 502', 'Belo Horizonte', 'MG'),
('Juliana Pereira', '09/11/1990', '9876543', '222.333.444-55', 'juliana.pereira@email.com', '(11) 9 9876-5432', '11.000-654', 'Travessa das Palmeiras', 'Casa 15', 'São Paulo', 'SP');




CREATE DATABASE BDHOSTEL;

GRANT ALL ON *.* TO 'kaio'@'%' WITH GRANT OPTION;
flush privileges;


USE BDHOSTEL;

/***** TABELA CLIENTES *****/
CREATE TABLE tb_clientes (
  id int auto_increment primary key,
  nome varchar(100),
  dataNasc varchar(30),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  celular varchar(30),
  cep varchar(100),
  endereco varchar(255),
  complemento varchar(200),
  cidade varchar(100),
  estado varchar(50)
);

/***** TABELA FUNCIONARIOS *****/
CREATE TABLE tb_funcionarios (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar(30),
  cpf varchar(20),
  email varchar(200),
  senha varchar(10),
  cargo varchar(100),
  celular varchar(30),
  cep varchar(100),
  endereco varchar(255),
  complemento varchar(200),
  cidade varchar(100),
  estado varchar(2)
);

/***** TABELA QUARTOS *****/
CREATE TABLE tb_quartos (
  id int auto_increment primary key,
  tipo_quarto varchar(100),
  num_camas int,
  descricao varchar(100),
  preco decimal(10,2),
  tamanho decimal(10,2)
);


/***** TABELA HOSPEDAGENS *****/
CREATE TABLE tb_hospedagens (
  id int auto_increment primary key,
  id_cliente int,
  quarto_id int,
  data_checkin datetime,
  data_checkout datetime,
  num_hospedes int,
  placa_veiculo varchar(10),
  total decimal(10,2),

  FOREIGN KEY (quarto_id) REFERENCES tb_quartos(id),
  FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id)
);

/***** TABELA SERVICOS DISPONIVEIS *****/
CREATE TABLE tb_servicosDisponivel (
  id int auto_increment primary key,
  nome varchar(15),
  preco decimal(10,2)
);

/***** TABELA SERVICOS *****/
CREATE TABLE tb_servicos (
  id int auto_increment primary key,
  servicoDisponivelId int,
  data varchar(15),
  quantidade int,
  preco decimal(10,2),
  status varchar(10),
  
  FOREIGN KEY (servicoDisponivelId) REFERENCES tb_servicosDisponivel(id)
);

/***** TABELA HOSPEDAGEM & SERVIÇOS *****/
CREATE TABLE hospedagem_servico (
  id int auto_increment primary key,
  servico_id int,
  hospedagem_id int,
  data_servico datetime,
  qtd int,
  status varchar(15),
  
  FOREIGN KEY (servico_id) REFERENCES tb_servicos(id),
  FOREIGN KEY (hospedagem_id) REFERENCES tb_hospedagens(id)
);

/***** TABELA EVENTOS *****/
CREATE TABLE tb_eventos (
  id int auto_increment primary key,
  nome_evento varchar(100),
  data_evento varchar(10),
  local_evento varchar(50),
  capacidade_evento int
);

/***** TABELA HOSPEDAGEM & EVENTO *****/
CREATE TABLE hospedagem_evento (
  hospedagem_id int,
  evento_id int,
  num_pessoas int,
  
  FOREIGN KEY (hospedagem_id) REFERENCES tb_hospedagens(id),
  FOREIGN KEY (evento_id) REFERENCES tb_eventos(id)
);

/***** TABELA FATURA *****/
CREATE TABLE fatura (
    id int auto_increment primary key,
    cliente_id int,
    hospedagem_id int,
    total decimal(10,2),
    FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id),
    FOREIGN KEY (hospedagem_id) REFERENCES tb_hospedagens(id)
);
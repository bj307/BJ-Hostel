

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
  endereco varchar (255),
  complemento varchar (200),
  cidade varchar (100),
  estado varchar (50)
);

/***** TABELA FUNCIONARIOS *****/
CREATE TABLE tb_funcionarios (
  id int auto_increment primary key,
  nome varchar(100),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  senha varchar(10),
  cargo varchar(100),
  nivel_acesso varchar(50),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  complemento varchar (200),
  cidade varchar (100),
  estado varchar (2)
);

/***** TABELA QUARTOS *****/
CREATE TABLE tb_quartos (
  id int auto_increment primary key,
  tipo_quarto varchar(100),
  num_camas int,
  descricao varchar(100),
  preco decimal (10,2),
  tamanho decimal (10,2)
);

/***** TABELA RESERVAS *****/
CREATE TABLE tb_reservas (
  id int auto_increment primary key,
  cliente_id int,
  quarto_id int,
  data_entrada datetime,
  data_saida datetime,
  num_hospedes int,
  valor_reserva decimal (10,2),
  observacoes text,

  FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id),
  FOREIGN KEY (quarto_id) REFERENCES tb_quartos(id)
);

/***** TABELA HOSPEDES *****/
CREATE TABLE tb_hospedes (
  id int auto_increment primary key,
  nome varchar(15)
);

/***** TABELA HOSPEDAGENS *****/
CREATE TABLE tb_hospedagens (
  id int auto_increment primary key,
  quarto_id int,
  reserva_id int,
  data_checkin datetime,
  data_checkout datetime,
  hospedes_id int,
  placa_veiculo varchar(10),
  total decimal (10,2),

  FOREIGN KEY (reserva_id) REFERENCES tb_reservas(id),
  FOREIGN KEY (quarto_id) REFERENCES tb_quartos(id),
  FOREIGN KEY (hospedes_id) REFERENCES tb_hospedes(id)
);

/***** TABELA SERVICOS *****/
CREATE TABLE tb_servicos (
  id int auto_increment primary key,
  nome_servico varchar(15),
  preco_servico decimal(10,2)
);

/***** TABELA HOSPEDAGEM & SERVIÇOS *****/
CREATE TABLE hospedagem_servico (
  servico_id int,
  hospedagem_id int,
  data_solicitacao datetime,
  data_servico datetime,
  qtd int,
  
  FOREIGN KEY (servico_id) REFERENCES tb_servicos(id),
  FOREIGN KEY (hospedagem_id) REFERENCES tb_hospedagens(id)
);

/***** TABELA EVENTOS *****/
CREATE TABLE tb_eventos (
  id int auto_increment primary key,
  nome_evento varchar(100),
  data_evento datetime,
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
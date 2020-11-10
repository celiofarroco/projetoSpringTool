insert into endereco(id_endereco, cidade, rua, numero, complemento) values 
(1, 'Rio de Janeiro', 'rua vermelha', 100, 'apt. 101'),
(2, 'São Paulo', 'rua azul', 200, null),
(3, 'Minas Gerais', 'rua verde', 300, 'apt. 102'),
(4, 'Bahia', 'rua amarela', 400, null),
(5, 'Maranhão', 'rua preta', 500, 'apt. 103');

insert into funcionario (id_funcionario, cpf, nome_funcionario) values
(1, '111111111-11', 'Ercules M'),
(2, '222222222-22', 'Renato V'),
(3, '333333333-33', 'Igor B'),
(4, '444444444-44', 'Celio P'),
(5, '555555555-55', 'Luiz H');

insert into cliente (id_cliente, cpf, data_nascimento, email, nome_completo, nome_usuario, telefone, id_endereco) values 
(1, '111111111-11', parsedatetime('1991/01/01', 'yyyy/MM/dd'), 'naruto@serratec.com', 'Naruto U', 'narutoU', '21111111111', 1),
(2, '222222222-22', parsedatetime('1992/02/02', 'yyyy/MM/dd'), 'sasuke@serratec.com', 'Sasuke U', 'sasukeU', '11222222222', 2),
(3, '333333333-33', parsedatetime('1993/03/03', 'yyyy/MM/dd'), 'hinata@serratec.com', 'Hinata H', 'hinataH', '31333333333', 3),
(4, '444444444-44', parsedatetime('1994/04/04', 'yyyy/MM/dd'), 'sakura@serratec.com', 'Sakura H', 'sakuraH', '71444444444', 4),
(5, '555555555-55', parsedatetime('1995/05/05', 'yyyy/MM/dd'), 'rock@serratec.com', 'Rock L', 'rockL', '98555555555', 5);

insert into categoria (id_categoria, nome_categoria, descricao, id_funcionario) values 
(1, 'Eletrônicos', 'Produtos eletrônicos', 1),
(2, 'Brinquedos', 'Todos os brinquedos para o seu filho', 2),
(3, 'Vestimentas', 'Tudo da moda para você', 3),
(4, 'Esportivos', 'Para quem curte esportes', 4),
(5, 'Móveis', 'Móveis para decorrar sua casa', 5);

insert into pedido (id_pedido, data_pedido, id_cliente) values 
(1, parsedatetime('2020/01/01', 'yyyy/MM/dd'), 1),
(2, parsedatetime('2020/01/01', 'yyyy/MM/dd'), 1),
(3, parsedatetime('2020/01/01', 'yyyy/MM/dd'), 1),
(4, parsedatetime('2020/02/02', 'yyyy/MM/dd'), 2),
(5, parsedatetime('2020/02/02', 'yyyy/MM/dd'), 2),
(6, parsedatetime('2020/03/03', 'yyyy/MM/dd'), 3),
(7, parsedatetime('2020/04/04', 'yyyy/MM/dd'), 4),
(8, parsedatetime('2020/04/04', 'yyyy/MM/dd'), 4),
(9, parsedatetime('2020/04/04', 'yyyy/MM/dd'), 4),
(10, parsedatetime('2020/05/05', 'yyyy/MM/dd'), 5);

insert into produto (id_produto, nome_produto, preco, data_fabricacao, descricao, id_categoria, estoque) values 
(1, 'Iphone 10', 5000.10, parsedatetime('2019/01/01', 'yyyy/MM/dd'), 'Novo iphone sem botões', 1, 10),
(2, 'Samsung S20', 3000.90, parsedatetime('2019/02/02', 'yyyy/MM/dd'), 'Novo Samsung, mais poderoso como nunca', 1, 20),
(3, 'Casa de bonecas', 399.99, parsedatetime('2019/03/03', 'yyyy/MM/dd'), 'Casa de bonecas da Poly', 2, 50),
(4, 'Max Steel', 50.99, parsedatetime('2019/04/04', 'yyyy/MM/dd'), 'Max Steel com muitas funções', 2, 63),
(5, 'Camisa do Flamengo 2019', 249.99, parsedatetime('2019/05/05', 'yyyy/MM/dd'), 'Camisa do Flamengo campeão da Libertadores', 3, 25),
(6, 'Calça Gucci', 4999.9, parsedatetime('2019/06/06', 'yyyy/MM/dd'), 'Nova calça jeans da Gucci', 3, 5),
(7, 'Bola de basquete', 15.50, parsedatetime('2019/07/07', 'yyyy/MM/dd'), 'Bola de basquete perfeita para o fazer a cesta', 4, 100),
(8, 'Bola de futebol', 150.60, parsedatetime('2019/08/08', 'yyyy/MM/dd'), 'Bola Nike final da Champions 2019', 4, 32),
(9, 'Sofá', 1000.90, parsedatetime('2019/09/09', 'yyyy/MM/dd'), 'Sofa retratil', 5, 3),
(10, 'Cama', 350.30, parsedatetime('2019/10/10', 'yyyy/MM/dd'), 'Cama de casal', 5, 6);

insert into funcionario_produto (id_funcionario, id_produto) values 
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10);

insert into pedido_produto (quantidade, id_pedido, id_produto) values 
(1, 1, 1),
(3, 2, 8),
(2, 3, 5),
(1, 4, 2),
(1, 5, 5),
(2, 6, 10),
(2, 7, 3),
(3, 8, 4),
(1, 9, 2),
(1, 10, 6);
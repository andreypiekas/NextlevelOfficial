-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 30-Nov-2021 às 01:13
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `nextleveloficial`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(10) UNSIGNED NOT NULL,
  `Produtos_idProdutos` int(10) UNSIGNED NOT NULL,
  `Produtos_Pedido_idPedido` int(10) UNSIGNED NOT NULL,
  `Produtos_Pedido_Clientes_idClientes` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `idClientes` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `entrega` varchar(255) DEFAULT NULL,
  `cep` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `numero` int(10) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idClientes`, `nome`, `email`, `cpf`, `telefone`, `entrega`, `cep`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(1, 'andrey', 'gmail', '093.403.119-11', '(49) 9 8432-9374', '1', '89805-675', 'jerusa', 423, 'e', 'passo', 'chapeco', 'SC'),
(2, 'be', 'be', '093.403.119-20', '(39) 2 8392-3820', '938209', '32983-293', 'rua', 1, 'be', 'be', 'be', 'AC');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(10) UNSIGNED NOT NULL,
  `Clientes_idClientes` int(10) UNSIGNED NOT NULL,
  `cep` varchar(25) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `numero` int(10) UNSIGNED DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `Clientes_idClientes`, `cep`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES
(1, 1, '1', 'sa', 1, 'sas', 'asa', 'as', 'a'),
(2, 2, '2', '2dsds', 2, 'dsds', '2sdsd', 'sdsd', '2dsd'),
(3, 1, '1', 'a', 1, '1', '1', '1', 'AC'),
(4, 2, '89805390', 'rua', 1, 'comp', 'bairro', 'cidade', 'AC');

-- --------------------------------------------------------

--
-- Estrutura da tabela `forma_pagamento`
--

CREATE TABLE `forma_pagamento` (
  `idForma_pagamento` int(10) UNSIGNED NOT NULL,
  `Pedido_Clientes_idClientes` int(10) UNSIGNED NOT NULL,
  `Pedido_idPedido` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `idFuncionarios` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  `PERFIL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`idFuncionarios`, `nome`, `email`, `endereco`, `bairro`, `cidade`, `usuario`, `SENHA`, `PERFIL`) VALUES
(1, 'Andrey Gheno Piekas', 'andrey.piekas@gmail.com', 'Jerusalem 423', 'Passo dos Fortes', 'Chapecó', 'admin', 'admin', 'admin'),
(2, 'jose', '1', '1', '1', '1', 'jose', 'jose', 'user'),
(3, 'Bill Gates', 'bill@gmail.com', 'bil endereco', 'bil bairro\'', 'chapeco', 'bill', 'bill', 'user'),
(8, 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(10) UNSIGNED NOT NULL,
  `Clientes_idClientes` int(10) UNSIGNED NOT NULL,
  `produto` int(20) NOT NULL,
  `quantidade` int(10) UNSIGNED DEFAULT NULL,
  `valor` float NOT NULL,
  `valor_pedido` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `valor` float NOT NULL,
  `peso` float NOT NULL,
  `categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `descricao`, `valor`, `peso`, `categoria`) VALUES
(1, '1212', 'wqwq', 1, 1, 'Monitores'),
(4, 'sasa', 'asas', 1, 1, 'Mouse'),
(5, 'asa', '12121212', 120, 120, 'Teclado'),
(6, '2121', '2121', 1, 1, 'CPU'),
(7, 'edwew', 'ewewew', 13, 2.121, 'Gabinetes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `idProdutos` int(10) UNSIGNED NOT NULL,
  `Pedido_Clientes_idClientes` int(10) UNSIGNED NOT NULL,
  `Pedido_idPedido` int(10) UNSIGNED NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `quantidade` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`,`Produtos_idProdutos`,`Produtos_Pedido_idPedido`,`Produtos_Pedido_Clientes_idClientes`),
  ADD KEY `Categorias_FKIndex1` (`Produtos_idProdutos`,`Produtos_Pedido_Clientes_idClientes`,`Produtos_Pedido_idPedido`);

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idClientes`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`),
  ADD KEY `Endereco_FKIndex1` (`Clientes_idClientes`);

--
-- Índices para tabela `forma_pagamento`
--
ALTER TABLE `forma_pagamento`
  ADD PRIMARY KEY (`idForma_pagamento`,`Pedido_Clientes_idClientes`,`Pedido_idPedido`),
  ADD KEY `Forma_pagamento_FKIndex1` (`Pedido_idPedido`,`Pedido_Clientes_idClientes`);

--
-- Índices para tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`idFuncionarios`);

--
-- Índices para tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`,`Clientes_idClientes`),
  ADD KEY `Pedido_FKIndex1` (`Clientes_idClientes`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`idProdutos`,`Pedido_Clientes_idClientes`,`Pedido_idPedido`),
  ADD KEY `Produtos_FKIndex1` (`Pedido_idPedido`,`Pedido_Clientes_idClientes`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idClientes` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `forma_pagamento`
--
ALTER TABLE `forma_pagamento`
  MODIFY `idForma_pagamento` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `idFuncionarios` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `idProdutos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `categorias`
--
ALTER TABLE `categorias`
  ADD CONSTRAINT `categorias_ibfk_1` FOREIGN KEY (`Produtos_idProdutos`,`Produtos_Pedido_Clientes_idClientes`,`Produtos_Pedido_idPedido`) REFERENCES `produtos` (`idProdutos`, `Pedido_Clientes_idClientes`, `Pedido_idPedido`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`Clientes_idClientes`) REFERENCES `clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `forma_pagamento`
--
ALTER TABLE `forma_pagamento`
  ADD CONSTRAINT `forma_pagamento_ibfk_1` FOREIGN KEY (`Pedido_idPedido`,`Pedido_Clientes_idClientes`) REFERENCES `pedido` (`idPedido`, `Clientes_idClientes`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`Clientes_idClientes`) REFERENCES `clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`Pedido_idPedido`,`Pedido_Clientes_idClientes`) REFERENCES `pedido` (`idPedido`, `Clientes_idClientes`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
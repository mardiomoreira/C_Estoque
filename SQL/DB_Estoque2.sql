-- phpMyAdmin SQL Dump
-- version 5.1.1-2.fc35
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 04-Dez-2021 às 23:56
-- Versão do servidor: 10.5.12-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `DB_Estoque2`
--
CREATE DATABASE IF NOT EXISTS `DB_Estoque2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `DB_Estoque2`;

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `AD_EntradaProdutoEstoque` (IN `idProduto` INT(10), IN `qtdeEntrada` INT(10), IN `ValoUnitario` DOUBLE)  INSERT INTO tbl_estoque(tbl_estoque.est_id_produto, tbl_estoque.est_qtde, tbl_estoque.est_valor_unitario)VALUES(idProduto, qtdeEntrada,ValoUnitario)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AD_SaidaProdutoEstoque` (IN `idProduto` INT(10), IN `qtdeSaida` INT(10), IN `ValoUnitario` DOUBLE)  INSERT INTO tbl_estoque(tbl_estoque.est_id_produto, tbl_estoque.est_qtde, tbl_estoque.est_valor_unitario)VALUES(idProduto, qtdeSaida * -1,ValoUnitario)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_entrada_produto`
--

CREATE TABLE `tbl_entrada_produto` (
  `ent_id` int(11) NOT NULL,
  `ent_id_produto` int(11) DEFAULT NULL,
  `ent_qtde` int(11) DEFAULT NULL,
  `ent_valor_unitario` double(9,2) DEFAULT 0.00,
  `ent_data_entrada` date DEFAULT NULL,
  `ent_datacad` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_entrada_produto`
--

INSERT INTO `tbl_entrada_produto` (`ent_id`, `ent_id_produto`, `ent_qtde`, `ent_valor_unitario`, `ent_data_entrada`, `ent_datacad`) VALUES
(2, 3, 22, 3.55, '2021-12-01', '2021-12-03 16:04:13');

--
-- Acionadores `tbl_entrada_produto`
--
DELIMITER $$
CREATE TRIGGER `TRG_EntradaProduto_AI` AFTER INSERT ON `tbl_entrada_produto` FOR EACH ROW BEGIN
      CALL AD_EntradaProdutoEstoque (new.ent_id_produto, new.ent_qtde, new.ent_valor_unitario);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_estoque`
--

CREATE TABLE `tbl_estoque` (
  `est_id` int(11) NOT NULL,
  `est_id_produto` int(11) DEFAULT NULL,
  `est_qtde` int(11) DEFAULT NULL,
  `est_valor_unitario` double(9,2) DEFAULT 0.00,
  `est_datacad` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_estoque`
--

INSERT INTO `tbl_estoque` (`est_id`, `est_id_produto`, `est_qtde`, `est_valor_unitario`, `est_datacad`) VALUES
(1, 3, 22, 3.55, '0000-00-00 00:00:00'),
(2, 3, -22, 4.21, '2021-12-03 16:05:25');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_produto`
--

CREATE TABLE `tbl_produto` (
  `pro_id` int(11) NOT NULL,
  `pro_fkidtipo` int(11) NOT NULL,
  `pro_status` varchar(10) NOT NULL,
  `pro_descricao` varchar(50) DEFAULT NULL,
  `pro_estoque_minimo` int(11) DEFAULT NULL,
  `pro_estoque_maximo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_produto`
--

INSERT INTO `tbl_produto` (`pro_id`, `pro_fkidtipo`, `pro_status`, `pro_descricao`, `pro_estoque_minimo`, `pro_estoque_maximo`) VALUES
(3, 1, 'Ativado', 'Fanta', 10, 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_saida_produto`
--

CREATE TABLE `tbl_saida_produto` (
  `sai_id` int(11) NOT NULL,
  `sai_id_produto` int(11) DEFAULT NULL,
  `sai_qtde` int(11) DEFAULT NULL,
  `sai_valor_unitario` double(9,2) DEFAULT 0.00,
  `sai_data_saida` date DEFAULT NULL,
  `sai_datacad` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_saida_produto`
--

INSERT INTO `tbl_saida_produto` (`sai_id`, `sai_id_produto`, `sai_qtde`, `sai_valor_unitario`, `sai_data_saida`, `sai_datacad`) VALUES
(1, 3, 22, 4.21, '2021-12-01', NULL);

--
-- Acionadores `tbl_saida_produto`
--
DELIMITER $$
CREATE TRIGGER `TRG_SaidaProduto_AI` BEFORE INSERT ON `tbl_saida_produto` FOR EACH ROW BEGIN
      CALL AD_SaidaProdutoEstoque (new.sai_id_produto, new.sai_qtde, new.sai_valor_unitario);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_tipo_produto`
--

CREATE TABLE `tbl_tipo_produto` (
  `tip_id` int(11) NOT NULL,
  `tip_descricao` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_tipo_produto`
--

INSERT INTO `tbl_tipo_produto` (`tip_id`, `tip_descricao`) VALUES
(1, 'Refrigerante'),
(2, 'Eletro Domestico');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `usu_id` int(11) NOT NULL,
  `usu_nome` varchar(70) NOT NULL,
  `usu_email` varchar(70) NOT NULL,
  `usu_senha` varchar(32) NOT NULL,
  `usu_datacad` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`usu_id`, `usu_nome`, `usu_email`, `usu_senha`, `usu_datacad`) VALUES
(1, 'Mardio Moreira', 'mardioba@gmail.com', '1978', '2021-12-04 19:42:46');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbl_entrada_produto`
--
ALTER TABLE `tbl_entrada_produto`
  ADD PRIMARY KEY (`ent_id`),
  ADD KEY `fk_id_produto` (`ent_id_produto`);

--
-- Índices para tabela `tbl_estoque`
--
ALTER TABLE `tbl_estoque`
  ADD PRIMARY KEY (`est_id`);

--
-- Índices para tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD PRIMARY KEY (`pro_id`),
  ADD KEY `produto_id` (`pro_id`),
  ADD KEY `FK_Tipo` (`pro_fkidtipo`);

--
-- Índices para tabela `tbl_saida_produto`
--
ALTER TABLE `tbl_saida_produto`
  ADD PRIMARY KEY (`sai_id`),
  ADD KEY `fk_id_produto` (`sai_id_produto`);

--
-- Índices para tabela `tbl_tipo_produto`
--
ALTER TABLE `tbl_tipo_produto`
  ADD PRIMARY KEY (`tip_id`),
  ADD KEY `tipo_id` (`tip_id`) USING BTREE;

--
-- Índices para tabela `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`usu_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_entrada_produto`
--
ALTER TABLE `tbl_entrada_produto`
  MODIFY `ent_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tbl_estoque`
--
ALTER TABLE `tbl_estoque`
  MODIFY `est_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  MODIFY `pro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbl_saida_produto`
--
ALTER TABLE `tbl_saida_produto`
  MODIFY `sai_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbl_tipo_produto`
--
ALTER TABLE `tbl_tipo_produto`
  MODIFY `tip_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `usu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tbl_entrada_produto`
--
ALTER TABLE `tbl_entrada_produto`
  ADD CONSTRAINT `FK_Ent_Produto` FOREIGN KEY (`ent_id_produto`) REFERENCES `tbl_produto` (`pro_id`);

--
-- Limitadores para a tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD CONSTRAINT `FK_Tipo` FOREIGN KEY (`pro_fkidtipo`) REFERENCES `tbl_tipo_produto` (`tip_id`);

--
-- Limitadores para a tabela `tbl_saida_produto`
--
ALTER TABLE `tbl_saida_produto`
  ADD CONSTRAINT `FK_Sai_Produto` FOREIGN KEY (`sai_id_produto`) REFERENCES `tbl_produto` (`pro_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

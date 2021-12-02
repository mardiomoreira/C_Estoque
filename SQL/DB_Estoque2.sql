-- phpMyAdmin SQL Dump
-- version 5.1.1-2.fc35
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 02-Dez-2021 às 15:59
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
  `ent_datacad` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_estoque`
--

CREATE TABLE `tbl_estoque` (
  `est_id` int(11) NOT NULL,
  `est_id_produto` int(11) DEFAULT NULL,
  `est_qtde` int(11) DEFAULT NULL,
  `est_valor_unitario` double(9,2) DEFAULT 0.00,
  `est_datacad` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_tipo_produto`
--

CREATE TABLE `tbl_tipo_produto` (
  `tip_id` int(11) NOT NULL,
  `tip_descricao` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `usu_id` int(11) NOT NULL,
  `usu_nome` varchar(70) NOT NULL,
  `usu_email` varchar(70) NOT NULL,
  `usu_senha` varchar(32) NOT NULL,
  `usu_datacad` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbl_entrada_produto`
--
ALTER TABLE `tbl_entrada_produto`
  ADD PRIMARY KEY (`ent_id`);

--
-- Índices para tabela `tbl_estoque`
--
ALTER TABLE `tbl_estoque`
  ADD PRIMARY KEY (`est_id`);

--
-- Índices para tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD PRIMARY KEY (`pro_id`);

--
-- Índices para tabela `tbl_saida_produto`
--
ALTER TABLE `tbl_saida_produto`
  ADD PRIMARY KEY (`sai_id`);

--
-- Índices para tabela `tbl_tipo_produto`
--
ALTER TABLE `tbl_tipo_produto`
  ADD PRIMARY KEY (`tip_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_entrada_produto`
--
ALTER TABLE `tbl_entrada_produto`
  MODIFY `ent_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_estoque`
--
ALTER TABLE `tbl_estoque`
  MODIFY `est_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  MODIFY `pro_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_saida_produto`
--
ALTER TABLE `tbl_saida_produto`
  MODIFY `sai_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbl_tipo_produto`
--
ALTER TABLE `tbl_tipo_produto`
  MODIFY `tip_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

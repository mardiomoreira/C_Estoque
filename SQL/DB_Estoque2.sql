-- phpMyAdmin SQL Dump
-- version 5.1.1-2.fc35
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 07-Dez-2021 às 20:33
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
  `ent_datacad` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(1, 'Mardio Moreira', 'admin@localhost.com', 'admin', '2021-12-05 19:01:16');

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_estoqueproduto`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `vw_estoqueproduto` (
`pro_id` int(11)
,`pro_fkidtipo` int(11)
,`pro_status` varchar(10)
,`pro_descricao` varchar(50)
,`pro_estoque_minimo` int(11)
,`pro_estoque_maximo` int(11)
,`tip_id` int(11)
,`tip_descricao` varchar(70)
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `vw_produto`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `vw_produto` (
`TipoProduto` varchar(70)
,`pro_id` int(11)
,`pro_fkidtipo` int(11)
,`pro_status` varchar(10)
,`pro_descricao` varchar(50)
,`pro_estoque_minimo` int(11)
,`pro_estoque_maximo` int(11)
);

-- --------------------------------------------------------

--
-- Estrutura para vista `vw_estoqueproduto`
--
DROP TABLE IF EXISTS `vw_estoqueproduto`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_estoqueproduto`  AS SELECT `tbl_produto`.`pro_id` AS `pro_id`, `tbl_produto`.`pro_fkidtipo` AS `pro_fkidtipo`, `tbl_produto`.`pro_status` AS `pro_status`, `tbl_produto`.`pro_descricao` AS `pro_descricao`, `tbl_produto`.`pro_estoque_minimo` AS `pro_estoque_minimo`, `tbl_produto`.`pro_estoque_maximo` AS `pro_estoque_maximo`, `tbl_tipo_produto`.`tip_id` AS `tip_id`, `tbl_tipo_produto`.`tip_descricao` AS `tip_descricao` FROM (`tbl_produto` join `tbl_tipo_produto` on(`tbl_produto`.`pro_fkidtipo` = `tbl_tipo_produto`.`tip_id`)) ;

-- --------------------------------------------------------

--
-- Estrutura para vista `vw_produto`
--
DROP TABLE IF EXISTS `vw_produto`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_produto`  AS SELECT `t`.`tip_descricao` AS `TipoProduto`, `p`.`pro_id` AS `pro_id`, `p`.`pro_fkidtipo` AS `pro_fkidtipo`, `p`.`pro_status` AS `pro_status`, `p`.`pro_descricao` AS `pro_descricao`, `p`.`pro_estoque_minimo` AS `pro_estoque_minimo`, `p`.`pro_estoque_maximo` AS `pro_estoque_maximo` FROM (`tbl_produto` `p` join `tbl_tipo_produto` `t` on(`p`.`pro_fkidtipo` = `t`.`tip_id`)) ;

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

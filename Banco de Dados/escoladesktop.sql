-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 18/05/2019 às 10:38
-- Versão do servidor: 5.7.26-0ubuntu0.18.04.1
-- Versão do PHP: 7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `escoladesktop`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `intAlunoId` smallint(5) UNSIGNED NOT NULL,
  `intPessoaId` smallint(5) UNSIGNED NOT NULL,
  `strMatricula` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `datDataNasc` date NOT NULL,
  `strMaeAluno` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `strPaiAluno` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `aluno`
--

INSERT INTO `aluno` (`intAlunoId`, `intPessoaId`, `strMatricula`, `datDataNasc`, `strMaeAluno`, `strPaiAluno`) VALUES
(1, 1, '067Gus', '2019-05-21', 'mae', 'paia'),
(2, 2, '005bob', '2019-05-15', '9393939', '3949949494'),
(3, 3, '362Lua', '2019-07-05', 'dsadsa', 'sadasd');

-- --------------------------------------------------------

--
-- Estrutura para tabela `curso`
--

CREATE TABLE `curso` (
  `intCursoId` smallint(5) UNSIGNED NOT NULL,
  `strNomeCurso` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `intDuracao` tinyint(3) UNSIGNED NOT NULL,
  `strTurno` varchar(34) COLLATE utf8_unicode_ci NOT NULL,
  `intSerie` tinyint(3) UNSIGNED NOT NULL,
  `strAnoLetivo` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `curso`
--

INSERT INTO `curso` (`intCursoId`, `strNomeCurso`, `intDuracao`, `strTurno`, `intSerie`, `strAnoLetivo`) VALUES
(1, 'ensino fundamental', 6, 'noturno', 2, 2018);

-- --------------------------------------------------------

--
-- Estrutura para tabela `log_usr_table`
--

CREATE TABLE `log_usr_table` (
  `intLogId` smallint(5) UNSIGNED NOT NULL,
  `strNameTmp` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `strTipo` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `matricula`
--

CREATE TABLE `matricula` (
  `intMatriculaId` smallint(5) UNSIGNED NOT NULL,
  `intAlunoId` smallint(5) UNSIGNED NOT NULL,
  `intTurmaId` smallint(5) UNSIGNED NOT NULL,
  `datDataMatricula` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `strStatusMatricula` enum('Pendente','Matriculado') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `matricula`
--

INSERT INTO `matricula` (`intMatriculaId`, `intAlunoId`, `intTurmaId`, `datDataMatricula`, `strStatusMatricula`) VALUES
(1, 1, 1, '2019-05-16 22:42:03', 'Matriculado'),
(2, 2, 1, '2019-05-17 13:45:42', 'Matriculado'),
(3, 3, 1, '2019-05-18 00:05:34', 'Matriculado');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `intPessoaId` smallint(5) UNSIGNED NOT NULL,
  `strNomePessoa` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `strRgPessoa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `strCpfPessoa` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `strTelPessoa` varchar(34) COLLATE utf8_unicode_ci NOT NULL,
  `strEmailPessoa` varchar(84) COLLATE utf8_unicode_ci NOT NULL,
  `strSexoPessoa` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `strCidadePessoa` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `strEnderecoPessoa` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `strUfPessoa` char(2) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `pessoa`
--

INSERT INTO `pessoa` (`intPessoaId`, `strNomePessoa`, `strRgPessoa`, `strCpfPessoa`, `strTelPessoa`, `strEmailPessoa`, `strSexoPessoa`, `strCidadePessoa`, `strEnderecoPessoa`, `strUfPessoa`) VALUES
(1, 'Gustavo Barbosa Barros', '83.838.383-83', '067.508.925-58', '(26) 36363-6363', 'gsgdjdjdjdj@gmail.com', 'Masculino', 'jjdjdjdjdj', 'canindé são franciscosh', 'BA'),
(2, 'bobo', '38.388.383-83', '005.329.265-01', '(28) 82838-3883', '288383838@gmail.com', 'Masculino', 'ekkk', '3344475757', 'SE'),
(3, 'Luan', '84.848.484-84', '362.911.498-93', '(12) 12345-6576', 'bsahbsAHdsb@gmail.com', 'Masculino', 'delmiro', 'sdasdasd', 'AL');

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor`
--

CREATE TABLE `professor` (
  `intProfId` smallint(5) UNSIGNED NOT NULL,
  `intPessoaId` smallint(5) UNSIGNED NOT NULL,
  `strFormacaoProf` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `professor`
--

INSERT INTO `professor` (`intProfId`, `intPessoaId`, `strFormacaoProf`) VALUES
(1, 2, 'professora de matematica');

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma`
--

CREATE TABLE `turma` (
  `intTurmaId` smallint(5) UNSIGNED NOT NULL,
  `intCursoId` smallint(5) UNSIGNED NOT NULL,
  `intCapacidade` tinyint(3) UNSIGNED NOT NULL,
  `strHorarioInicio` time NOT NULL,
  `strHorarioFinal` time NOT NULL,
  `strDscTurma` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `intVagasOcupadas` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `turma`
--

INSERT INTO `turma` (`intTurmaId`, `intCursoId`, `intCapacidade`, `strHorarioInicio`, `strHorarioFinal`, `strDscTurma`, `intVagasOcupadas`) VALUES
(1, 1, 5, '19:15:00', '22:00:00', 'Turma A12', 3),
(2, 1, 20, '22:00:00', '19:00:00', 'Turma A33', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma_professor`
--

CREATE TABLE `turma_professor` (
  `intTurmaProfId` smallint(5) UNSIGNED NOT NULL,
  `intTurmaId` smallint(5) UNSIGNED NOT NULL,
  `intProfId` smallint(5) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `turma_professor`
--

INSERT INTO `turma_professor` (`intTurmaProfId`, `intTurmaId`, `intProfId`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `uf_estado`
--

CREATE TABLE `uf_estado` (
  `intUfId` smallint(5) UNSIGNED NOT NULL,
  `uf` char(2) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `uf_estado`
--

INSERT INTO `uf_estado` (`intUfId`, `uf`) VALUES
(1, 'RO'),
(2, 'AC'),
(3, 'AM'),
(4, 'RR'),
(5, 'PA'),
(6, 'AP'),
(7, 'TO'),
(8, 'MA'),
(9, 'PI'),
(10, 'CE'),
(11, 'RN'),
(12, 'PB'),
(13, 'PE'),
(14, 'AL'),
(15, 'SE'),
(16, 'BA'),
(17, 'MG'),
(18, 'ES'),
(19, 'RJ'),
(20, 'SP'),
(21, 'PR'),
(22, 'SC'),
(23, 'RS'),
(24, 'MS'),
(25, 'MT'),
(26, 'GO'),
(27, 'DF');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `intUsuarioId` smallint(5) UNSIGNED NOT NULL,
  `strSenha` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `strUserName` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `strUsuarioTipo` enum('Usuario','Admin') COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`intUsuarioId`, `strSenha`, `strUserName`, `strUsuarioTipo`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'bobo96', 'gustavo', 'Usuario');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`intAlunoId`);

--
-- Índices de tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`intCursoId`);

--
-- Índices de tabela `log_usr_table`
--
ALTER TABLE `log_usr_table`
  ADD PRIMARY KEY (`intLogId`);

--
-- Índices de tabela `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`intMatriculaId`);

--
-- Índices de tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`intPessoaId`);

--
-- Índices de tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`intProfId`);

--
-- Índices de tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`intTurmaId`);

--
-- Índices de tabela `turma_professor`
--
ALTER TABLE `turma_professor`
  ADD PRIMARY KEY (`intTurmaProfId`);

--
-- Índices de tabela `uf_estado`
--
ALTER TABLE `uf_estado`
  ADD PRIMARY KEY (`intUfId`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`intUsuarioId`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `intAlunoId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `intCursoId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `log_usr_table`
--
ALTER TABLE `log_usr_table`
  MODIFY `intLogId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `matricula`
--
ALTER TABLE `matricula`
  MODIFY `intMatriculaId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `intPessoaId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `intProfId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `intTurmaId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `turma_professor`
--
ALTER TABLE `turma_professor`
  MODIFY `intTurmaProfId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `uf_estado`
--
ALTER TABLE `uf_estado`
  MODIFY `intUfId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `intUsuarioId` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

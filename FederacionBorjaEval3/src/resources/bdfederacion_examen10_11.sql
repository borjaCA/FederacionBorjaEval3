-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2022 a las 20:16:29
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdfederacion`
--
CREATE DATABASE IF NOT EXISTS `bdfederacion` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdfederacion`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `abreviatura` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `abreviatura` (`abreviatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `abreviatura`) VALUES
(1, 'Junior', 'J'),
(2, 'Senior', 'S'),
(3, 'Especial', 'E');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

DROP TABLE IF EXISTS `lugares`;
CREATE TABLE IF NOT EXISTS `lugares` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `airelibre` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lugares`
--

INSERT INTO `lugares` (`id`, `nombre`, `ubicacion`, `airelibre`) VALUES
(1, 'Las Mestas', 'Gijon', 1),
(2, 'Centro Ciudad', 'Gijon', 1),
(3, 'Parque San Francisco', 'Oviedo', 1),
(4, 'Puerto', 'Aviles', 1),
(5, 'Pabellon deportivo Aviles', 'Aviles', 0),
(6, 'Centro ciudad', 'Oviedo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metales`
--

DROP TABLE IF EXISTS `metales`;
CREATE TABLE IF NOT EXISTS `metales` (
  `idMetal` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoMetal` int(11) NOT NULL,
  `pureza` int(11) NOT NULL,
  `es_oro` tinyint(1) NOT NULL,
  `es_plata` tinyint(1) NOT NULL,
  `es_bronce` tinyint(1) NOT NULL,
  PRIMARY KEY (`idMetal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participantes`
--

DROP TABLE IF EXISTS `participantes`;
CREATE TABLE IF NOT EXISTS `participantes` (
  `id` int(11) NOT NULL,
  `dorsal` int(11) NOT NULL,
  `calle` char(1) NOT NULL,
  `tiempo` date NOT NULL,
  `penalizacion` tinyint(1) NOT NULL DEFAULT 0,
  `otros` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinadores`
--

DROP TABLE IF EXISTS `patrocinadores`;
CREATE TABLE IF NOT EXISTS `patrocinadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `web` varchar(150) DEFAULT NULL,
  `dotacion` double NOT NULL,
  `idresponsable` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_responsables` (`idresponsable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `teléfono` varchar(15) DEFAULT NULL,
  `nifnie` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nifnie` (`nifnie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `nombre`, `teléfono`, `nifnie`) VALUES
(1, 'Jesus Perez Garcia', '697032897', '79884158YY'),
(2, 'Carlos Fernandez Avia', '685432819', 'Z2810144DD'),
(3, 'Luis Martinez Diaz', '695342871', '63905890EE'),
(4, 'Carmen Corrales Vega', '645532881', '46828272LL'),
(5, 'Daniel Ruiz Blanco', '921342819', '86491678VV'),
(6, 'Pedro Gonzalez Puig', '690552712', '14504723AA'),
(7, 'Martin Ibarra Encina', '683542893', 'Y9803437TT'),
(8, 'Dinia Pino Novell', '685302577', '23351676YY'),
(9, 'Maria Frisuelos Ruiz', '605437884', '05126137NN'),
(10, 'Hector Garcia Perez', '607332815', '45569516FF'),
(11, 'Carmen Perez Foz', '945707801', 'Y6816054HH'),
(12, 'Francisco Plaza Ayuso', '694432818', '74551686SS'),
(13, 'Maria Jesus Perez Salinas', '635714801', '87075186SS'),
(14, 'Laura Castro Llorente', '695432805', 'X7835722JJ'),
(15, 'Gabriela del Rio Severo', '681232816', '63143774BB'),
(16, 'Carla Gallo Pedroso', '687342207', 'Y2003454FF'),
(17, 'Alberto Perez Lago', '695382349', '47686821RR'),
(18, 'Aser Linares Nobel', '685337834', 'Y3219078NN'),
(19, 'Daniel Suarez Melano', '680734341', '27990801PP'),
(20, 'Raquel Gonzalez Banda', '985334823', '35950063MM'),
(21, 'Maria Calvo Egea', '930332814', 'Y9217608GG'),
(22, 'Hugo Blasco Rato', '684035810', 'Y1315777FF'),
(23, 'Andrés Martinez Real', '671332800', '21540499XX'),
(24, 'Raul Velazquez Garcia', '690352881', '37200319GG'),
(25, 'Asuncion Garcia Perez', '603330818', '87546570ZZ'),
(26, 'Juan Jesus Ruiz Volantes', '620932819', 'Y3820064PP'),
(27, 'Cecilio Gallo Garcia', '684012713', 'X9910159BB'),
(28, 'Sandra Vega Cuena', '605384817', 'Z7129295JJ'),
(29, 'Sergio Poo Martinez', '608332113', 'Y6478494YY'),
(30, 'Pedro Toca Gutierrez', '985432713', '88436792KK'),
(31, 'Borja Perez Suarez', '680332801', '34266474QQ'),
(32, 'Ander Santos Higuera', '682452807', '20500427KK'),
(33, 'Dominica Gonzalez Perez', '650237810', '48830175WW'),
(34, 'Laura Suarez Blasco', '680345912', 'X9138596YY'),
(35, 'Almudena Diaz Maltras', '685482881', '19990649SS'),
(36, 'Nicolasa Serrano Soto', '647002899', '13872236QQ'),
(37, 'Maria Jesus Ibarra Montoya', '678305812', '01117391MM'),
(38, 'Yolanda Lopez Garcia', '684372315', '59578903WW'),
(39, 'Renata Prieto Fernandez', '605399813', '56057601TT'),
(40, 'Antonia Garcia Herrera', '675332884', '91260406VV'),
(41, 'Diego Diez Murcia', '645572813', '98888455RR'),
(42, 'Agatha Fernandez Marron', '644382856', 'Y5240564MM'),
(43, 'Luis Plaza Martinez', '607332436', 'Y6996579QQ'),
(44, 'Alberto Corrales Suarez', '629332834', '25185243JJ'),
(45, 'Pedro del Val Almendro', '678433858', 'Z8898003KK'),
(46, 'Teresa Gonzalez Garcia', '615432888', '22911082TT'),
(47, 'Luisa Pina Soto', '605332720', 'Z1070890SS'),
(48, 'Jana Blanco Garcia', '635337841', '38274943EE'),
(49, 'Cristina Pedrosa Garcia', '605372412', 'Y5186185KK'),
(50, 'Daniel Pares Mendez', '985357417', '24161829FF'),
(51, 'Martin Velazquez Melendez', '913232811', 'X9093177NN'),
(52, 'Candida Rato Linares', '605332872', '30068839LL'),
(53, 'Sebastian Castro Castro', '985372809', 'Z4405868QQ'),
(54, 'Carlos del Pino Inda', '685332817', '89346924CC'),
(55, 'Lucia Santos Fresneda', '949332872', '21161772RR'),
(56, 'Andrés Diaz Lago', '609332927', '06691648MM'),
(57, 'Brigida Fernandez Fernandez', '675332819', '68836577SS'),
(58, 'Carlos Melano Largo', '685932817', '87395778XX'),
(59, 'Maria Rox Suarez', '985538470', '48160328FF'),
(60, 'Francisco Calvo Real', '604832312', '98914169RR'),
(61, 'Diego Egea Gutierres', '987932838', '90534710VV'),
(62, 'Pablo Diez Vega', '67133591', 'Z1199554VV'),
(63, 'Hector Suarez Gonzalez', '670358827', 'Z7377141BB'),
(64, 'Andrés Gonzalez Res', '935332801', '94414619XX'),
(65, 'Juan Encina Panes', '609132923', '72420077TT'),
(66, 'Asier Mendez Blanco', '642782839', '62019976QQ'),
(67, 'Luis Rajoy Garcia', '695282109', '46849293HH'),
(68, 'Rafael Pis Pedrosa', '685332913', '22260154HH'),
(69, 'Federico Ruiz Fresno', '685722391', '35999192YY'),
(70, 'Rosa Feroz Corbato', '645332823', '45592209EE'),
(71, 'Rai Jordan Riego Garcia', '918332819', '29509240XX'),
(72, 'Carmen Lago Par', '649332871', '55317592QQ'),
(73, 'Asuncion Serrano Vega', '635839771', 'Z2449848PP'),
(74, 'Marina Castro Garcia', '659331801', 'Z9639053BB'),
(75, 'Maria Ana de la Riva Suarez', '685932890', '63953293EE'),
(76, 'Maria Salas Fernandez', '675331829', 'Z5616471ZZ'),
(77, 'Amaya Fernandez Muela', '97539218', 'Y8120580FF'),
(78, 'Sandra Peres Robles', '929352801', '25545002YY'),
(79, 'Ursula Suarez Diaz', '645702851', 'X3894583QQ'),
(80, 'Gabriel Julio Sol', '985372858', '97000644FF'),
(81, 'Carlos Culto Medina', '6230328710', '68259257HH'),
(82, 'Natasha Puig Garcia', '625159802', '61552508TT'),
(83, 'Dario Linares Gutierrez', '988032859', '33304935SS'),
(84, 'Diego Bolo Garcia', '659373808', 'Y9109501CC'),
(85, 'Alberto Agujas Montoya', '930832821', '69584451KK'),
(86, 'Martin Garcia Garcia', '698501818', '03922672EE'),
(87, 'Jorge Ibarretxe Gallo', '680392814', '06122090LL'),
(88, 'Daniel Muela Velazquez', '682312841', '58383386WW'),
(89, 'Teresa Martinez Vivo', '680372845', '93444140QQ'),
(90, 'Borja Lagos Perez', '699332873', '51501442AA'),
(91, 'Andrés Gonzalez Galvez', '989300959', 'Z8975296BB'),
(92, 'Maria Garcia de Vivar', '938332801', '14191079XX'),
(93, 'Juan Robles Sello', '689337821', '69459190HH'),
(94, 'Pablo Leon Garcia', '685409720', '15666207XX'),
(95, 'Amalia del Pino Gutierrez', '910832839', '62719184RR'),
(96, 'Raul Plaza Corbato', '694937805', '51716605RR'),
(97, 'Padro Santos Diaz', '637339880', '07959689XX'),
(98, 'Juaquin Dalmata Serrano', '929330831', '02776875QQ'),
(99, 'Francisco Suarez Serrano', '970309833', '99578560ZZ'),
(100, 'Emma Fernandez Corral', '941272809', '04745542KK'),
(1001, 'Sonia Montoya Torna', '671250081', '49268896KK'),
(1002, 'Natalia Prado Aguja', '680235891', '38257152XX'),
(1003, 'Martin Puig Fernandez', '694382839', '26479666LL'),
(1004, 'Juan Alvarez Roig', '685732413', 'Z8320480MM'),
(1005, 'Carlos Diez Cobo', '675312945', 'Y3484465WW'),
(1006, 'Carmen Martinez Tazones', '958232831', '93040321PP'),
(1007, 'Hector Calvo Blanco', '688257823', 'X8022492TT'),
(1008, 'Pablo Linares Altamira', '697131831', '97933051VV'),
(1009, 'Hugo Fuero Ruiz', '951832859', 'Y1374421RR'),
(1010, 'Luis Garcia Gonzalez', '681952317', '08248618JJ'),
(1011, 'Carmen Diaz Castro', '61734815', 'X8820989YY'),
(1012, 'Borja Vega Martinez', '688215870', '31010189WW'),
(1013, 'Carlos Garcia Perez', '650732808', '35274924PP'),
(1014, 'Maria Ruiz Fernandez', '652732818', '29955406EE'),
(1015, 'Emma del Rio Flores', '650732111', '42623765GG'),
(2001, 'Rosario Prado Blanco', '627943650', '67480770NN'),
(2002, 'Laura Torices Fernandez', '685334056', '96667252TT'),
(2003, 'Manuel Santiago Diez', '638135956', 'Z9137448JJ'),
(2004, 'Alfredo Garcia Gallo', '608364550', 'Y4676770XX'),
(2005, 'Ramon Garcia Lazo', '694267193', '54153902BB'),
(2006, 'Rosa Diez Lucas', '628324853', '88527918KK'),
(2007, 'Ana Ruiz Arenas', '629304871', 'Y3929494GG'),
(2008, 'Alvaro Osorno Soto', '654768870', '21476623MM'),
(2009, 'Bernabe Ruiz Garcia', '623804841', '06306180VV'),
(2010, 'Elisabeth Salamanca Blanco', '669359871', '91471649MM'),
(2011, 'Ana Ruiz Jurado', '609304772', '85261098YY'),
(2012, 'Maria Cuena Velazquez', '672340851', '28236468NN'),
(2013, 'Juana de la Riva Gutierrez', '629904871', '95813317DD'),
(2014, 'Damian Ortiz Arenas', '681331773', '84148818YY'),
(2015, 'Cesar Gutierrez Fernandez', '690302861', '25356152DD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsables`
--

DROP TABLE IF EXISTS `responsables`;
CREATE TABLE IF NOT EXISTS `responsables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telefonoProf` varchar(10) NOT NULL,
  `horarioIni` datetime DEFAULT NULL,
  `horarioFin` datetime DEFAULT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `horarioIni` (`horarioIni`),
  KEY `FK_personas` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE IF NOT EXISTS `resultados` (
  `id` int(11) NOT NULL,
  `oro` int(11) NOT NULL,
  `plata` int(11) NOT NULL,
  `bronce` int(11) NOT NULL,
  `definitivo` tinyint(1) NOT NULL,
  `fechahora` int(11) NOT NULL,
  `participanteOro` int(11) DEFAULT NULL,
  `participantePlata` int(11) DEFAULT NULL,
  `participanteBronce` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `patrocinadores`
--
ALTER TABLE `patrocinadores`
  ADD CONSTRAINT `FK_responsables` FOREIGN KEY (`idresponsable`) REFERENCES `responsables` (`id`);

--
-- Filtros para la tabla `responsables`
--
ALTER TABLE `responsables`
  ADD CONSTRAINT `FK_personas` FOREIGN KEY (`idpersona`) REFERENCES `personas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

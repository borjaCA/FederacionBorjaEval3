-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2022 a las 20:36:29
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

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `obtenerNombrePersona`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerNombrePersona` (IN `EMP_ID` INT, OUT `EMP_FIRST` VARCHAR(255))  BEGIN SELECT nombre INTO EMP_FIRST FROM personas WHERE id =
			  EMP_ID; END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `atletas`
--

DROP TABLE IF EXISTS `atletas`;
CREATE TABLE IF NOT EXISTS `atletas` (
  `id` int(11) NOT NULL,
  `altura` float NOT NULL,
  `peso` float NOT NULL,
  `idpersona` int(11) NOT NULL,
  `idequipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKPERSONA` (`idpersona`),
  KEY `FKEQUIPO` (`idequipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `atletas`
--

INSERT INTO `atletas` (`id`, `altura`, `peso`, `idpersona`, `idequipo`) VALUES
(1, 1.7, 89.9, 1, NULL),
(2, 1.98, 72.8, 2, NULL),
(3, 1.69, 65.7, 3, NULL),
(4, 1.9, 89.4, 4, NULL),
(5, 1.87, 68, 5, NULL),
(6, 1.81, 67.5, 6, NULL),
(7, 1.79, 89.9, 7, NULL),
(8, 1.86, 65.8, 8, NULL),
(9, 1.9, 72, 9, NULL),
(10, 1.81, 84.8, 10, NULL),
(11, 1.76, 89.5, 11, NULL),
(12, 1.99, 67.7, 12, NULL),
(13, 1.6, 65.6, 13, NULL),
(14, 1.86, 79.2, 14, NULL),
(15, 1.79, 84.4, 15, NULL),
(16, 1.81, 68.9, 16, NULL),
(17, 1.99, 69.3, 17, NULL),
(18, 1.8, 65, 18, NULL),
(19, 1.69, 68.8, 19, NULL),
(20, 1.79, 84.6, 20, NULL),
(21, 1.86, 69.2, 21, NULL),
(22, 1.89, 69, 22, NULL),
(23, 1.99, 79.4, 23, NULL),
(24, 1.82, 69.7, 24, NULL),
(25, 1.79, 87.8, 25, NULL),
(26, 1.8, 69.3, 26, NULL),
(27, 1.89, 65, 27, NULL),
(28, 1.99, 68.2, 28, NULL),
(29, 1.85, 89.8, 29, NULL),
(30, 1.89, 79.8, 30, NULL),
(31, 1.76, 64.5, 31, NULL),
(32, 1.81, 69, 32, NULL),
(33, 1.99, 88.1, 33, NULL),
(34, 1.6, 69.5, 34, NULL),
(35, 1.86, 67.7, 35, NULL),
(36, 1.89, 64.9, 36, NULL),
(37, 1.71, 89.8, 37, NULL),
(38, 1.89, 68.6, 38, NULL),
(39, 1.89, 79.6, 39, NULL),
(40, 1.65, 69.4, 40, NULL),
(41, 1.89, 65, 41, NULL),
(42, 1.7, 89.5, 42, NULL),
(43, 1.79, 69.1, 43, NULL),
(44, 1.81, 78.8, 44, NULL),
(45, 1.99, 89, 45, NULL),
(46, 1.86, 69.7, 46, NULL),
(47, 1.69, 89.1, 47, NULL),
(48, 1.79, 69.5, 48, NULL),
(49, 1.7, 79.2, 49, NULL),
(50, 1.86, 69.9, 50, NULL),
(51, 1.81, 88, 51, NULL),
(52, 1.99, 64.1, 52, NULL),
(53, 1.69, 69.2, 53, NULL),
(54, 1.86, 85.5, 54, NULL),
(55, 1.8, 69.1, 55, NULL),
(56, 1.89, 89.5, 56, NULL),
(57, 1.71, 68, 57, NULL),
(58, 1.79, 65.8, 58, NULL),
(59, 1.66, 89.9, 59, NULL),
(60, 1.69, 69.4, 60, NULL),
(61, 1.8, 89, 61, NULL),
(62, 1.8, 69.3, 62, NULL),
(63, 1.89, 69.1, 63, NULL),
(64, 1.89, 68, 64, NULL),
(65, 1.79, 89, 65, NULL),
(66, 1.89, 79.1, 66, NULL),
(67, 1.89, 69, 67, NULL),
(68, 1.69, 69.7, 68, NULL),
(69, 1.8, 69.8, 69, NULL),
(70, 1.89, 88.4, 70, NULL),
(71, 1.79, 64.3, 71, NULL),
(72, 1.89, 67, 72, NULL),
(73, 1.9, 65.1, 73, NULL),
(74, 1.81, 69, 74, NULL),
(75, 1.8, 89, 75, NULL),
(76, 1.69, 68.9, 76, NULL),
(77, 1.89, 64.3, 77, NULL),
(78, 1.79, 69.2, 78, NULL),
(79, 1.79, 67.7, 79, NULL),
(80, 1.8, 87.8, 80, NULL),
(81, 1.81, 69.6, 81, NULL),
(82, 1.69, 79.4, 82, NULL),
(83, 1.86, 69.5, 83, NULL),
(84, 1.7, 88.9, 84, NULL),
(85, 1.89, 67.2, 85, NULL),
(86, 1.69, 65, 86, NULL),
(87, 1.79, 69, 87, NULL),
(88, 1.87, 85.5, 88, NULL),
(89, 1.89, 69.3, 89, NULL),
(90, 1.62, 67.2, 90, NULL),
(91, 1.89, 68.7, 91, NULL),
(92, 1.99, 65.8, 92, NULL),
(93, 1.69, 89.5, 93, NULL),
(94, 1.89, 69.8, 94, NULL),
(95, 1.89, 67, 95, NULL),
(96, 1.79, 64.7, 96, NULL),
(97, 1.62, 69.8, 97, NULL),
(98, 1.89, 79, 98, NULL),
(99, 1.86, 77.6, 99, NULL),
(100, 1.82, 69.8, 100, NULL);

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
  UNIQUE KEY `abreviatura` (`abreviatura`),
  UNIQUE KEY `abreviatura_2` (`abreviatura`),
  UNIQUE KEY `abreviatura_3` (`abreviatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `abreviatura`) VALUES
(1, 'Júnior', 'J'),
(2, 'Sénior', 'S'),
(3, 'Especial', 'E');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

DROP TABLE IF EXISTS `equipos`;
CREATE TABLE IF NOT EXISTS `equipos` (
  `id` int(11) NOT NULL,
  `anioincripcion` year(4) NOT NULL,
  `idmanager` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKMANAGER` (`idmanager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id`, `anioincripcion`, `idmanager`, `nombre`) VALUES
(1, 2012, 1, 'EQUIPO 1'),
(2, 2012, 2, 'EQUIPO 2'),
(3, 2010, 3, 'EQUIPO 3');

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
(1, 'Las Mestas', 'Gijón', 1),
(2, 'Centro Ciudad', 'Gijón', 1),
(3, 'Parque San Francisco', 'Oviedo', 1),
(4, 'Puerto', 'Avilés', 1),
(5, 'Pabellon deportivo Aviles', 'Avilés', 0),
(6, 'Centro Ciudad', 'Oviedo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `managers`
--

DROP TABLE IF EXISTS `managers`;
CREATE TABLE IF NOT EXISTS `managers` (
  `id` int(11) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PERSONA` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `managers`
--

INSERT INTO `managers` (`id`, `direccion`, `telefono`, `idpersona`) VALUES
(1, 'jesusperez@gmail.com', '633072195', 1),
(2, 'carlosfernandez@gmail.com', '629590432', 2),
(3, 'luismartinez@gmail.com', '652441902', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metales`
--

DROP TABLE IF EXISTS `metales`;
CREATE TABLE IF NOT EXISTS `metales` (
  `id` int(11) NOT NULL,
  `pureza` float NOT NULL,
  `asignada` tinyint(1) NOT NULL DEFAULT 0,
  `idoro` int(11) DEFAULT NULL,
  `idplata` int(11) DEFAULT NULL,
  `idbronce` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participantes`
--

DROP TABLE IF EXISTS `participantes`;
CREATE TABLE IF NOT EXISTS `participantes` (
  `id` int(11) NOT NULL,
  `dorsal` int(3) NOT NULL,
  `calle` char(1) NOT NULL,
  `tiempo` time DEFAULT NULL,
  `penalizacion` tinyint(1) NOT NULL DEFAULT 0,
  `otros` varchar(500) DEFAULT NULL,
  `idprueba` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_prueba` (`idprueba`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinadores`
--

DROP TABLE IF EXISTS `patrocinadores`;
CREATE TABLE IF NOT EXISTS `patrocinadores` (
  `id` int(11) NOT NULL,
  `idresponsable` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `web` varchar(150) DEFAULT NULL,
  `dotacion` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `patrocinadores`
--

INSERT INTO `patrocinadores` (`id`, `idresponsable`, `nombre`, `web`, `dotacion`) VALUES
(1, 1, 'ALSA', 'www.alsa.es', 500),
(2, 2, 'Ayto. Gijón', 'www.gijon.es', 250),
(3, 3, 'Universidad de Oviedo', 'www.uniovi.es', 350.5),
(4, 4, 'CIFP LaLaboral', 'www.cifplalaboral.es', 255.99);

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
-- Estructura de tabla para la tabla `pruebas`
--

DROP TABLE IF EXISTS `pruebas`;
CREATE TABLE IF NOT EXISTS `pruebas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `fecha` date NOT NULL,
  `idlugar` int(11) NOT NULL,
  `individual` tinyint(1) NOT NULL,
  `idpatrocinador` int(11) NOT NULL,
  `idresultado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pruebas`
--

INSERT INTO `pruebas` (`id`, `nombre`, `fecha`, `idlugar`, `individual`, `idpatrocinador`, `idresultado`) VALUES
(1, 'Prueba1', '2022-06-10', 1, 1, 3, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsables`
--

DROP TABLE IF EXISTS `responsables`;
CREATE TABLE IF NOT EXISTS `responsables` (
  `id` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `telefonoprof` varchar(10) NOT NULL,
  `horaini` time DEFAULT NULL,
  `horafin` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `responsables`
--

INSERT INTO `responsables` (`id`, `idpersona`, `telefonoprof`, `horaini`, `horafin`) VALUES
(1, 1011, '902422202', '00:00:00', '23:59:00'),
(2, 1012, '985181105', '09:00:00', '18:00:00'),
(3, 1013, '985103000', '08:30:00', '20:00:00'),
(4, 1014, '985185503', '08:30:00', '10:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE IF NOT EXISTS `resultados` (
  `id` int(11) NOT NULL,
  `definitivo` tinyint(1) NOT NULL DEFAULT 0,
  `fechahora` datetime DEFAULT NULL,
  `idoro` int(11) DEFAULT NULL,
  `idplata` int(11) DEFAULT NULL,
  `idbronce` int(11) DEFAULT NULL,
  `idpuesto1` int(11) DEFAULT NULL,
  `idpuesto2` int(11) DEFAULT NULL,
  `idpuesto3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

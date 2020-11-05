create database dbtecnica;
use dbtecnica;

CREATE TABLE `documento` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(60) DEFAULT NULL,
  `fechahoracrea` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `fhoramodifica` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `Id_formato` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_formato` (`Id_formato`),
  CONSTRAINT `documento_ibfk_1` FOREIGN KEY (`Id_formato`) REFERENCES `formato` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE `formato` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_doc` varchar(60) DEFAULT NULL,
  `desc_documento` varchar(255) DEFAULT NULL,
  `fhoramodifica` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE `recorte` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(60) DEFAULT NULL,
  `fechahoracrea` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `fhoramodifica` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `Id_documento` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Id_documento` (`Id_documento`),
  CONSTRAINT `recorte_ibfk_1` FOREIGN KEY (`Id_documento`) REFERENCES `documento` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

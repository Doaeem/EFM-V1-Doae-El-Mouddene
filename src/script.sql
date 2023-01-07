create database if not exists dbGestionAppartements;
use dbGestionAppartements;

create table Rue
(
  code_rue int primary key auto_increment,
  nom_rue varchar(30)
);

create table Immeuble
(
  num_immeuble int primary key auto_increment,
  nb_etage_total int,
  code_rue int,
  FOREIGN KEY (code_rue) REFERENCES Rue(code_rue)
);
create table Etage
(
  num_etage int primary key auto_increment,
  nb_appartement_tot int,
 num_immeuble int,
  FOREIGN KEY (num_immeuble) REFERENCES Immeuble(num_immeuble)
);
create table Appartement
(
  lettre_appartement varchar(10) primary key,
  nb_pieces_total int,
 num_etage int,
  FOREIGN KEY (num_etage) REFERENCES Etage(num_etage)
);

insert into Rue values ( 1,"Wilaya");
insert into Rue values ( 2,"Boujarah");
insert into Rue values ( 3,"BabOkla" );
insert into Rue values ( 4,"SouknaWTaemir" );

insert into Immeuble values ( 1, 5,1);
insert into Immeuble values ( 2, 3,4);
insert into Immeuble values ( 3, 6,3);
insert into Immeuble values ( 4, 2,2);

insert into Etage values ( 1,2,1);
insert into Etage values ( 2,3,2);
insert into Etage values ( 3,4,3);
insert into Etage values ( 4,1,4);

insert into Appartement values( "A",6,1);
insert into Appartement values( "B",7,4);
insert into Appartement values( "C",2,3);
insert into Appartement values( "D",4,2);
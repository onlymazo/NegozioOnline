----------------------------------------UTENTE
drop if exists table utente cascade;
drop if exists table articolo cascade;
drop if exists table ordine cascade;
drop if exists table ordine_articolo cascade;
drop if exists table immagine cascade;

create table utente(
id_user int auto_increment,
nome varchar(30) not null,
nascita date not null,
username varchar(15) not null unique,
password varchar(2000) not null,
constraint p_iduser primary key(id_user)
);

create table articolo(
id_articolo int auto_increment,
marca varchar(30) not null,
modello varchar(30) not null,
prezzo numeric(8,2) not null,
constraint p_idarticolo primary key(id_articolo)
);

create table ordine(
id_ordine int auto_increment,
id_user int,
totale numeric(9,2) not null,
data date not null,
constraint p_idordine primary key(id_ordine),
constraint f_iduser foreign key(id_user) references utente(id_user) on delete cascade
);

create table ordine_articolo(
id_ordine int,
id_articolo int,
quantita int default 1,
constraint p_oa primary key(id_ordine, id_articolo),
constraint f_idordine foreign key(id_ordine) references ordine(id_ordine) on delete cascade,
constraint f_idarticolo foreign key(id_articolo) references articolo(id_articolo) on delete cascade
);

create table immagine(
id_immagine int primary key references articolo(id_articolo),
url varchar(50) not null,
descrizione varchar(500) not null
);

----------------------------------------AMMINISTRATORE
drop if exists table amministratore;
drop view report;

create table amministratore(
username varchar(15),
password varchar(2000) not null,
constraint p_admin_username primary key(username)
);

create view report as
select utente.id_user, email, ordine.id_ordine, totale, sum(quantita) as qta
from utente, ordine, articolo, ordine_articolo
where
ordine.id_ordine = ordine_articolo.id_ordine
and
articolo.id_articolo = ordine_articolo.id_articolo
and
utente.id_user = ordine.id_user
group by utente.id_user, email, ordine.id_ordine, totale
order by utente.id_user, ordine.id_ordine;
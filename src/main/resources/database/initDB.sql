create table if not exists roleuser(
                         id serial,
                         nameRole varchar(256) primary key
);

create table if not exists tagnews(
                        id serial primary key,
                        tagName varchar(256)
);

create table if not exists typeshow(
                         id serial primary key,
                         typeShowname varchar(256)
);

create table if not exists customer(
                         id serial primary key,
                         name varchar(256),
                         soname varchar(256),
                         username varchar(256),
                         password varchar(256),
                         email varchar(256),
                         rolename varchar(256) REFERENCES roleuser(nameRole) on delete cascade,
                         date_registration date
);

create table if not exists circusnews(
                           id serial primary key,
                           newsName varchar(256),
                           newsText varchar(1200),
                           date_publication date,
                           idAuthor int,
                            urllogonews varchar(500),
                           tagNews int REFERENCES tagnews(id) on delete cascade
);

create table if not exists circusshow(
                           id serial primary key,
                           name varchar(256),
                           describe varchar(1024),
                           urlPathLogoPhoto varchar(256),
                           countAvailableTicket INT,
                           dateShow date,
                           priceShow float4,
                           typeshow int REFERENCES typeshow(id) on delete cascade
);

create table tickets
(
    id            serial
        primary key,
    idshow        integer
        references circusshow,
    idcustomer    integer
        references customer,
    datebuy       date,
    "countTicket" integer,
    uuid_order    uuid,
    summa_order   double precision
);

create table if not exists circusteam(
                           id serial primary key,
                           name varchar(256),
                           soname varchar(256),
                           work_position varchar(256),
                           describe varchar(256),
                           link_facebook varchar(1024),
                           date_create date,
    urlphoto varchar
);

create table if not exists contact(
    id serial primary key,
    name varchar(256),
    soname varchar(256),
    email varchar(256),
    message varchar(1024),
    date_send date
);

create table testimonals
(
    id        serial
        primary key,
    name      varchar(256),
    soname    varchar(256),
    text      varchar,
    rating    integer,
    date_send date
);
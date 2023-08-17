create table carro (id serial not null, fecha_fabricacion timestamp(6) not null, marca varchar(255) not null, modelo varchar(255) not null, primary key (id));
create table empleado (id serial not null, matricula integer not null check (matricula>=0), nombre varchar(255) not null, primary key (id));
create table viaje (carro_id integer not null, empleado_id integer not null, id serial not null, fecha_entrega timestamp(6), fecha_retirada timestamp(6) not null, primary key (id));
alter table if exists viaje add constraint FKfstow6mr9cl7vbi6goa75a530 foreign key (carro_id) references carro;
alter table if exists viaje add constraint FK5qn3j4pji8xnsi789thi036ti foreign key (empleado_id) references empleado;

create table programs (
code varchar(20) primary key,
program_name varchar(60) 
);

create table courses (
id varchar(20) primary key,
course_name varchar(60) not null,
credits int not null,
program varchar(20), 
FOREIGN KEY (program) REFERENCES programs(code)
);

insert into programs value('1','Ingenieria de sistemas');
insert into programs value('2','Ingenieria industrial');
insert into programs value('3','Ingenieria telecomunicaciones');
insert into programs value('4','Ingenieria ambiental');
insert into programs value('5','Ingenieria electrica');

insert into courses value('cod1', 'Algebra y trigonometria', 4 , '1');
insert into courses value('cod2', 'Calculo diferencial', 5 , '1');
insert into courses value('cod3', 'Descubriendo la fisica', 4 , '1');
insert into courses value('cod4', 'Matematicas discretas', 4 , '1');
insert into courses value('cod5', 'Logica y representacion', 4 , '1');
insert into courses value('cod6', 'Introducción a la ingenieria', 2 , '1');
insert into courses value('cod7', 'Ingles 1', 0 , '1');
insert into courses value('cod8', 'Geometria vectorial', 4 , '1');
insert into courses value('cod9', 'Vivamos la universidad', 2 , '1');



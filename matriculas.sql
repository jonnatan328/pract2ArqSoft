create table student(
identification bigint primary key,
names varchar(50),
last_names varchar(50),
program varchar(50),
address varchar(20),
phone varchar(20),
stratum int
);

create table courses (
id varchar(20) primary key,
course_name varchar(60) not null,
credits int not null
);

create table enrolments(
id bigint primary key auto_increment,
student_identification bigint,
course_id varchar(20),
FOREIGN KEY (student_identification) REFERENCES student(identification),
FOREIGN KEY (course_id) REFERENCES courses(id)
);


insert into programs value('1','Ingenieria de sistemas');
insert into programs value('2','Ingenieria industrial');
insert into programs value('3','Ingenieria telecomunicaciones');
insert into programs value('4','Ingenieria ambiental');
insert into programs value('5','Ingenieria electrica');

insert into courses value('cod1', 'Algebra y trigonometria', 4 );
insert into courses value('cod2', 'Calculo diferencial', 5 );
insert into courses value('cod3', 'Descubriendo la fisica', 4 );
insert into courses value('cod4', 'Matematicas discretas', 4 );
insert into courses value('cod5', 'Logica y representacion', 4 );
insert into courses value('cod6', 'Introducción a la ingenieria', 2 );
insert into courses value('cod7', 'Ingles 1', 0 );
insert into courses value('cod8', 'Geometria vectorial', 4 );
insert into courses value('cod9', 'Vivamos la universidad', 2 );



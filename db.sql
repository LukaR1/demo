create table student
(
    id          serial
        constraint student_pk
            primary key,
    firstname   text,
    lastname    text,
    personal_no text,
    email       text,
    birth_date  date
);

alter table student
    owner to postgres;


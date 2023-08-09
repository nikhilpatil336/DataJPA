create table users (
       user_id integer not null auto_increment,
        age integer,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        salary double precision not null,
        primary key (user_id)
    )
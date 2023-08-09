  create table address (
       id integer not null auto_increment,
        building_name varchar(10) not null,
        city varchar(255),
        flat_no integer not null,
        pin_code integer not null,
        street_name varchar(10) not null,
        user_user_id integer,
        primary key (id)
    ) 
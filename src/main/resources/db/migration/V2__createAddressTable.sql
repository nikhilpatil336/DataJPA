create table address (
       id integer not null auto_increment,
        building_name varchar(255),
        city varchar(255),
        flat_no integer not null,
        pin_code integer not null,
        street_name varchar(255),
        user_id integer,
        primary key (id)
    ) 
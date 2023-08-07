create table user_degree (
       id integer not null auto_increment,
        expiry_date datetime(6),
        issue_date datetime(6),
        degree_id integer,
        user_user_id integer,
        primary key (id)
    )
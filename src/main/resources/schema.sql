CREATE TABLE IF NOT EXISTS fighter (
    id IDENTITY,
    name VARCHAR(30) NOT NULL,
    damage_per_hit INT NOT NULL,
    health INT NOT NULL,
    resistance DOUBLE NOT NULL,
    anime_from VARCHAR(30) NOT NULL,
    created_at VARCHAR(30) NOT NULL
);

-- create table if not exists fighter (
--     id identity,
--     name varchar(50) not null,
--     damage_per_hit int not null,
--     health int not null,
--     resistance double not null,
--     anime_from varchar(50) not null,
--     created_at varchar(50) not null
-- );
CREATE TABLE users
(
    id serial NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    email character varying(255) NOT NULL,
    phone character varying(127),
    about text,
    PRIMARY KEY (id)
);

CREATE TABLE available_users
(
    id serial NOT NULL,
    user_id bigint NOT NULL,
    bar_name character varying(255),
    longitude double precision,
    latitude double precision,
    geometry geometry,
    last_seen timestamp,
    PRIMARY KEY (id),
    CONSTRAINT available_users_fk FOREIGN KEY ("user_id")
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);
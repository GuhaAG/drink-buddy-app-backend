CREATE TABLE buddy_profile
(
    id serial NOT NULL,
    "firstName" character varying(255),
    "lastName" character varying(255),
    email character varying(255) NOT NULL,
    phone character varying(127),
    "aboutMe" text,
    PRIMARY KEY (id)
);

CREATE TABLE available
(
    id serial NOT NULL,
    "buddyId" bigint NOT NULL,
    "barName" character varying(255),
    longitude double precision,
    latitude double precision,
    "lastSeen" bigint,
    PRIMARY KEY (id),
    CONSTRAINT buddy_fk FOREIGN KEY ("buddyId")
        REFERENCES buddy_profile (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);
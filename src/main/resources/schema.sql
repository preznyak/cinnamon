CREATE TABLE ROOM (
    ROOM_ID BIGSERIAL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    ROOM_NUMBER VARCHAR(5) NOT NULL UNIQUE,
    BED_INFO VARCHAR(5) NOT NULL,
    CAPACITY INTEGER NOT NULL,
    TYPE VARCHAR(10) NOT NULL,
    PRICE_PER_NIGHT INTEGER NOT NULL
);

CREATE TABLE GUEST (
    GUEST_ID BIGSERIAL PRIMARY KEY,
    LAST_NAME VARCHAR(50),
    FIRST_NAME VARCHAR(50),
    EMAIL_ADDRESS VARCHAR(50),
    COUNTRY VARCHAR(50),
    ADDRESS VARCHAR(50),
    STATE VARCHAR(50),
    PHONE_NUMBER VARCHAR(50),
    GENDER VARCHAR(10)
);

CREATE TABLE RESERVATION (
    RESERVATION_ID BIGSERIAL PRIMARY KEY,
    ROOM_ID INTEGER NOT NULL,
    GUEST_ID INTEGER NOT NULL,
    RES_DATE_START DATE,
    RES_DATE_END DATE,
    PRICE DOUBLE
);

CREATE TABLE DISCOUNT (
    DISCOUNT_ID BIGSERIAL PRIMARY KEY,
    START_OF_SALE_PERIOD DATE,
    END_OF_SALE_PERIOD DATE,
    DISCOUNT_PERCENTAGE INTEGER NOT NULL
);
drop table if exists PRICE;

create table PRICE (
        PRICE_ID BIGINT not null AUTO_INCREMENT,
        BRAND_ID int NOT NULL,
        START_DATE TIMESTAMP NOT NULL,
        END_DATE TIMESTAMP NOT NULL,
        PRICE_LIST int NOT NULL,
        PRODUCT_ID BIGINT NOT NULL,
        PRIORITY int NOT NULL,
        PRICE_SALE DOUBLE PRECISION NOT NULL,
        CURRENCY_CODE varchar(5),
        CREATE_DATE TIMESTAMP,
        UPDATE_DATE TIMESTAMP,
        USERNAME varchar(50),
        PRIMARY KEY (PRICE_ID)
    );
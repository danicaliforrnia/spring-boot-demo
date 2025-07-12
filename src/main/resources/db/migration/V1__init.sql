CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE Gender as enum ('male', 'female');

CREATE TABLE clan
(
    id   VARCHAR(50) PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE player_profile
(
    id                     UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    credential             VARCHAR(255) NOT NULL,
    level                  INTEGER      NOT NULL,
    xp                     INTEGER          DEFAULT 0,
    total_playtime_minutes INTEGER          DEFAULT 0,
    country_code           VARCHAR(10)  NOT NULL,
    language               VARCHAR(10),
    birthdate              TIMESTAMP,
    gender                 Gender,
    total_spent            INTEGER          DEFAULT 0,
    total_refund           INTEGER          DEFAULT 0,
    total_transactions     INTEGER          DEFAULT 0,
    clan_id                VARCHAR(50)  NOT NULL
        CONSTRAINT fk_player_clan REFERENCES clan (id),
    created                TIMESTAMP    NOT NULL,
    modified               TIMESTAMP    NOT NULL,
    last_session           TIMESTAMP,
    last_purchase          TIMESTAMP
);

CREATE TABLE player_device
(
    id        SERIAL PRIMARY KEY,
    player_id UUID REFERENCES player_profile (id) ON DELETE CASCADE,
    model     VARCHAR(255),
    carrier   VARCHAR(255),
    firmware  VARCHAR(255)
);

CREATE TABLE inventory_item
(
    player_id UUID
        CONSTRAINT fk_inventory_item_player_profile_id
            REFERENCES player_profile (id)
            ON DELETE CASCADE,
    item_code VARCHAR(255) NOT NULL,
    quantity  INTEGER DEFAULT 0,
    PRIMARY KEY (player_id, item_code)
);
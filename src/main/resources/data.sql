DELETE
FROM player_device;
DELETE
FROM inventory_item;
DELETE
FROM player_profile;
DELETE
FROM clan;

INSERT INTO clan (id, name)
VALUES ('123456', 'Hello world clan');

INSERT INTO player_profile (id,
                            credential,
                            xp,
                            level,
                            total_spent,
                            total_refund,
                            total_transactions,
                            total_playtime_minutes,
                            country_code,
                            language,
                            birthdate,
                            gender,
                            clan_id,
                            created,
                            modified,
                            last_session,
                            last_purchase)
VALUES ('123e4567-e89b-12d3-a456-426614174000',
        'apple_credential',
        1000,
        3,
        400,
        0,
        5,
        144,
        'CA',
        'fr',
        '2000-01-10 13:37:17Z',
        'male',
        '123456',
        '2021-01-10 13:37:17Z',
        '2021-01-23 13:37:17Z',
        '2021-01-23 13:37:17Z',
        '2021-01-23 13:37:17Z');

INSERT INTO player_device (player_id, model, carrier, firmware)
VALUES ('123e4567-e89b-12d3-a456-426614174000',
        'apple iphone 11',
            'vodafone',
        '123');

INSERT INTO inventory_item (player_id, item_code, quantity)
VALUES ('123e4567-e89b-12d3-a456-426614174000', 'cash', 123),
       ('123e4567-e89b-12d3-a456-426614174000', 'coins', 123),
       ('123e4567-e89b-12d3-a456-426614174000', 'item_1', 1),
       ('123e4567-e89b-12d3-a456-426614174000', 'item_34', 3),
       ('123e4567-e89b-12d3-a456-426614174000', 'item_55', 2)

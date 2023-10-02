CREATE TABLE card_holder (
        member_id SERIAL PRIMARY KEY NOT NULL,
        member_name VARCHAR(255),
        member_date_of_birth DATE NOT NULL
);
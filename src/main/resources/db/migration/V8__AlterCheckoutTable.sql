ALTER TABLE checkout
    ADD COLUMN member_id INT,
    ADD COLUMN copy_id INT,

    ADD CONSTRAINT fk_member_id
        FOREIGN KEY (member_id)
            REFERENCES card_holder(member_id),

    ADD CONSTRAINT fk_copy_id
        FOREIGN KEY (copy_id)
            REFERENCES copies(copy_id);
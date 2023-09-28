ALTER TABLE checkout
    ADD CONSTRAINT fk_member_id
    FOREIGN KEY (id)
    REFERENCES member (id);
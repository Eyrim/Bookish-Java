ALTER TABLE checkout
    ADD CONSTRAINT fk_checkout_id
    FOREIGN KEY (id)
    REFERENCES copy (id);
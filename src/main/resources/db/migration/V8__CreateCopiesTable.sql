ALTER TABLE copy
ADD CONSTRAINT fk_copy_id
    FOREIGN KEY (id)
    REFERENCES book (id);
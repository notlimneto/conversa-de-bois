CREATE TABLE user_roles (
    user_id INTEGER NOT NULL,
    user_role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id, user_role),
    CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES "user" ON DELETE CASCADE
);
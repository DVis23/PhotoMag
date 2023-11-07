CREATE TABLE IF NOT EXISTS albums (
                id UUID PRIMARY KEY,
                name VARCHAR(255),
                user_id UUID NOT NULL,
                FOREIGN KEY (user_id) REFERENCES users(id)
                );
CREATE TABLE IF NOT EXISTS images (
                id UUID PRIMARY KEY,
                location VARCHAR(255),
                album_id UUID NOT NULL,
                FOREIGN KEY (album_id) REFERENCES albums(id)
                );
SET search_path TO mgusr;
CREATE SCHEMA IF NOT EXISTS mgusr;

CREATE TABLE IF NOT EXISTS user_dashboard (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    title VARCHAR(255),
    description TEXT,
    rating INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
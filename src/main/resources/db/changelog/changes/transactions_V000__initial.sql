CREATE TABLE categories
(
    id   BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name VARCHAR(255) UNIQUE NOT NULL,
    created_at timestamptz DEFAULT current_timestamp,
    updated_at timestamptz DEFAULT current_timestamp
);

CREATE TABLE transactions
(
    id          BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    type        VARCHAR(10)    NOT NULL
        CHECK (type IN ('INCOME', 'EXPENSE')),
    user_id     BIGINT         NOT NULL,
    category_id BIGINT         NOT NULL,
    date        DATE           NOT NULL,
    amount      DECIMAL(12, 2) NOT NULL,
    description VARCHAR(1000),
    created_at timestamptz DEFAULT current_timestamp,
    updated_at timestamptz DEFAULT current_timestamp,

    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories (id)
);
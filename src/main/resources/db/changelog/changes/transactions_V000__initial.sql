CREATE TABLE categories
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE transactions
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type        VARCHAR(10)    NOT NULL
        CHECK (type IN ('INCOME', 'EXPENSE')),
    user_id     BIGINT         NOT NULL,
    category_id BIGINT         NOT NULL,
    date        DATE           NOT NULL,
    amount      DECIMAL(12, 2) NOT NULL,
    description VARCHAR(1000),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);
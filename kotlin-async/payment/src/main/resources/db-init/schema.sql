CREATE TABLE IF NOT EXISTS TB_PROD (
    id          BIGINT PRIMARY KEY,
    name        VARCHAR(300),
    price       BIGINT,
    created_at  TIMESTAMP,
    updated_at   TIMESTAMP
);

CREATE TABLE IF NOT EXISTS TB_ORDER (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT,
    description     VARCHAR(2000),
    amount          BIGINT,
    pg_order_id     VARCHAR(32),
    pg_key          VARCHAR(49),
    pg_status       VARCHAR(20),
    retry_count     INT,
    created_at      TIMESTAMP,
    updated_at       TIMESTAMP
);

CREATE TABLE IF NOT EXISTS TB_PROD_IN_ORDER (
    order_id       BIGINT,
    prod_id        BIGINT,
    price          BIGINT,
    quantity       INT,
    seq            SERIAL UNIQUE,
    created_at     TIMESTAMP,
    updated_at      TIMESTAMP,
    PRIMARY KEY (order_id, prod_id)
);


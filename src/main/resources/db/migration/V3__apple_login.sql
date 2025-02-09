CREATE TABLE apple_user_info (
    uid BINARY(16) NOT NULL,
    apple_id VARCHAR(60) NOT NULL,
    email VARCHAR(100) NULL,

    family_name VARCHAR(50) NULL,
    given_name VARCHAR(50) NULL,
    middle_name VARCHAR(50) NULL,
    name_prefix VARCHAR(50) NULL,
    name_suffix VARCHAR(50) NULL,
    nickname VARCHAR(50) NULL,
    nonce VARCHAR(50) NULL,
    real_user_status TINYINT NULL,
    state VARCHAR(255) NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_apple_user_info PRIMARY KEY (uid),
    CONSTRAINT uc_apple_user_info_apple_id UNIQUE (apple_id),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

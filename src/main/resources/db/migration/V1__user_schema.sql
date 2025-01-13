CREATE TABLE IF NOT EXISTS user (
    uid BINARY(16) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    language VARCHAR(5) NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_user PRIMARY KEY (uid),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_info (
   uid BINARY(16) NOT NULL,
   gender ENUM('MALE', 'FEMALE', 'OTHER') DEFAULT NULL,
   year_of_birth SMALLINT NULL,
   occupation VARCHAR(255) NULL,
   interest VARCHAR(255) NULL,
   level ENUM('A', 'B', 'C', 'D', 'E') DEFAULT NULL,
   purpose VARCHAR(255) NULL,
   language_second VARCHAR(5) NULL,
   study_place VARCHAR(10) NULL,
   mbti CHAR(4) NULL,

   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL,

   CONSTRAINT pk_user_info PRIMARY KEY (uid),
   INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS google_user_info (
    uid BINARY(16) NOT NULL,
    google_id VARCHAR(50) NOT NULL,
    email VARCHAR(100) NULL,
    name VARCHAR(50) NULL,
    picture VARCHAR(100) NULL,
    locale VARCHAR(11) NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_google_user_info PRIMARY KEY (uid),
    CONSTRAINT uc_google_user_info_googleid UNIQUE (google_id),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_point (
    uid BINARY(16) NOT NULL,
    amount INT NOT NULL DEFAULT 0,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_user_point PRIMARY KEY (uid),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_point_log (
    id BINARY(16) NOT NULL,
    uid BINARY(16) NOT NULL,
    transaction_type ENUM('DAILY_STUDY') NOT NULL,
    amount INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_user_point_log PRIMARY KEY (id),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_notification_log (
   id BINARY(16) NOT NULL,
   uid BINARY(16) NOT NULL,
   title VARCHAR(255) NOT NULL,
   description VARCHAR(255) NOT NULL,
   status ENUM('SUCCESS', 'FAIL', 'SCHEDULE', 'CANCEL') NOT NULL,

   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL,

   CONSTRAINT pk_user_notification_log PRIMARY KEY (id),
   INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_notification (
   uid BINARY(16) NOT NULL,
   notification_preference ENUM('DAILY_STUDY') NOT NULL,
   cron VARCHAR(50),

   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL,

   CONSTRAINT pk_user_notification PRIMARY KEY (uid),
   INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

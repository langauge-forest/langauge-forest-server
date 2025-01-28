CREATE TABLE user (
    uid BINARY(16) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    language VARCHAR(5) NOT NULL,
    profile_image VARCHAR(100) NULL;

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_user PRIMARY KEY (uid),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_info (
   uid BINARY(16) NOT NULL,
   gender varchar(10) DEFAULT NULL,
   year_of_birth SMALLINT NULL,
   occupation VARCHAR(255) NULL,
   interest VARCHAR(255) NULL,
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

CREATE TABLE google_user_info (
    uid BINARY(16) NOT NULL,
    google_id VARCHAR(50) NOT NULL,
    email VARCHAR(100) NULL,
    name VARCHAR(50) NULL,
    picture VARCHAR(255) NULL,
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
    transaction_type varchar(20) NOT NULL,
    amount INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_user_point_log PRIMARY KEY (id),
    INDEX idx_deleted_at (deleted_at),
    INDEX idx_uid (uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_notification_log (
   id BINARY(16) NOT NULL,
   uid BINARY(16) NOT NULL,
   title VARCHAR(255) NOT NULL,
   description VARCHAR(255) NOT NULL,
   status varchar(10) NOT NULL,

   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL,

   CONSTRAINT pk_user_notification_log PRIMARY KEY (id),
   INDEX idx_deleted_at (deleted_at),
   INDEX idx_uid (uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_notification (
   uid BINARY(16) NOT NULL,
   notification_preference varchar(20) NOT NULL,
   cron VARCHAR(50),

   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL,

   CONSTRAINT pk_user_notification PRIMARY KEY (uid),
   INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_study_info (
   id BINARY(16) NOT NULL,
   uid BINARY(16) NOT NULL,

   voice_type varchar(5) NOT NULL,
   level varchar(5) NOT NULL,
   language varchar(5) NOT NULL,
   streak_days SMALLINT NOT NULL,
   sentence_amount TINYINT NOT NULL,

   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   deleted_at DATETIME NULL,

   CONSTRAINT pk_user_study_info PRIMARY KEY (id),
   INDEX idx_deleted_at (deleted_at),
   INDEX idx_uid (uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

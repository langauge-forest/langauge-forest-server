CREATE TABLE study (
    id BINARY(16) NOT NULL,
    uid BINARY(16) NOT NULL,

    user_study_info_id BINARY(16) NOT NULL,
    voice_type VARCHAR(5) NOT NULL,
    level VARCHAR(5) NOT NULL,
    sentence_amount TINYINT NOT NULL,
    language VARCHAR(5) NOT NULL,
    start_question VARCHAR(255) NOT NULL,
    input_type VARCHAR(10) NOT NULL,

    story TEXT NULL,
    story_voice_path VARCHAR(2048) NULL,
    average_score DOUBLE PRECISION NOT NULL DEFAULT 0,
    study_status VARCHAR(20) NOT NULL,
    point TINYINT NOT NULL DEFAULT 0,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_study PRIMARY KEY (id),
    INDEX idx_deleted_at (deleted_at),
    INDEX idx_uid (uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE study_practice (
    id BINARY(16) NOT NULL,

    study_id BINARY(16) NOT NULL,
    problem_number TINYINT NOT NULL,
    problem TEXT NOT NULL,
    correct_answer TEXT NULL,
    my_answer TEXT NULL,
    my_answer_voice_path VARCHAR(2048) NULL,
    tip TEXT NULL,
    score TINYINT NOT NULL DEFAULT 0,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_study_practice PRIMARY KEY (id),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE study_summary (
    id BINARY(16) NOT NULL,

    study_id BINARY(16) NOT NULL,
    summary VARCHAR(100),
    message VARCHAR(255),
    emoji VARCHAR(10),
    tags VARCHAR(200),
    selected_tag VARCHAR(50),

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_study_summary PRIMARY KEY (id),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE study_practice_log (
    id BINARY(16) NOT NULL,

    study_practice_id BINARY(16) NOT NULL,
    problem TEXT NOT NULL,
    my_answer TEXT NOT NULL,
    tip TEXT NOT NULL,
    score TINYINT NOT NULL DEFAULT 0,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL,

    CONSTRAINT pk_study_practice_log PRIMARY KEY (id),
    INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
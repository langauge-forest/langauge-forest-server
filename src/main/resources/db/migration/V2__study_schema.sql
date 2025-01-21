CREATE TABLE study (
                       id BINARY(16) NOT NULL,
                       uid BINARY(16) NOT NULL,

                       start_question VARCHAR(255) NOT NULL,
                       start_question_voice_path VARCHAR(500) NOT NULL,

                       voice_type ENUM('A', 'B', 'C') NOT NULL,
                       level ENUM('A', 'B', 'C', 'D', 'E') NOT NULL,
                       sentence_amount SMALLINT NOT NULL,
                       input_type ENUM('SPEAKING', 'WRITING') NOT NULL,

                       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       deleted_at DATETIME NULL,

                       CONSTRAINT pk_user PRIMARY KEY (uid),
                       INDEX idx_deleted_at (deleted_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
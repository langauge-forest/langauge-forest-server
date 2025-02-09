ALTER TABLE user_notification
    MODIFY COLUMN cron VARCHAR(50) NOT NULL;

ALTER TABLE user_notification
    ADD COLUMN is_active BOOLEAN NOT NULL DEFAULT TRUE,
    ADD INDEX idx_is_active (is_active);
ALTER TABLE user_notification
    ADD CONSTRAINT uq_user_notification UNIQUE (uid, notification_preference);
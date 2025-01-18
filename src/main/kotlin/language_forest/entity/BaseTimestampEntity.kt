package language_forest.entity

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class) // 리스너를 추가합니다.
abstract class BaseTimestampEntity {

    @CreatedDate
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime;

    @LastModifiedDate
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
}

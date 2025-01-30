package language_forest.entity

import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import org.hibernate.annotations.FilterDef
import org.hibernate.annotations.ParamDef
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@FilterDef(
    name = "softDeleteFilter",
    parameters = [
        ParamDef(name = "isDeleted", type = Boolean::class)
    ]
)
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimestampEntity {

    @CreatedDate
    @Column(name = "created_at", updatable = false, insertable = false) // DB 기본값 사용
    lateinit var createdAt: LocalDateTime

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false) // DB 기본값 사용
    lateinit var updatedAt: LocalDateTime

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null

    fun softDelete() {
        this.deletedAt = LocalDateTime.now()
    }

    fun isDeleted(): Boolean {
        return deletedAt != null
    }
}
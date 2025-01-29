package language_forest.repository.softDelete

import java.time.LocalDateTime

interface SoftDeleteRepository<T, ID> {
    fun softDeleteById(id: ID, deletedAt: LocalDateTime = LocalDateTime.now())
    fun softDeleteByUid(uid: ID, deletedAt: LocalDateTime = LocalDateTime.now())
    fun softDeleteByField(fieldName: String, fieldValue: ID, deletedAt: LocalDateTime = LocalDateTime.now())
}
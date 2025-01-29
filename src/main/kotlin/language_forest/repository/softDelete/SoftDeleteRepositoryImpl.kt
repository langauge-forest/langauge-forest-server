package language_forest.repository.softDelete

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import language_forest.entity.BaseTimestampEntity
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import org.springframework.stereotype.Repository

@Repository
class SoftDeleteRepositoryImpl<T : BaseTimestampEntity, ID>(
    private val entityClass: Class<T>,
    @PersistenceContext private val entityManager: EntityManager
) : SoftDeleteRepository<T, ID> {

    @Transactional
    override fun softDeleteById(id: ID, deletedAt: LocalDateTime) {
        entityManager.createQuery(
            "UPDATE ${entityClass.simpleName} e SET e.deletedAt = :deletedAt WHERE e.id = :id"
        ).setParameter("deletedAt", deletedAt)
            .setParameter("id", id)
            .executeUpdate()
    }

    @Transactional
    override fun softDeleteByUid(uid: ID, deletedAt: LocalDateTime) {
        entityManager.createQuery(
            "UPDATE ${entityClass.simpleName} e SET e.deletedAt = :deletedAt WHERE e.uid = :uid"
        ).setParameter("deletedAt", deletedAt)
            .setParameter("uid", uid)
            .executeUpdate()
    }

    @Transactional
    override fun softDeleteByField(fieldName: String, fieldValue: ID, deletedAt: LocalDateTime) {
        entityManager.createQuery(
            "UPDATE ${entityClass.simpleName} e SET e.deletedAt = :deletedAt WHERE e.$fieldName = :fieldValue"
        ).setParameter("deletedAt", deletedAt)
            .setParameter("fieldValue", fieldValue)
            .executeUpdate()
    }
}
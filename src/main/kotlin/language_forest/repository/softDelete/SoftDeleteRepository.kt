package language_forest.repository.softDelete

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@NoRepositoryBean
interface SoftDeleteRepository<T, ID> {

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deletedAt = :deletedAt WHERE e.id = :id")
    fun softDeleteById(id: ID, deletedAt: LocalDateTime = LocalDateTime.now())

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deletedAt = :deletedAt WHERE e.uid = :uid")
    fun softDeleteByUid(uid: ID, deletedAt: LocalDateTime = LocalDateTime.now())
}
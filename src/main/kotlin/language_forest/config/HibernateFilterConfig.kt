package language_forest.config

import jakarta.persistence.EntityManager
import org.hibernate.Session
import org.springframework.stereotype.Component

@Component
class HibernateFilterConfig(
    private val entityManager: EntityManager
) {

    fun enableSoftDeleteFilter() {
        entityManager.unwrap(Session::class.java)
            .enableFilter("softDeleteFilter")        // 필터 켜기
            .setParameter("isDeleted", false)        // 파라미터 지정 (여기서는 "deleted_at IS NULL"만 쓰므로 크게 의미는 없음)
    }

    fun disableSoftDeleteFilter() {
        entityManager.unwrap(Session::class.java)
            .disableFilter("softDeleteFilter")       // 필터 끄기
    }
}
package language_forest.repository.softDelete

import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

interface JpaRepositoryWithSoftDelete<T, ID : Serializable> : JpaRepository<T, ID>, SoftDeleteRepository<T, ID>
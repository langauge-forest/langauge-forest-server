package language_forest.repository.softDelete

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface JpaRepositoryWithSoftDelete<T, ID : Serializable> : JpaRepository<T, ID>, SoftDeleteRepository<T, ID>
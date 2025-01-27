package language_forest.transformer

import language_forest.entity.UserPointEntity
import language_forest.generated.model.BaseUserPoint

fun UserPointEntity.toBaseUserPoint(): BaseUserPoint {
    return BaseUserPoint(
        uid = this.uid,
        amount = this.amount
    )
}
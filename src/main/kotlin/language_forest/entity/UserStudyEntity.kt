package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.LevelEnum
import language_forest.generated.model.NotificationEnum
import org.hibernate.annotations.UuidGenerator
import java.util.*


@Entity
@Table(name = "user_study")
open class UserStudyEntity(
    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "BINARY(16)")
    val id: UUID = UUID(0, 0),

    @Column(name = "uid", columnDefinition = "BINARY(16)", nullable = false)
    val uid: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "level", columnDefinition = "ENUM('A','B','C','D','E')")
    var level: LevelEnum,

    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type", columnDefinition = "ENUM")
    var voiceType:

    @Column(name = "sentence_amount")
    var sentenceAmount: Short,

    @Enumerated(EnumType.STRING)
    @Column(name = "input_type", columnDefinition = "ENUM",)
    val inputType:






) : BaseTimestampEntity()
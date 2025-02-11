package language_forest.transformer

import language_forest.generated.model.LanguageEnum
import language_forest.generated.model.LevelEnum


fun String.toLanguageEnum(): LanguageEnum {
    val defaultLanguageEnum = LanguageEnum.EN

    val languageMapping = mapOf(
        "ko-KR" to LanguageEnum.KO, "ko" to LanguageEnum.KO, "KR" to LanguageEnum.KO,
        "en-US" to LanguageEnum.EN, "en" to LanguageEnum.EN, "US" to LanguageEnum.EN,
        "fr-FR" to LanguageEnum.FR, "fr" to LanguageEnum.FR, "FR" to LanguageEnum.FR,
        "es-ES" to LanguageEnum.ES, "es" to LanguageEnum.ES, "ES" to LanguageEnum.ES,
        "de-DE" to LanguageEnum.DE, "de" to LanguageEnum.DE, "DE" to LanguageEnum.DE,
        "ja-JP" to LanguageEnum.JA, "ja" to LanguageEnum.JA, "JP" to LanguageEnum.JA,
        "zh-CN" to LanguageEnum.ZH, "zh" to LanguageEnum.ZH, "CN" to LanguageEnum.ZH
    )

    val normalized = this.split("-")[0].uppercase() // 'ko-KR' → 'KO'
    return languageMapping[this] ?: LanguageEnum.values().find { it.value == normalized } ?: defaultLanguageEnum
}

fun LanguageEnum.toLanguageString(): String {
    val languageMapping = mapOf(
        LanguageEnum.KO to "한국어",
        LanguageEnum.EN to "영어",
        LanguageEnum.FR to "프랑스어",
        LanguageEnum.ES to "스페인어",
        LanguageEnum.DE to "독일어",
        LanguageEnum.JA to "일본어",
        LanguageEnum.ZH to "중국어"
    )

    return requireNotNull(languageMapping[this]) { "Language not found for key: $this" }
}

fun LevelEnum.toLevelString(): String {
    val levelMapping = mapOf(
        LevelEnum.A to "3단어",
        LevelEnum.B to "6단어",
        LevelEnum.C to "9단어",
        LevelEnum.D to "12단어",
        LevelEnum.E to "15단어"
    )

    return requireNotNull(levelMapping[this]) { "Level not found for key: $this" }
}
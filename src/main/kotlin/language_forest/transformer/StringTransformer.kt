package language_forest.transformer

import language_forest.generated.model.LanguageEnum


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
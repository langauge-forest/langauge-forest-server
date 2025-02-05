package language_forest.scheduler

import language_forest.api.study.StudyService
import language_forest.api.user.UserService
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId

@Component
@EnableScheduling
class StreakScheduler (
    val studyService: StudyService,
    val userService: UserService
) {
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    fun updateStreak() {
        val tmpTimezone = "Asia/Seoul"
        val utcNow = LocalDateTime.now()
        val yesterday = utcNow.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of(tmpTimezone)).toLocalDate().minusDays(1)

        val studyList = studyService.findAllStudy()
        studyList.forEach { study ->
            val uid = study.uid
            if (!studyService.existsByUidAndCreatedAtDate(uid, yesterday, tmpTimezone)) {
                val userStudyInfo = userService.getUserStudyInfoByUid(uid)?: throw IllegalArgumentException("user study info not found")
                userStudyInfo.streakDays = 0
                userService.saveUserStudyInfo(userStudyInfo)
            }
        }
    }
}
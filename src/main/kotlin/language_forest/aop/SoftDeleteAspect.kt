package language_forest.aop

import language_forest.config.HibernateFilterConfig
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class SoftDeleteAspect(
    private val hibernateFilterConfig: HibernateFilterConfig
) {

    // (1) 방법 1: 모든 @Transactional 메서드 실행 전 적용
    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    fun applySoftDeleteFilter() {
        hibernateFilterConfig.enableSoftDeleteFilter()
    }

    // (2) 방법 2: 패키지 범위를 지정해서 적용할 수도 있음
    // @Before("execution(* com.example..*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
    // fun applySoftDeleteFilter2() {
    //     hibernateFilterConfig.enableSoftDeleteFilter()
    // }
}
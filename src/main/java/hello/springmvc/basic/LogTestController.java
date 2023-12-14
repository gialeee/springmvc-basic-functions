package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    // private final Logger log = LoggerFactory.getLogger(getClass());      -> 롬복의 @Slf4j와 동일
    // private static final Logger log = LoggerFactory.getLogger(XXX.class) -> 이렇게도 로그 선언 가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);  // 결과: name = Spring
        // 로깅하면 단순 프린트보다 더 많은 정보가 찍힘
        // LEVEL: trace < debug < info < warn < info 
        // 프로젝트/패키지의 로그 레벨 `application.properties`에서 설정 가능
        // 개발 서버 - debug / 운영 서버 - info
        log.trace("trace log={}", name);
        log.trace("trace log=" + name); // 이렇게 로깅하면 안 됨! Java 언어 특성상 "연산"을 하게 되면서 메모리도 할당하고, 사용되지 않는 로그를 위한 연산 발생 가능, 불필요한 리소스 사용 발생 가능
        log.debug("debug log={}", name);
        log.info("info log={}", name);         // 결과: 2023-12-14T10:33:43.573+09:00  INFO 4924 --- [nio-8080-exec-1] h.springmvc.basic.LogTestController      : info log=Spring
        log.warn("warn log={}", name);         // 결과: 2023-12-14T10:37:19.452+09:00  WARN 1380 --- [nio-8080-exec-7] h.springmvc.basic.LogTestController      : warn log=Spring
        log.error("error log={}", name);

        return "ok";
        // @RestController의 반환값이 String인 경우 HTTP 메시지 바디에 바로 입력함 (@ResponseBody 참고)
        // cf) @Controller의 반환값이 String인 경우 뷰 이름으로 인식됨 -> 뷰를 찾고 뷰가 랜더링됨
    }
}

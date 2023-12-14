package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping({"/hello-basic", "/hello-go"}) // "/hello-basic" URL 호출이 오면 메서드가 실행되도록 매핑 (URL 배열로 제공 가능)
    public String helloBasic() {
        log.info("helloBasic");

        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userID -> @PathVariable userId
     * mapping/userA
     */
    @GetMapping("/mapping/{userId}") // URL경로를 템플릿화 가능
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);

        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode"
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"
     * params={"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mapping param");

        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * consumes={"application/json","text/*"}
     * consumes=MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-param", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mapping consumes");

        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces="text/html"
     * produces="!text/html"
     * produces="text/*"
     * produces="*\/*"
     */
    @PostMapping(value = "/mapping-param", produces = MediaType.TEXT_HTML_VALUE) // 맞지 않을 경우 HTTP 406 코드 반환
    public String mappingProduces() {
        log.info("mapping consumes");

        return "ok";
    }
}

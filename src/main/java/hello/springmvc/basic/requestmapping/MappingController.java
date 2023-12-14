package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

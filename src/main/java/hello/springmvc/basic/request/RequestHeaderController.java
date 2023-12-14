package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie
                          ) {
        log.info("request={}", request);       // request=org.apache.catalina.connector.RequestFacade@46979417
        log.info("response={}", response);     // response=org.apache.catalina.connector.ResponseFacade@6b99eb09
        log.info("httpMethod={}", httpMethod); // httpMethod=GET
        log.info("locale={}", locale);         // locale=ko
        log.info("headerMap={}", headerMap);   // headerMap={host=[localhost:8080], connection=[keep-alive], sec-ch-ua=["Not_A Brand";v="8", "Chromium";v="120", "Microsoft Edge";v="120"], sec-ch-ua-mobile=[?0], sec-ch-ua-platform=["Windows"], upgrade-insecure-requests=[1], user-agent=[Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0], accept=[text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7], sec-fetch-site=[none], sec-fetch-mode=[navigate], sec-fetch-user=[?1], sec-fetch-dest=[document], accept-encoding=[gzip, deflate, br], accept-language=[ko,en;q=0.9,en-US;q=0.8]}
        log.info("header host={}", host);      // header host=localhost:8080
        log.info("myCookie={}", cookie);       // myCookie=null

        return "ok";
    }
}

package com.dlddy.book.springboot.web;

import com.dlddy.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다. SpringRunner라는 스프링 실행자를 사용. 스프링부트테스트-JUnit 연결자 역할
@WebMvcTest(controllers = HelloController.class) //Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired //Bean 주입
    private MockMvc mvc; //web API(GET, POST 등) 테스트시 사용

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) //mvc.perform의 결과를 검증합니다. HTTP Header의 statu가 200인지 아닌지 검증
                .andExpect(content().string(hello)); //Controller에서 "hello"를 리턴하는게 맞는지 검증
    }

}

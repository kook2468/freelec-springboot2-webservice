package com.dlddy.book.springboot.web.dto;

import lombok.Getter;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokFuncTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //asertj라는 테스트 검증 라이브러리의 검증 메소드 / isEqualTo:assertj의 동등 비교 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}

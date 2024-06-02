package com.sparta.crud_pro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

// 데이터 전송 객체


@Getter
/**
 *  클래스의 모든 필드에 대한 getter 메서드를 자동 생성
 */
@AllArgsConstructor
/**
 * public Schedule(Long id, String name, String description) {
 *     this.id = id;
 *     this.name = name;
 *     this.description = description;
 *  } 모든 필드를 초기화하는 생성자
 */
    public class ScheduleRequestDto {

        /**
         * 필드가 null이거나 빈 문자열이 아닌지 검증
         */
        @NotBlank

        /**
         * 문자열의 길이가 최소 1자에서 최대 200자 사이인지 검증
         */
        @Size(min = 1, max = 200)
        private String title;

        @NotBlank

        /**
         * 문자열의 길이가 최소 1자에서 최대 500자 사이인지 검증
         */
        @Size(min = 1, max = 500)
        private String contents;

        @NotBlank

        /**
         * 필드가 유효한 이메일 형식인지 검증
         */
        @Email
        private String charge;

        @NotBlank
        private String username;
    }



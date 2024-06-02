package com.sparta.crud_pro.entity;

import com.sparta.crud_pro.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 엔티티는 데이터베이스의 특정 테이블에 데이터를 저장

@Getter
/**
 * JPA가 관리할 수 있는 Entity 클래스로 지정. 이 클래스가 JPA 엔티티임을 나타낸다.
 */
@Entity

/**
 * 엔티티가 생성되거나 수정될 때 자동으로 생성 시간과 수정 시간을 기록
 */
@EntityListeners(AuditingEntityListener.class)

@Table(name = "crud")
/**
 * 매핑할 테이블 이름을 "crud"로 지정. 매핑은 클래스와 관계형 데이터베이스의 테이블을 서로 연결하는 것을 의미.
 */

@NoArgsConstructor
/**
 * public Schedule() {} 기본 생성자
 */

@AllArgsConstructor
/**
 * public Schedule(Long id, String name, String description) {
 *     this.id = id;
 *     this.name = name;
 *     this.description = description;
 *  } 모든 필드를 초기화하는 생성자
 */

public class Schedule {
    @Id
    /**
     * 해당 필드가 엔티티의 고유 식별자(Primary Key)임을 나타냅니다.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 데이터베이스에서 자동 증가하는 숫자(IDENTITY) 방식을 사용하여 기본 키를 생성합니다.
     */
    private Long id;
    /**
     * id는 Long 타입의 멤버 변수이며, private 접근제어자로 생성하여, 클래스 외부에서 직접
     * 접근하지 않도록 하며, getter와 setter로 접근 할 수 있다.
     */

    @Column(name = "title", nullable = false, length = 20)
    private String title;
    /**
     * "title"이라는 열에 매핑되는 데이터베이스 열.
     * NOT NULL 제약 조건이 설정되어 있으며, 최대 길이는 20자.
     * NOT NULL 제약 조건 = NULL 값을 허용하지 않음을 말한다.
     */

    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
    /**
     * "contents"이라는 열에 매핑되는 데이터베이스 열.
     * NOT NULL 제약 조건이 설정되어 있으며, 최대 길이는 500자.
     */

    @Column(name = "charge", nullable = false)
    private String charge;
    /**
     * "charge"이라는 열에 매핑되는 데이터베이스 열.
     * NOT NULL 제약 조건이 설정
     */

    @Column(name = "username", nullable = false, length = 20)
    private String username;
    /**
     * "username"이라는 열에 매핑되는 데이터베이스 열.
     * NOT NULL 제약 조건이 설정되어 있으며, 최대 길이는 20자.
     */

    @CreatedDate
    /**
     * 엔티티가 생성될 때 자동으로 현재 시간을 저장하는 역할.
     */
    @Column(updatable = false)
    /**
     * 해당 생성 시간이 변경되지 않도록 설정.
     */
    @Temporal(TemporalType.TIMESTAMP)
    /**
     * TemporalType.TIMESTAMP: 날짜와 시간을 모두 저장 (연, 월, 일, 시, 분, 초).
     * LocalDateTime 을 사용하기 위해 선언,
     */

    private LocalDateTime createdAt;

    /**
     * Schedule 엔티티 클래스의 생성자로, ScheduleRequestDto 객체를 받아서 Schedule 객체의 필드들을 초기화
     */

    public Schedule(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.charge = requestDto.getCharge();
        this.username = requestDto.getUsername();
        this.createdAt = LocalDateTime.now();
    }
}


package com.dlddy.book.springboot.domain.posts;

import com.dlddy.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가 -> public Posts() {}와 같은 효과
@Entity //테이블과 링크될 클래스임을 나타냄, 카멜케이스 -> 언더스코어 네이밍(_)으로 테이블 이름 매칭 (SalesManager.java -> sales_manager table)
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄, GenerationType.IDENTITY 추가해야 auto_increment 된다.
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼. 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다. 사용 하는이유: 기본값 외의 추가로 변경이 필요한 옵션이 있을 때
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

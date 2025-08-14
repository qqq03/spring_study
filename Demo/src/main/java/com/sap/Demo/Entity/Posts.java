package com.sap.Demo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Posts {
    @Id // @Id 어노테이션은 해당 필드가 기본 키임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // 생성자 이름을 반드시 클래스명과 맞춰야 함
    public Posts() {}

    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

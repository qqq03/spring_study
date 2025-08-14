package com.sap.Demo.Repository;

import com.sap.Demo.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // 제목으로 게시글 찾기
    List<Posts> findByTitle(String title);
    // 제목에 특정 문자열이 포함된 게시글 찾기 (LIKE 검색)
    List<Posts> findByTitleContaining(String keyword);
    // 최신순 전체 게시글 조회 (id 역순)
    List<Posts> findAllByOrderByIdDesc();
    // 특정 content 내용으로 게시글 찾기
    List<Posts> findByContent(String content);
    // 복수 조건 검색: 제목과 내용이 모두 일치하는 게시글 조회
    List<Posts> findByTitleAndContent(String title, String content);
    // 필요한 개수만 조회 (상위 10개)
    List<Posts> findTop10ByOrderByIdDesc();
}

package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;

import java.util.List;
import java.util.Map;

/**
 * packageName :  com.fastcampus.ch4.dao
 * fileName : BoardDao
 * author :  82108
 * date : 2023-03-15
 * description :
 */
public interface BoardDao {
    int count() throws Exception // T selectOne(String statement)
    ;

    int deleteAll() // int delete(String statement)
    ;

    int delete(Integer bno, String writer) throws Exception // int delete(String statement, Object parameter)
    ;

    int insert(BoardDto dto) throws Exception // int insert(String statement, Object parameter)
    ;

    List<BoardDto> selectAll() throws Exception // List<E> selectList(String statement)
    ;

    BoardDto select(Integer bno) throws Exception // T selectOne(String statement, Object parameter)
    ;

    List<BoardDto> selectPage(Map map) throws Exception // List<E> selectList(String statement, Object parameter)
    ;

    int update(BoardDto dto) throws Exception // int update(String statement, Object parameter)
    ;

    int increaseViewCnt(Integer bno) throws Exception // int update(String statement, Object parameter)
    ;

    List<BoardDto> selectSelectPage(SearchCondition sc) throws Exception;
    int searchResultCnt(SearchCondition sc) throws Exception;

}

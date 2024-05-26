package kr.co.inhatcspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.inhatcspring.beans.BoardDataBean;
import kr.co.inhatcspring.beans.DataBean;

public interface MapperInterface {
    
    // 새로운 게시글 데이터를 ONLINEBOARD 테이블에 삽입
    // 게시글 ID는 시퀀스를 사용하여 자동 생성
    @Insert("INSERT INTO ONLINEBOARD (BOARDID, CATEGORY, TITLE, CONTENT, USERID) VALUES (board_seq.NEXTVAL, #{category}, #{title}, #{content}, #{userId})")
    void insertBoardData(BoardDataBean boardDataBean);

    // 특정 카테고리의 게시글 데이터 조회
    // 결과는 BOARDID 내림차순 정렬
    @Select("SELECT * FROM ONLINEBOARD WHERE CATEGORY = #{category} ORDER BY BOARDID DESC")
    List<BoardDataBean> getBoardList(String category);

    // 특정 게시글 ID의 데이터 조회
    @Select("SELECT * FROM ONLINEBOARD WHERE BOARDID = #{boardId}")
    BoardDataBean getBoardData(@Param("boardId") Long boardId);

    // 특정 게시글 ID의 데이터 업데이트
    @Update("UPDATE ONLINEBOARD SET TITLE = #{title}, CONTENT = #{content} WHERE BOARDID = #{boardId}")
    void updateBoardData(BoardDataBean boardDataBean);

    // 특정 게시글 ID의 데이터 삭제
    @Delete("DELETE FROM ONLINEBOARD WHERE BOARDID = #{boardId}")
    void deleteBoardData(@Param("boardId") Long boardId);


	// 12주차
	@Insert("insert into spring_mvc_table (data1, data2, data3) values (#{data1}, #{data2}, #{data3} )")
	void insert_data(DataBean dataBean);
	
	@Select("select data1, data2, data3 from spring_mvc_table")
	List<DataBean> select_data();
}

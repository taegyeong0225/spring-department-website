package kr.co.inhatcspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.inhatcspring.beans.BoardDataBean;

public interface MapperInterface {
	@Insert("INSERT INTO ONLINEBOARD (BOARDID, CATEGORY, TITLE, CONTENT, USERID) VALUES (board_seq.NEXTVAL, #{category}, #{title}, #{content}, #{userId})")
    void insertBoardData(BoardDataBean boardDataBean);

    @Select("SELECT * FROM ONLINEBOARD WHERE CATEGORY = #{category} ORDER BY BOARDID DESC")
    List<BoardDataBean> getBoardList(String category);

    @Select("SELECT * FROM ONLINEBOARD WHERE BOARDID = #{boardId}")
    BoardDataBean getBoardData(@Param("boardId") Long boardId);

    @Update("UPDATE ONLINEBOARD SET TITLE = #{title}, CONTENT = #{content} WHERE BOARDID = #{boardId}")
    void updateBoardData(BoardDataBean boardDataBean);

    @Delete("DELETE FROM ONLINEBOARD WHERE BOARDID = #{boardId}")
    void deleteBoardData(@Param("boardId") Long boardId);
}

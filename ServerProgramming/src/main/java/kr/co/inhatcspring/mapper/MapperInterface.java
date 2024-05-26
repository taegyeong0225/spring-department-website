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
	@Insert("INSERT INTO ONLINEBOARD (BOARD_ID, CREATED_DATE, CATEGORY, TITLE, CONTENT, USER_ID) VALUES (board_seq.NEXTVAL, CURRENT_TIMESTAMP, #{category}, #{title}, #{content}, #{userId})")
    void insertBoardData(BoardDataBean boardDataBean);

    @Select("SELECT * FROM ONLINEBOARD WHERE CATEGORY = #{category} ORDER BY CREATED_DATE DESC")
    List<BoardDataBean> getBoardList(String category);

    @Select("SELECT * FROM ONLINEBOARD WHERE BOARD_ID = #{boardId}")
    BoardDataBean getBoardData(@Param("boardId") Long boardId);

    @Update("UPDATE ONLINEBOARD SET TITLE = #{title}, CONTENT = #{content} WHERE BOARD_ID = #{boardId}")
    void updateBoardData(BoardDataBean boardDataBean);

    @Delete("DELETE FROM ONLINEBOARD WHERE BOARD_ID = #{boardId}")
    void deleteBoardData(@Param("boardId") Long boardId);


	// 12주차
	@Insert("insert into spring_mvc_table (data1, data2, data3) values (#{data1}, #{data2}, #{data3} )")
	void insert_data(DataBean dataBean);
	
	@Select("select data1, data2, data3 from spring_mvc_table")
	List<DataBean> select_data();
}

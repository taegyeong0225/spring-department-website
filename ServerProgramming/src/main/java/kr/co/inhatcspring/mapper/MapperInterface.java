package kr.co.inhatcspring.mapper;

import java.util.List;
import kr.co.inhatcspring.beans.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MapperInterface {
	@Insert("INSERT INTO OnlineBoard (board_id, created_date, category, content, user_id) VALUES (board_seq.NEXTVAL, CURRENT_TIMESTAMP, #{category}, #{content}, #{userId})")
    void insertBoardData(BoardDataBean boardDataBean);
	
	@Select("SELECT * FROM OnlineBoard WHERE category = #{category} ORDER BY created_date DESC")
	List<BoardDataBean> getBoardList(String category);


	// 12주차
	@Insert("insert into spring_mvc_table (data1, data2, data3) values (#{data1}, #{data2}, #{data3} )")
	void insert_data(DataBean dataBean);
	
	@Select("select data1, data2, data3 from spring_mvc_table")
	List<DataBean> select_data();
}

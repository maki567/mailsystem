package jp.co.openworker.mailsystem.model.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.domain.SelectMail;

@Mapper
public interface SelectMailMapper {
	
	@Delete("DELETE FROM create_mail WHERE user_Id = #{userId}")
	int delete(@Param("userId") int userId);
	
	@Select("SELECT * FROM create_mail WHERE user_id = #{userId}")
	SelectMail select(@Param("userId") int userId);
	
	@Insert("INSERT INTO create_mail ("
				+ "user_id, subject, text"
				+ ") "
				+ "VALUES ("
				+ "#{userId}, #{subject}, #{text}"
				+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(SelectMail mail);
	
	@Update("UPDATE create_mail SET "
			+ "subject = #{subject}, text = #{text}"
			+ "where user_id = #{userId}")
	int update(SelectMail mail);
}
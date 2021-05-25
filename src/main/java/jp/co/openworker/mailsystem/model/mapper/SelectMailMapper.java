package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.openworker.mailsystem.model.domain.SelectAddress;
import jp.co.openworker.mailsystem.model.domain.SelectMail;

@Mapper
public interface SelectMailMapper {
	
	@Select("SELECT * FROM create_mail WHERE user_id = #{userId}")
	List<SelectMail> select(@Param("userId") int userId);
	
	@Insert("INSERT INTO create_mail ("
				+ "user_id, subject, text"
				+ ") "
				+ "VALUES ("
				+ "#{userId}, #{subject}, #{text}"
				+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(SelectMail mail);
}
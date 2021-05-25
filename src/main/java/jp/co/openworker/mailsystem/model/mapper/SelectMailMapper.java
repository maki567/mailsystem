package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.openworker.mailsystem.model.domain.SelectMail;

@Mapper
public interface SelectMailMapper {
	
	
	
	@Insert("INSERT INTO create_mail ("
				+ "subject, text"
				+ ") "
				+ "VALUES ("
				+ "#{subject}, #{text}"
				+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(SelectMail mail);
}
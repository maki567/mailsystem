package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.openworker.mailsystem.model.domain.SelectAddress;

@Mapper
public interface SelectAddressMapper {
	
	@Delete("DELETE FROM select_address WHERE user_Id = #{userId}")
	int release(@Param("userId") int userId);
	
	@Select("SELECT * FROM select_address WHERE user_id = #{userId} ORDER BY company_name")
	List<SelectAddress> select(@Param("userId") int userId);
	
	@Insert("INSERT INTO select_address ("
				+ "user_id, company_name, corporation,"
				+ "staff_name, staff_mail"
				+ ") "
				+ "VALUES ("
				+ "#{userId}, #{companyName}, #{corporation},"
				+ "#{staffName}, #{staffMail}"
				+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(SelectAddress address);
}

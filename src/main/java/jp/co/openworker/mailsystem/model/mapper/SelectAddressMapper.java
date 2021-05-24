package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.openworker.mailsystem.model.domain.SelectAddress;

@Mapper
public interface SelectAddressMapper {
	
		@Insert("INSERT INTO select_address ("
					+ "user_id, company_name, corporation,"
					+ "staff_name, staff_mail,"
					+ ") "
					+ "VALUES ("
					+ "#{userId}, #{companyName}, #{corporation},"
					+ "#{staffName}, #{staffMail},"
					+ ")")
		@Options(useGeneratedKeys=true, keyProperty="id")
		int insert(SelectAddress address);
	

}
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
				+ "staff_name, staff_mail"
				+ ") "
				+ "VALUES ("
				+ "#{userId1}, #{companyName1}, #{corporation1},"
				+ "#{staffName1}, #{staffMail1}"
				+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert1(SelectAddress address);

	@Insert("INSERT INTO select_address ("
				+ "user_id, company_name, corporation,"
				+ "staff_name, staff_mail"
				+ ") "
				+ "VALUES ("
				+ "#{userId2}, #{companyName2}, #{corporation2},"
				+ "#{staffName2}, #{staffMail2}"
				+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert2(SelectAddress address);
}

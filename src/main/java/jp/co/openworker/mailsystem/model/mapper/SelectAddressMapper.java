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
	
	@Insert("INSERT INTO select_address ("
			+ "user_id, company_name, corporation,"
			+ "staff_name, staff_mail"
			+ ") "
			+ "VALUES ("
			+ "#{userId3}, #{companyName3}, #{corporation3},"
			+ "#{staffName3}, #{staffMail3}"
			+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert3(SelectAddress address);

	@Insert("INSERT INTO select_address ("
			+ "user_id, company_name, corporation,"
			+ "staff_name, staff_mail"
			+ ") "
			+ "VALUES ("
			+ "#{userId4}, #{companyName4}, #{corporation4},"
			+ "#{staffName4}, #{staffMail4}"
			+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert4(SelectAddress address);

	@Insert("INSERT INTO select_address ("
		+ "user_id, company_name, corporation,"
		+ "staff_name, staff_mail"
		+ ") "
		+ "VALUES ("
		+ "#{userId5}, #{companyName5}, #{corporation5},"
		+ "#{staffName5}, #{staffMail5}"
		+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert5(SelectAddress address);

	@Insert("INSERT INTO select_address ("
		+ "user_id, company_name, corporation,"
		+ "staff_name, staff_mail"
		+ ") "
		+ "VALUES ("
		+ "#{userId6}, #{companyName6}, #{corporation6},"
		+ "#{staffName6}, #{staffMail6}"
		+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert6(SelectAddress address);

	@Insert("INSERT INTO select_address ("
		+ "user_id, company_name, corporation,"
		+ "staff_name, staff_mail"
		+ ") "
		+ "VALUES ("
		+ "#{userId7}, #{companyName7}, #{corporation7},"
		+ "#{staffName7}, #{staffMail7}"
		+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert7(SelectAddress address);

	@Insert("INSERT INTO select_address ("
		+ "user_id, company_name, corporation,"
		+ "staff_name, staff_mail"
		+ ") "
		+ "VALUES ("
		+ "#{userId8}, #{companyName8}, #{corporation8},"
		+ "#{staffName8}, #{staffMail8}"
		+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert8(SelectAddress address);

	@Insert("INSERT INTO select_address ("
		+ "user_id, company_name, corporation,"
		+ "staff_name, staff_mail"
		+ ") "
		+ "VALUES ("
		+ "#{userId9}, #{companyName9}, #{corporation9},"
		+ "#{staffName9}, #{staffMail9}"
		+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert9(SelectAddress address);

	@Insert("INSERT INTO select_address ("
		+ "user_id, company_name, corporation,"
		+ "staff_name, staff_mail"
		+ ") "
		+ "VALUES ("
		+ "#{userId10}, #{companyName10}, #{corporation10},"
		+ "#{staffName10}, #{staffMail10}"
		+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert10(SelectAddress address);
}

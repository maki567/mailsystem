package jp.co.openworker.mailsystem.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.openworker.mailsystem.model.domain.MstAddress;

@Mapper
public interface MstAddressMapper {
	
	@Insert("INSERT INTO mst_address ("
					+ "company_name, staff_name, "
					+ "mail_address, company_address, phone_number, "
					+ ") "
					+ "VALUES ("
					+ "#{companyName}, #{staffName}, "
					+ "#{mailAddress}, #{companyAddress}, #{phoneNumber}, "
					+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(MstAddress company);
	
		@Select("SELECT * FROM mst_address WHERE company_name = #{companyName}")
		MstAddress findByCompanyName(
					@Param("companyName") String companyName);
		
		@Select("SELECT count(id) FROM mst_address WHERE company_name = #{companyName}")
		int findCountByCompanyName(@Param("companyName") String companyName);
		
}
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
					+ "company_name, company_address, corporation, company_number,"
					+ "staff_name, staff_address, staff_number"
					+ ") "
					+ "VALUES ("
					+ "#{companyName}, #{companyAddress}, #{corporation}, #{companyNumber},"
					+ "#{staffName}, #{staffAddress}, #{staffNumber}"
					+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(MstAddress address);
	
	
	@Select("SELECT count(id) FROM mst_address WHERE company_name = #{companyName}")
	int findCountByCompanyName(@Param("companyName") String companyName);
		
}
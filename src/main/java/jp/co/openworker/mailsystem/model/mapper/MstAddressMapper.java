package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.openworker.mailsystem.model.domain.MstAddress;

@Mapper
public interface MstAddressMapper {
	
		@Select("SELECT * FROM mst_address WHERE user_id = #{userId} ORDER BY company_name")
		List<MstAddress> select(@Param("userId") int userId);

		@Delete("DELETE FROM mst_address WHERE id = #{id}")
		int deleteById(@Param("id") int id);
	
		@Insert("INSERT INTO mst_address ("
					+ "user_id, company_name, company_address, corporation, company_number,"
					+ "staff_name1, staff_mail1, staff_number1,"
					+ "staff_name2, staff_mail2, staff_number2,"
					+ "staff_name3, staff_mail3, staff_number3,"
					+ "staff_name4, staff_mail4, staff_number4,"
					+ "staff_name5, staff_mail5, staff_number5,"
					+ "staff_name6, staff_mail6, staff_number6,"
					+ "staff_name7, staff_mail7, staff_number7,"
					+ "staff_name8, staff_mail8, staff_number8,"
					+ "staff_name9, staff_mail9, staff_number9,"
					+ "staff_name10, staff_mail10, staff_number10"
					+ ") "
					+ "VALUES ("
					+ "#{userId}, #{companyName}, #{companyAddress}, #{corporation}, #{companyNumber},"
					+ "#{staffName1}, #{staffMail1}, #{staffNumber1},"
					+ "#{staffName2}, #{staffMail2}, #{staffNumber2},"
					+ "#{staffName3}, #{staffMail3}, #{staffNumber3},"
					+ "#{staffName4}, #{staffMail4}, #{staffNumber4},"
					+ "#{staffName5}, #{staffMail5}, #{staffNumber5},"
					+ "#{staffName6}, #{staffMail6}, #{staffNumber6},"
					+ "#{staffName7}, #{staffMail7}, #{staffNumber7},"
					+ "#{staffName8}, #{staffMail8}, #{staffNumber8},"
					+ "#{staffName9}, #{staffMail9}, #{staffNumber9},"
					+ "#{staffName10}, #{staffMail10}, #{staffNumber10}"
					+ ")")
		@Options(useGeneratedKeys=true, keyProperty="id")
		int insert(MstAddress address);
	
		@Select("SELECT * FROM mst_address where id = #{id}")
		MstAddress findById(@Param("id") int id);
		
		@Select("SELECT * FROM mst_address where company_name = #{companyName}")
		MstAddress findByCompanyName(@Param("companyName") String companyName);
	
		@Select("SELECT count(id) FROM mst_address WHERE company_name = #{companyName}")
		int findCountByCompanyName(@Param("companyName") String companyName);
		
		@Update("UPDATE mst_address SET "
				+ "company_name = #{companyName}, company_address = #{companyAddress},"
				+ "corporation = #{corporation}, company_number = #{companyNumber},"
				+ "staff_name1 = #{staffName1}, staff_mail1 = #{staffMail1}, staff_number1 = #{staffNumber1},"
				+ "staff_name2 = #{staffName2}, staff_mail2 = #{staffMail2}, staff_number2 = #{staffNumber2},"
				+ "staff_name3 = #{staffName3}, staff_mail3 = #{staffMail3}, staff_number3 = #{staffNumber3},"
				+ "staff_name4 = #{staffName4}, staff_mail4 = #{staffMail4}, staff_number4 = #{staffNumber4},"
				+ "staff_name5 = #{staffName5}, staff_mail5 = #{staffMail5}, staff_number5 = #{staffNumber5},"
				+ "staff_name6 = #{staffName6}, staff_mail6 = #{staffMail6}, staff_number6 = #{staffNumber6},"
				+ "staff_name7 = #{staffName7}, staff_mail7 = #{staffMail7}, staff_number7 = #{staffNumber7},"
				+ "staff_name8 = #{staffName8}, staff_mail8 = #{staffMail8}, staff_number8 = #{staffNumber8},"
				+ "staff_name9 = #{staffName9}, staff_mail9 = #{staffMail9}, staff_number9 = #{staffNumber9},"
				+ "staff_name10 = #{staffName10}, staff_mail10 = #{staffMail10}, staff_number10 = #{staffNumber10}"
				+ "where id = #{id}")
		int update(MstAddress address);
		
		@Select("SELECT * FROM mst_address WHERE id = #{id}")
		List<MstAddress> selectStaff(@Param("id") int id);
}
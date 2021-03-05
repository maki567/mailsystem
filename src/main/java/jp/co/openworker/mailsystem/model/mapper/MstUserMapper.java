package jp.co.openworker.mailsystem.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.openworker.mailsystem.model.domain.MstUser;

@Mapper
public interface MstUserMapper {
	
	@Insert("INSERT INTO mst_user ("
					+ "mail_address, password, "
					+ "family_name, first_name, "
					+ ") "
					+ "VALUES ("
					+ "#{mailAddress}, #{password}, "
					+ "#{familyName}, #{firstName}"
					+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(MstUser user);
	
		@Select("SELECT * FROM mst_user WHERE mail_address = #{mailAddress} AND password = #{password}")
		MstUser findByMailAddressAndPassword(
					@Param("mailAddress") String mailAddress,
					@Param("password") String password);
		
		@Select("SELECT count(id) FROM mst_user WHERE mail_address = #{mailAddress}")
		int findCountByMailAddress(@Param("mailAddress") String mailAddress);
		
		@Update("UPDATE mst_user SET password = #{password} WHERE mail_address = #{mailAddress}")
		int updatePassword(
					@Param("mailAddress") String mailAddress,
					@Param("password") String password);
	
}
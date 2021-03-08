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
					+ "user_name, password, "
					+ "family_name, first_name"
					+ ") "
					+ "VALUES ("
					+ "#{userName}, #{password}, "
					+ "#{familyName}, #{firstName}"
					+ ")")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(MstUser user);
	
		@Select("SELECT * FROM mst_user WHERE user_name = #{userName} AND password = #{password}")
		MstUser findByUserNameAndPassword(
					@Param("userName") String userName,
					@Param("password") String password);
		
		@Select("SELECT count(id) FROM mst_user WHERE user_name = #{userName}")
		int findCountByUserName(@Param("userName") String userName);
		
		@Update("UPDATE mst_user SET password = #{password} WHERE user_name = #{userName}")
		int updatePassword(
					@Param("userName") String userName,
					@Param("password") String password);
	
}
package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.openworker.mailsystem.model.domain.MstAddress;
//import jp.co.openworker.mailsystem.model.domain.MstAddress;
import jp.co.openworker.mailsystem.model.domain.MstUser;
import jp.co.openworker.mailsystem.model.session.LoginSession;
import jp.co.openworker.mailsystem.model.form.UserForm;

@Mapper
public interface MstUserMapper {
	
	@Insert("INSERT INTO mst_user ("
					+ "user_name, password, signature"
					+ ") "
					+ "VALUES ("
					+ "#{userName}, #{password}, #{signature}"
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
	
		@Select("SELECT signature FROM mst_user where id = #{id}")
		MstUser findBySignature(
					@Param("id") int id);
		
		@Update("UPDATE mst_user SET signature = #{signature} where id = #{id}")
		int update(MstUser user);
	
}

		











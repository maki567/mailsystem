package jp.co.openworker.mailsystem.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

import jp.co.openworker.mailsystem.model.domain.MailHistory;
//import jp.co.openworker.mailsystem.model.domain.MstAddress;

//import jp.co.openworker.mailsystem.model.domain.MstAddress;

@Mapper
public interface MailHistoryMapper {
	
	@Insert("INSERT INTO mail_history ("
					+ "subject, to_staff, to_company, day_time"					
					+ ") "
					+ "VALUES ("
					+ "#{subject}, #{to_staff}, #{to_company}, #{day_time}"
					+ ")")
	
	
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(MailHistory mail);
	
	
	@Select("SELECT count(id) FROM mail_history WHERE subject = #{subject}")
	int findCountBySubject(@Param("subject") String subject);
	
	
	@Select("select * from mail_history")
	List<MailHistory> find();
		
	List<MailHistory> findBySubject(@Param("keywords") String[] keywords);
		
	@Select("select * from mail_history where id = #{id}")
	MailHistory findById(@Param("id") int id);
	
	@Select("select * from mail_history where user_id = #{userId}")
	List<MailHistory> select(@Param("userId") int userId);
	
	@Delete("DELETE from mail_history WHERE id = #{id}")
	int deleteById(@Param("id") int id);
}
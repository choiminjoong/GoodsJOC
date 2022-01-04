package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.User;

@Mapper
public interface UserMapper {

	//회원상세조회
	public User getUserInfoByID(String ID);
	
	//회원전체조회
	public List<User> getUserList(String martCode);
	
}

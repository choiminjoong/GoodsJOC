package k5.goodsjoc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.User;

@Mapper
public interface UserMapper {

	//회원상세조회
	public User getUserInfoByID(String ID);
	
	//사용자 전체조회
	public List<User> getUserList(String martCode);
	
	// 사용자 단일정보 검색
	public List<User> getUserListBySearchKey(String searchKey, String searchValue);
	
	//사용자 정보 수정
	public int userUpdateInfo(User user);
	
	
}

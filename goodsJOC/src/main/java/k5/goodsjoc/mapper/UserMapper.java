package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.User;

@Mapper
public interface UserMapper {

	//사용자 상세조회 (정도혜)
	public User getUserInfoByID(String ID);
	
	//사용자 전체조회 (정도혜)
	public List<User> getUserList(String martCode);
	
	// 사용자 단일정보 검색 (정도혜)
	public List<User> getUserListBySearchKey(String searchKey, String searchValue, String martCode);
	
	//사용자 정보 수정 
	public int userUpdateInfo(User user);
	
	//사용자 권한정보 수정 (정도혜)
	public int updateUserLevel(User user);
	
	//사용자 아이디 중복확인 
	public int getUserByUserId(String userId);

	public int userInsertAction(User user);

	public List<User> getTotalUserList();

	public List<User> getTotalUserSearchList(Map<String, Object> paramMap);
	//계정 활성화
	public void userActive(String id);
	//계정 비활성화
	public void userNoActive(String id);
	
	
}

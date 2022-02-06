package k5.goodsjoc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import k5.goodsjoc.dto.User;

@Mapper
public interface UserMapper {
/**
	01.특정 사용자 조회	02.ID중복체크	03.회원가입 처리		04.개인정보 수정처리	05.매장별 직원 전체조회 화면	06.매장별 직원 조건검색 화면
	07.직원권한 수정처리	08.직원조회 모달Ajax		09.사용자 전체조회 화면(개발사)	10.사용자 조건검색 화면(개발사)	11.계정 활성화	12.계정 비활
**/
	//01.특정 사용자 조회
	public User getUserInfoByID(String ID);

	//02.ID중복체크
	public int getUserByUserId(String userId);	
	
	//03.회원가입 처리
	public int userInsertAction(User user);	
	
	//04.개인정보 수정처리
	public int userUpdateInfo(User user);	
	
	//05.매장별 직원 전체조회 화면
	public List<User> getUserList(String martCode);
	
	//06.매장별 직원 조건검색 화면
	public List<User> getUserListBySearchKey(String searchKey, String searchValue, String martCode);
	
	//07.직원권한 수정처리
	public int updateUserLevel(User user);
	
	//08.직원조회 모달Ajax
	public List<User> getSearchStaffList(String sessionMartCode);

	//09.사용자 전체조회 화면(개발사)
	public List<User> getTotalUserList();

	//10.사용자 조건검색 화면(개발사)
	public List<User> getTotalUserSearchList(Map<String, Object> paramMap);

	//11.계정 활성화
	public void userActive(String id);

	//12.계정 비활
	public void userNoActive(String id);

	
	
}

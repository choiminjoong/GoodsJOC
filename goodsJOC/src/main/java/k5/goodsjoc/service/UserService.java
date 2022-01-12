package k5.goodsjoc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import k5.goodsjoc.dto.User;
import k5.goodsjoc.mapper.UserMapper;

@Service
@Transactional
public class UserService {

	private UserMapper userMapper;

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	// 사용자 전체조회
	public List<User> getUserList(String martCode) {
		return userMapper.getUserList(martCode);
	}

	// 사용자 단일 정보조회
	public User getUserInfoByID(String iD) {
		return userMapper.getUserInfoByID(iD);
	}

	// 사용자 조건 검색
	public List<User> getUserListBySearchKey(String searchKey, String searchValue) {
		return userMapper.getUserListBySearchKey(searchKey, searchValue);

	}

	// 사용자 정보 수정
	public int updateUserInfo(User user) {
		return userMapper.userUpdateInfo(user);
	}
	
	//사원 권한정보 수정
	public int updateUserLevel(User user) {
		return userMapper.updateUserLevel(user);
	}


}
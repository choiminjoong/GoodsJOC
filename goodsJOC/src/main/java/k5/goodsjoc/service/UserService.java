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
	
	public User getUserInfoByID(String ID) {
		
		return userMapper.getUserInfoByID(ID);
	}
	
	//사용자 전체조회
	public List<User> getUserList(String martCode){
		
		return userMapper.getUserList(martCode);
	}
}

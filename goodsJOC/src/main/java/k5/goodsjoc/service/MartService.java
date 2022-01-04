package k5.goodsjoc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import k5.goodsjoc.dto.Mart;
import k5.goodsjoc.mapper.MartMapper;

@Service
@Transactional
public class MartService {
	
	private MartMapper martMapper;
	
	public MartService(MartMapper martMapper) {
		this.martMapper = martMapper;
	}
	
	public Mart getMartInfoByMartCode(String martCode) {

		return martMapper.getMartInfoByMartCode(martCode);
		
	}
	
	
}

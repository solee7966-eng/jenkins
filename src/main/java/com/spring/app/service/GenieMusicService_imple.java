package com.spring.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.app.domain.GenieMusicDTO;
import com.spring.app.model.GenieMusicDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenieMusicService_imple implements GenieMusicService {

    private final GenieMusicDAO genieDao;

	@Override
	public List<GenieMusicDTO> musicList() {
		
		List<GenieMusicDTO> musicList = genieDao.musicList();
		
		return musicList;
	}	
	
}

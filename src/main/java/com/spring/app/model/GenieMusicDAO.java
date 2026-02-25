package com.spring.app.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.app.domain.GenieMusicDTO;

@Mapper
public interface GenieMusicDAO {
    
//	@Select("select title, singer, poster "
//    		+ "		from genie_music "
//    		+ "		order by no asc ")
	List<GenieMusicDTO> musicList();
	
}

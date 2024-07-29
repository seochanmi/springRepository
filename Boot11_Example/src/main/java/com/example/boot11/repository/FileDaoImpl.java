package com.example.boot11.repository;

import com.example.boot11.dto.FileDto;
import com.example.boot11.repository.FileDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //bean 으로 만들기 위해
public class FileDaoImpl implements FileDao {
	//mybatis 기반의 dao 에서 필요한 객체
    @Autowired SqlSession session;

    @Override
    public void insert(FileDto dto) {
    	/*
    	 * 	mapper's namespace : file
    	 *  sql's id : insert
    	 *  parameterType : FileDto
    	 */
        session.insert("file.insert", dto);
    }

    @Override
    public FileDto getData(int num) {
    	
        return session.selectOne("file.getData", num);
    }

    @Override
    public List<FileDto> getList(FileDto dto) {
    	/*
    	 * 	parameterType : FileDto
    	 *  resultType : FileDto
    	 *  
    	 *  selectList() 메소드는 무조건 List type을 리턴하고
    	 *  List 의 Generic Type 은 mapper xml 에서 설정한 result type 과 같다
    	 * 
    	 * FileDto 에는 보여줄 page 에 해당하는 startRowNum과 endRowNum 이 들어 있다.
    	 */
    return session.selectList("file.getList", dto);
   
    }

    @Override
    public void delete(int num) {
        session.delete("file.delete", num);
    }

	@Override
	public int getCount(FileDto dto) {
		// dto 에 condition 과 keyword 는 null 일수도 있고 아닐수도 있다.
		return session.selectOne("file.getCount", dto);
	}
}

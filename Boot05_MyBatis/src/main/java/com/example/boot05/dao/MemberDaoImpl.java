package com.example.boot05.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot05.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		/*
		 * 	SqlSession 객체를 이용해서 회원목록을 얻어온다
		 */
		List<MemberDto> list=session.selectList("member.getList");
		
		//회원목록 리턴해주기
		return list;
	}

	@Override
	public void insert(MemberDto dto) {
		/*
		 *  SqlSession 객체를 이용해서 MemberDto 객체에 담긴 정보를 DB에 저장하기
		 */
		session.insert("member.insert", dto);
	}

	@Override
	public void delete(int num) {
		/*
		 * 	SqlSession 객체를 이용해서 회원번호로 해당 정보를 삭제하기
		 * */
		session.delete("member.delete", num);
		
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 * 회원 번호를 이용해서 회원 한명의 정보 얻어내기  
		 */
		MemberDto dto=session.selectOne("member.getData", num);
		
		List<MemberDto> list=session.selectList("member.getData", num);
		
		return dto;
	}

	@Override
	public void update(MemberDto dto) {
		/* 3가지를 유추
		 * 	mapper 의 namespace => member
		 * 	sql의 id => update
		 * 	parameterType => MemberDto
		 */
		session.update("member.update", dto);
		
	}

}

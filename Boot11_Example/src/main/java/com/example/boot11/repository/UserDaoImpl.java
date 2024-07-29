package com.example.boot11.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot11.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired private SqlSession session;
	
	@Override
	public UserDto getData(String userName) {
		/*
		 * 	mapper's namespace => user
		 *  sql's id => getData
		 * 	parameterType => String
		 * 	resultType => UserDto
		 * */
		return session.selectOne("user.getData", userName);
	}

	@Override
	public void insert(UserDto dto) {
		/*
		 * 	mapper's namespace => user
		 * 	sql's id => insert
		 * 	parameterType => UserDto
		 * 	resultType => select 가 아니기 때문에 없다
		 * */
		session.insert("user.insert", dto);
	}

	@Override
	public void updatePwd(UserDto dto) {
		/*
		 * 	mapper's namespace => user
		 * 	sql's id => updatePwd
		 * 	parameterType => UserDto
		 * 	resultType => select 가 아니기 때문에 없다
		 */
		session.update("user.updatePwd", dto);
	}

	@Override
	public void update(UserDto dto) {
		/*
		 * 	mapper's namespace => user
		 * 	sql's id => update
		 * 	parameterType => UserDto
		 * 	resultType => select 가 아니기 때문에 없다
		 */
		session.update("user.update", dto);
		
	}

}

package com.community.services.mapper.user;

import com.community.services.pojo.user.Token;
import com.community.services.pojo.user.TokenExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TokenMapper {
	int countByExample(TokenExample example);

	int deleteByExample(TokenExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Token record);

	int insertSelective(Token record);

	List<Token> selectByExample(TokenExample example);

	Token selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenExample example);

	int updateByExample(@Param("record") Token record, @Param("example") TokenExample example);

	int updateByPrimaryKeySelective(Token record);

	int updateByPrimaryKey(Token record);
}
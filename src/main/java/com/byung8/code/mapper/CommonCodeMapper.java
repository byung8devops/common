package com.byung8.code.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.common.domain.CodeGroup;
import com.byung8.common.domain.CommonCode;

@Mapper
public interface CommonCodeMapper {
	List<CommonCode> findCodeListByCodeGroup(String codeGroupVAl) throws SQLException;
	List<CodeGroup> getCodeGroupList() throws SQLException;
	int insertCodeGroup(CodeGroup codeGroup) throws SQLException;
	int updateCodeGroup(CodeGroup codeGroup) throws SQLException;
	int updateCodeGroupNotUsed(CodeGroup codeGroup) throws SQLException;
	int insertCommonCode(CommonCode commonCode) throws SQLException;
	int updateCommonCode(CommonCode commonCode) throws SQLException;
	int updateCommonCodeNotUsed(CommonCode commonCode) throws SQLException;
	int updateAllCommonCodesNotUsedByGroup(CodeGroup codeGroup) throws SQLException;
}

package com.byung8.common.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.common.domain.CodeGroup;
import com.byung8.common.domain.CommonCode;

@Mapper
public interface CommonCodeMapper {
	List<CommonCode> findCodeListByCodeGroup(String codeGroupVAl) throws SQLException;
	List<CodeGroup> getCodeGroupList() throws SQLException;
}

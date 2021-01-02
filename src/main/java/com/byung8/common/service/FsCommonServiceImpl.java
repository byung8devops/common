package com.byung8.common.service;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.CodeGroup;
import com.byung8.common.domain.CommonCode;
import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.common.mapper.CommonCodeMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("fsCommonService")
public class FsCommonServiceImpl implements FsCommonService {

	@Autowired
	private CommonCodeMapper commonCodeMapper;

	@Override
	public Result findCodes(String codeGroupVal, String txid) throws Byung8Exception {
		Result result = null;
		try {
			List<CommonCode> list = commonCodeMapper.findCodeListByCodeGroup(codeGroupVal);
			result = new Result(txid, Result.OK).putValue("commonCodes", list);
		} catch(SQLException e) {
			log.error("findCodes", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result getCodeGroups(String txid) throws Byung8Exception {
		Result result = null;
		try {
			List<CodeGroup> list = commonCodeMapper.getCodeGroupList();
			result = new Result(txid, Result.OK).putValue("codeGroups", list);
		} catch(SQLException e) {
			log.error("codeGroups", e);
			throw new Byung8Exception(e);
		}
		return result;
	}
}

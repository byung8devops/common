package com.byung8.code.service;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.CodeGroup;
import com.byung8.common.domain.CommonCode;
import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.code.mapper.CommonCodeMapper;

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

	@Override
	public Result addCodeGroup(CodeGroup codeGroup, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.insertCodeGroup(codeGroup);
			result = new Result(txid, Result.OK).putValue("insertCodeGroup", codeGroup);
		} catch(SQLException e) {
			log.error("insertCodeGroup", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result modifyCodeGroup(CodeGroup codeGroup, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.updateCodeGroup(codeGroup);
			result = new Result(txid, Result.OK).putValue("updateCodeGroup", codeGroup);
		} catch(SQLException e) {
			log.error("updateCodeGroup", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result modifyCodeGroupNotUsed(CodeGroup codeGroup, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.updateAllCommonCodesNotUsedByGroup(codeGroup);
			ret = commonCodeMapper.updateCodeGroupNotUsed(codeGroup);
			result = new Result(txid, Result.OK).putValue("updateCodeGroupNotUsed", codeGroup);
		} catch(SQLException e) {
			log.error("updateCodeGroupNotUsed", e);
			throw new Byung8Exception(e);
		}
		return result;
	}
	
	@Override
	public Result addCommonCode(CommonCode commonCode, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.insertCommonCode(commonCode);
			result = new Result(txid, Result.OK).putValue("insertCommonCode", commonCode);
		} catch(SQLException e) {
			log.error("insertCommonCode", e);
			throw new Byung8Exception(e);
		}
		return result;
	}
	
	@Override
	public Result modifyCommonCode(CommonCode commonCode, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.updateCommonCode(commonCode);
			result = new Result(txid, Result.OK).putValue("updateCommonCode", commonCode);
		} catch(SQLException e) {
			log.error("updateCommonCode", e);
			throw new Byung8Exception(e);
		}
		return result;		
	}
	
	@Override
	public Result modifyCommonCodeNotUsed(CommonCode commonCode, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.updateCommonCodeNotUsed(commonCode);
			result = new Result(txid, Result.OK).putValue("updateCommonCodeNotUsed", commonCode);
		} catch(SQLException e) {
			log.error("updateCommonCodeNotUsed", e);
			throw new Byung8Exception(e);
		}
		return result;		
	}
	
	@Override
	public Result modifyAllCommonCodesNotUsedByGroup(CodeGroup codeGroup, String txid) throws Byung8Exception {
		Result result = null;
		try {
			int ret = commonCodeMapper.updateAllCommonCodesNotUsedByGroup(codeGroup);
			result = new Result(txid, Result.OK).putValue("updateAllCommonCodesNotUsedByGroup", codeGroup);
		} catch(SQLException e) {
			log.error("updateAllCommonCodesNotUsedByGroup", e);
			throw new Byung8Exception(e);
		}
		return result;		
	}
}

package com.byung8.code.service;

import com.byung8.common.domain.CodeGroup;
import com.byung8.common.domain.CommonCode;
import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;

public interface FsCommonService {
	Result findCodes(String codeGroupVal, String txid) throws Byung8Exception;
	Result getCodeGroups(String txid) throws Byung8Exception;
	Result addCodeGroup(CodeGroup codeGroup, String txid) throws Byung8Exception;
	Result modifyCodeGroup(CodeGroup codeGroup, String txid) throws Byung8Exception;
	Result modifyCodeGroupNotUsed(CodeGroup codeGroup, String txid) throws Byung8Exception;
	Result addCommonCode(CommonCode commonCode, String txid) throws Byung8Exception;
	Result modifyCommonCode(CommonCode commonCode, String txid) throws Byung8Exception;
	Result modifyCommonCodeNotUsed(CommonCode commonCode, String txid) throws Byung8Exception;
	Result modifyAllCommonCodesNotUsedByGroup(CodeGroup codeGroup, String txid) throws Byung8Exception;
}

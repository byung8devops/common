package com.byung8.common.service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;

public interface FsCommonService {
	Result findCodes(String codeGroupVal, String txid) throws Byung8Exception;
	Result getCodeGroups(String txid) throws Byung8Exception;
}

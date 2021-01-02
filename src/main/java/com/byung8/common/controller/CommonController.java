package com.byung8.common.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.byung8.common.domain.IResult;
import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.common.service.FsCommonServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/common")
public class CommonController {

	@Autowired
	@Qualifier("fsCommonService")
	FsCommonServiceImpl fsCommonService;
	
	private String txId() {
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/codes/{codeGroupVal}", method = RequestMethod.GET)
	public ResponseEntity<String> findCodes(@PathVariable("codeGroupVal") final String codeGroupVal) {

		String txid = txId();
		try {
			Result result = fsCommonService.findCodes(codeGroupVal, txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch commonCodes", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/codeGroups", method = RequestMethod.GET)
	public ResponseEntity<String> getCodeGroups() {

		String txid = txId();
		try {
			Result result = fsCommonService.getCodeGroups(txid);
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error("Failed to fetch codeGroups", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
	
}

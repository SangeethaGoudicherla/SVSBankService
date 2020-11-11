package com.svsbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svsbank.dto.FundTransferRequestDto;
import com.svsbank.dto.ResponseDto;
import com.svsbank.exception.AccountNotFoundException;
import com.svsbank.service.FundTransferService;

@RestController
@RequestMapping("/bank")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;

	@Autowired
	Environment environment;

	@PostMapping("/fundTransfer")
	public ResponseEntity<ResponseDto> fundTransfer(@RequestBody List<FundTransferRequestDto> fundTransferRequestDtos) throws AccountNotFoundException {
		return new ResponseEntity<ResponseDto>(fundTransferService.fundTransfer(fundTransferRequestDtos),HttpStatus.OK);
	}
}

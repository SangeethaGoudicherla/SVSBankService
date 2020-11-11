package com.svsbank.service;

import java.util.List;

import com.svsbank.dto.FundTransferRequestDto;
import com.svsbank.dto.ResponseDto;
import com.svsbank.exception.AccountNotFoundException;

public interface FundTransferService {

	public ResponseDto fundTransfer(List<FundTransferRequestDto> fundTransferRequestDtos) throws AccountNotFoundException;

}

package com.dao.bankingsystem.service.customer.exception;

public class DuplicateCustomerIdcardNoException extends RuntimeException {
	protected String idcardNo;
	
	public DuplicateCustomerIdcardNoException(String idcardNo) {
		super("Duplicate customer idcardNo : " + idcardNo);
		this.idcardNo = idcardNo;
	}
	
	public String getIdcardNo() {
		return idcardNo;
	}
}

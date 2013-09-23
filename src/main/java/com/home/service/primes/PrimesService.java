package com.home.service.primes;

import java.math.BigInteger;

import com.home.exceptions.SullyException;
import com.home.model.datatable.JQueryDataTableParameter;

public interface PrimesService {

	public BigInteger findPrime(JQueryDataTableParameter parameters) throws SullyException;
	
}

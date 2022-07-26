package com.barclays.homeloan.serviceimpl;

import java.util.Optional;

import com.barclays.homeloan.exceptions.LoanNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.homeloan.entity.Loan;
import com.barclays.homeloan.repository.LoanRepository;
import com.barclays.homeloan.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository loanRepository;
	
	@Override
	public Loan getLoanById(int id) {

		Loan loan = loanRepository.findById(id).
				orElseThrow(()->new LoanNotFoundException(id));

		return loan;

	}
}

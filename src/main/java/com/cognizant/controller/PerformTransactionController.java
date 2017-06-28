package com.cognizant.controller;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.exception.TransactionTypeExceptions;
import com.cognizant.service.PerformTransactionService;

@Controller
public class PerformTransactionController {
	private static final Logger log = Logger.getLogger(PerformTransactionController.class);
	@Autowired
	PerformTransactionService performtransactionservice;

	@RequestMapping(value = "/performtransaction", method = RequestMethod.GET)
	public String getTransactionDetails(@ModelAttribute("Transaction") @Valid TransactionDetails Transaction,
			BindingResult result, Model model, @RequestParam("msg") String msg) {
		model.addAttribute("Transaction", new TransactionDetails());
		model.addAttribute("msg", msg);
		return "PerformTransaction";
	}

	@RequestMapping(value = "/performtransaction", method = RequestMethod.POST)
	public String performTransaction(@ModelAttribute("Transaction") @Valid TransactionDetails Transaction,
			BindingResult result, Model model, @RequestParam("msg") String msg) {
		long accountNumber = Long.parseLong(msg);
		try {
			performtransactionservice.updateTransactionDetails(Transaction, accountNumber);
		} catch (ConstraintViolationException e) {
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				log.error("Validation message: " + next.getMessage());
				log.error("Invalid field: " + next.getPropertyPath());
				log.error("Validation class/bean: " + next.getRootBean());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
			}
		} catch (TransactionTypeExceptions e) {
			String sb = e.getMessage();
			String sb1[] = sb.split(":");
			result.rejectValue(sb1[0].toString(), "", sb1[1].toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("m1", Transaction.getTransactionId());

		if (result.hasErrors()) {
			return "PerformTransaction";
		} else {
			model.addAttribute("m2", Transaction.getUserDetails().getAccountBalance());
			return "SuccessTransaction";
		}
	}

}
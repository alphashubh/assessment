
package com.cognizant.controller;

import java.util.Iterator;
import java.util.Set;

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

import com.cognizant.dao.ViewEducationLoanDao;
import com.cognizant.entity.ApplyEducationLoan;
import com.cognizant.exception.BankManagementException;
import com.cognizant.service.ApplyEducationLoanService;

@Controller
public class ApplyEducationLoanController {
	private static final Logger log = Logger.getLogger(ApplyEducationLoanController.class);
	@Autowired
	ApplyEducationLoanService educationLoanService;
	@Autowired
	ViewEducationLoanDao viewEducationLoan;

	@RequestMapping(value = "/addEducationLoan", method = RequestMethod.GET)
	public String getEmployee(@ModelAttribute("loan") @Valid ApplyEducationLoan loan, BindingResult result, Model model,
			@RequestParam("msg") String msg) {
		model.addAttribute("loan", new ApplyEducationLoan());
		model.addAttribute("msg", msg);
		return "ApplyEducationLoan";
	}

	@RequestMapping(value = "/addEducationLoan", method = RequestMethod.POST)
	public String addMember(@ModelAttribute("loan") @Valid ApplyEducationLoan loan, BindingResult result, Model model,
			@RequestParam("msg") String msg) {
		long accountNumber = Long.parseLong(msg);
		log.info(loan);
		try {
			educationLoanService.insertEducationLoan(loan, accountNumber);

		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				log.error("Validation message: " + next.getMessage());
				log.error("Invalid field: " + next.getPropertyPath());
				log.error("Validation class/bean: " + next.getRootBean());
				result.reject(next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());

			}
		} catch (BankManagementException e) {
			String sb = e.getMessage();
			String sb1[] = sb.split(":");
			result.rejectValue(sb1[0].toString(), "", sb1[1].toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result.hasErrors()) {
			return "ApplyEducationLoan";
		} else {
			model.addAttribute("m1", loan.getEduLoanAccountNumber());
			return "Output";
		}
	}

}

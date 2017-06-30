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
import com.cognizant.entity.ApplyHomeLoan;
import com.cognizant.exception.BankManagementException;
import com.cognizant.service.ApplyHomeLoanService;

@Controller
public class ApplyHomeLoanController {
	private static final Logger log = Logger.getLogger(ApplyHomeLoanController.class);
	@Autowired
	ApplyHomeLoanService applyHomeLoanService;

	@RequestMapping(value = "/applyHomeLoan", method = RequestMethod.GET)
	public String getHomeLoan(@ModelAttribute("homeLoan") @Valid ApplyHomeLoan homeLoan, BindingResult result,
			Model model, @RequestParam("msg") String msg) {
		model.addAttribute("homeLoan", new ApplyHomeLoan());
		model.addAttribute("msg", msg);
		return "applyHomeLoan";
	}

	@RequestMapping(value = "/applyHomeLoan", method = RequestMethod.POST)
	public String initiateHomeLoan(@ModelAttribute("homeLoan") @Valid ApplyHomeLoan homeLoan, BindingResult result,
			Model model, @RequestParam("msg") String msg) {
		long account_number = Long.parseLong(msg);
		try {
			log.info("in controller");
			applyHomeLoanService.updateLoanDetails(account_number, homeLoan);
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
		} catch (BankManagementException exp) {
			String sb = exp.getMessage();
			String[] sb1 = sb.split(":");
			result.rejectValue(sb1[0].toString(), "", sb1[1].toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("m1", homeLoan.getLoanAccountNumber());
		if (result.hasErrors()) {
			return "applyHomeLoan";
		}
		return "successHomeLoan";
	}
}

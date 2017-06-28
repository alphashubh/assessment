package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.ViewHomeLoanDAO;
import com.cognizant.entity.ApplyHomeLoan;
import com.cognizant.entity.UserDetails;

@Controller
public class ViewHomeLoanController {

	@Autowired
	ViewHomeLoanDAO viewLoanDao;

	@RequestMapping(value = "/viewHomeloan", method = RequestMethod.GET)
	public String getHomeLoan(Model model, @RequestParam("msg") String msg) {

		model.addAttribute("msg", msg);
		return "viewHomeLoan";
	}

	@RequestMapping(value = "/viewHomeloan1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserDetails> getList(Model model, @RequestParam("msg") String msg) {
		long accountNumber = Long.parseLong(msg);
		UserDetails userDetails = viewLoanDao.retrieveLoanDetails(accountNumber);
		userDetails.setApply(null);
		userDetails.setTransactionDetails(null);
		List<UserDetails> List = new ArrayList<UserDetails>();
		List<ApplyHomeLoan> hLoan = new ArrayList<ApplyHomeLoan>();
		List<ApplyHomeLoan> newLoan = new ArrayList<ApplyHomeLoan>();
		hLoan = userDetails.getHomeLoan();
		for (int i = 0; i < hLoan.size(); i++) {
			ApplyHomeLoan obj = hLoan.get(i);
			obj.setUserDetails(null);
			newLoan.add(obj);
		}
		userDetails.setHomeLoan(newLoan);
		List.add(userDetails);
		return List;
	}

}

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

import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;

@Controller
public class ViewTransactionController {

	@Autowired
	PerformTransactionService performtransactionservice;

	@RequestMapping(value = "/viewtransaction", method = RequestMethod.GET)
	public String getList(Model model, @RequestParam("msg") String msg) {
		model.addAttribute("msg", msg);
		return "ViewTransactionDetails";
	}

	@RequestMapping(value = "/viewtransaction1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TransactionDetails> list(Model model, @RequestParam("msg") String msg) {
		long accountNumber = Long.parseLong(msg);
		System.out.println(performtransactionservice.retriveTransactionDetails(accountNumber));
		List<TransactionDetails> t = new ArrayList<TransactionDetails>();
		t = performtransactionservice.retriveTransactionDetails(accountNumber);
		System.out.println("Controller" + t);
		return t;
	}
}

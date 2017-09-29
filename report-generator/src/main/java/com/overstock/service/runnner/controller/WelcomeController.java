/**
 * 
 */
package com.overstock.service.runnner.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overstock.service.runnner.service.ReportService;
/**
 * @author Madhav Pandey
 * @date Sep 28, 2017
 */
@Controller
public class WelcomeController
{
		@Autowired
		private ReportService reportService;
		
		@RequestMapping("/")
		public String welcome() {
			/*model.put("message", this.message);*/
			return "welcome";
		}
		
		@GetMapping(value="/generateReport")
		public String getReport(Map<String, Object> model){
			String output = this.reportService.callReportGenerator();
			model.put("message", output);
			//System.out.println("Call the method here");
			return "result";
		}
}

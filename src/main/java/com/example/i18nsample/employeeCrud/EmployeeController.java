package com.example.i18nsample.employeeCrud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("international")
public class EmployeeController {
	private List<Employee> employees = new ArrayList<>();

	@GetMapping("/")
	public String renderListPage(Model model) {

		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employees);
		return "international";
	}

	@PostMapping("/add")
	public String handleAdd(@ModelAttribute @Validated Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new RuntimeException(bindingResult.getObjectName());
		}
		System.out.println(employee);
		employees.add(employee);
		return "redirect:/international/";

	}

	@GetMapping("/jsonlist")
	@ResponseBody
	public List<Employee> returnJsonData() {

		return employees;
	}

	@PutMapping("/jsonlist")
	@ResponseBody
	public List<Employee> returnJsonDataFromPut() {

		return employees;
	}

}

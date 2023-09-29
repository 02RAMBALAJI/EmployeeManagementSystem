package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmployeeManagementSystem.Service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allemplist", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/add")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("updateform/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") long id){
        employeeService.deleteById(id);
        return "redirect:/";
    }


}


//@Controller
//public class EmployeeController {
//	
//	@Autowired
//	private EmployeeService employeeService;
//	
//	@GetMapping("/")
//	public String viewHomePage(Model model) {
//		model.addAttribute("allemplist",employeeService.getAllEmployee());
//		return "index";
//	}
//	
//	@GetMapping("/add")
//	public String addNewEmployee(Model model) {
//		Employee employee = new Employee();
//		model.addAttribute("employee",employee);
//		return "addemployee";
//	}
//	
//	@PostMapping("/save")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//		employeeService.save(employee);
//		return "redirect:/";
//	}
//	
//	@GetMapping("updateform/{id}")
//	public String updateForm(@PathVariable(value = "id") long id, Model model) {
//		Employee employee = employeeService.getById(id);
//		model.addAttribute("employee",employee);
//		return "update";
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public String deleteById(@PathVariable(value = "id") long id) {
//		employeeService.deleteById(id);
//		return "redirect:/";
//	}
//	
//	
//	
//	
//}
//
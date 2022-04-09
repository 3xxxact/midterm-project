package com.example.midterm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/")
    public String homePage(){
        return "home";
    }

    @GetMapping(path = "/getEmployees")
    public String tablePage(Model model){
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employeeList", employeeList);
        return "table";
    }

    @GetMapping(path = "/addNewEmployee")
    public String newEmployeePage(Model model){
        model.addAttribute("employee", new Employee());
        return "newEmployee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(
            @ModelAttribute ("employee") Employee employee
    ){
        employeeService.saveEmployee(employee);
        return "redirect:/getEmployees";
    }

    @RequestMapping(path = "/edit/{employeeId}")
    public ModelAndView editEmployee(
            @PathVariable ("employeeId") Long employeeId
    ){
        ModelAndView modelAndView = new ModelAndView("newEmployee");
        Employee employee = employeeService.getEmployeeById(employeeId);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{employeeId}")
    public String deleteEmployee(
            @PathVariable ("employeeId") Long employeeId
    ){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/table";
    }
}

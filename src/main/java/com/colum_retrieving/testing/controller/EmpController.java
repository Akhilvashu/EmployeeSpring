package com.colum_retrieving.testing.controller;

import com.colum_retrieving.testing.entity.Department;
import com.colum_retrieving.testing.entity.Employee;
import com.colum_retrieving.testing.service.DepService;
import com.colum_retrieving.testing.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmpController {

    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService SService;
    @Autowired
    private DepService DService;

    @GetMapping(path = "/form")
    private String ShowingStudentlist(Model model) {
        List<String> listofDepartments = SService.getDepartmentNames();
        model.addAttribute("yourList", listofDepartments);
        logger.info("code is working");
        return "employeeform";
    }

    @PostMapping(path = "/form")
    private String SaveEmployee(@ModelAttribute Employee employee, @RequestParam("Department") List<String> Departmentname) {

        List<Department> selectedDepartments = DService.findDepartmentsByNames(Departmentname);
        employee.setDepartments(new HashSet<>(selectedDepartments));
        SService.save(employee);
        return "redirect:/list";
    }

    @GetMapping(path = "/list")
    private String employeelist(Model model) {
        List<String> listofDepartments = SService.getDepartmentNames();
        model.addAttribute("yourList", listofDepartments);
        model.addAttribute("employeelist", SService.list());
        return "employeelist";
    }

    @GetMapping(path = "/sort")
    private String Sortedlist(Model model) {
        model.addAttribute("employeelist", SService.SortedEmp());
        return "employeelist";
    }

    @GetMapping(path = "/dsort")
    private String DSortedlist(Model model) {
        model.addAttribute("employeelist", SService.DSortedEmp());
        return "employeelist";
    }

    @GetMapping(path = "/search")
    private String Search(@RequestParam(required = false) String depname,
                          @RequestParam(required = false) Long Salary,
                          @RequestParam(required = false) String name,
                          Model model) {
        List<String> listofDepartments = SService.getDepartmentNames();
        model.addAttribute("yourList", listofDepartments);

        try {
            if (depname != null) {
                Department ParticularDep = DService.dep(depname);
                List<Employee> EmployeeOfParticularDep = new ArrayList<>(ParticularDep.getEmployees());
                model.addAttribute("employeelist", EmployeeOfParticularDep);
            } else if (Salary != null) {
                List<Employee> EmployeewithSalary = SService.FindbySalary(Salary);
                model.addAttribute("employeelist", EmployeewithSalary);
            } else if (name != null && !name.isEmpty()) {
                List<Employee> EmployeewithName = SService.FindbyName(name);
                model.addAttribute("employeelist", EmployeewithName);
            } else {
                return "redirect:/list";
            }
        } catch(NullPointerException e) {
            return "redirect:/list";
            }

        return "employeelist";
}
}
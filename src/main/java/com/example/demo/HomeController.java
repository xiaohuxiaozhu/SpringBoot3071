package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployRepository employRepository;

    @RequestMapping("/")
    public String index(Model model){
        //First let's create an employee
        Employee employee=new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        //Now Let's create a laptop
        Laptop laptop=new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");


        //Add the laptop to the employee
        employee.setLaptop(laptop);

        //save the employee to the database
        employRepository.save(employee);

        //Grab all the employees from the database and send them to the template
        model.addAttribute("employees", employRepository.findAll());
        return "index";


    }
}

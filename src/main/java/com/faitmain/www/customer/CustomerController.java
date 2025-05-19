package com.faitmain.www.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.faitmain.www.model.Customer;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerController {
   
final String path = "customer/";
   
   @Autowired
   CustomerService service;
   
   @GetMapping("/list")
   String list(Model model) {
      List<Customer> list = service.list();
      
      model.addAttribute("list", list);
      
      return path + "list";
   }
   
   @GetMapping("/add")
   String add(Model model) {
       model.addAttribute("customer", new Customer());
       return path + "add";
   }
   
   @PostMapping("/add")
   String add(Customer item) {
      service.add(item);
      
      return "redirect:list";
   }
   
   @GetMapping("/delete/{id}")
   String delete(@PathVariable String id) {
      service.delete(id);
      
      return "redirect:../list";
   }
   
   @GetMapping("/update/{id}")
   String update(@PathVariable String id, Model model) {
      Customer item = service.item(id);
      
      model.addAttribute("item", item);
      
      return path + "update";
   }
   
   @PostMapping("/update/{id}")
   String update(@PathVariable String id, Customer item) {
      item.setId(id);
      
      service.update(item);
      
      return "redirect:/customer/list";
   }
   
   @GetMapping("/login")
   public String loginPage() {
       return path + "login";
   }

   @PostMapping("/login")
   public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session, Model model) {
       System.out.println(id);
       System.out.println(password);
	   Customer customer = service.login(id, password);
       
       if (customer != null) {
           session.setAttribute("loggedInCustomer", customer);
           return "redirect:/index";
       } else {
           model.addAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
           return path + "login";
       }
   }

   @GetMapping("/customer/logout")
   public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:/index";
   }

}

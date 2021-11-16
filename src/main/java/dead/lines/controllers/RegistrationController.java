package dead.lines.controllers;


import dead.lines.entities.Customer;
import dead.lines.entities.Role;
import dead.lines.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(HttpServletRequest request, Map<String, Object> model) {
//        model.put("message", "");
     /*   Customer customer = customerService.findByUsername(request.getRemoteUser());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", customer);
        List<Customer> customers = customerService.allCustomers();*/
        if(request.isUserInRole("USER")) {
            model.put("destination", -1);
            return "redirect:/homePage";
//            return modelAndView;
        }
/*        modelAndView.setViewName("main");
        modelAndView.addObject("customerList", customers);*/
        return "main";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String addUser(Customer customer, Map<String, Object> model) {
        model.put("message", "");
//        if(allLogins(customerService.allCustomers()).contains(customer.getLogin()))
        if(customerService.findByUsername(customer.getUsername()) != null)
            {
                model.put("message", "User with this login already exists!");
                return "redirect:/registration";
            }
        else {
            if(customer.getUsername().isEmpty())
            { model.put("message", "Login field can't be empty");
                return "redirect:/registration";}

            if(customer.getPassword().isEmpty())
            { model.put("message", "Password field can't be empty");
                return "redirect:/registration";}

            if(customer.getName().isEmpty())
            { model.put("message", "Name field can't be empty");
                return "redirect:/registration";}

//            customer.setActive(true);
//            customer.setName("Customer");
            customer.setRoles(Collections.singleton(Role.USER));
            customerService.add(customer);
            model.put("destination", -1);
            return "redirect:/homePage";

        }



    }



/*
    public List<String> allLogins(List<Customer> customers) {
        List<String> logins = new ArrayList<>();
        for (Customer customer:
              customers) {
            logins.add(customer.getLogin());
        }
        return logins;
    }*/

}

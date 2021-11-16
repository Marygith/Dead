package dead.lines.controllers;


import dead.lines.entities.Customer;
import dead.lines.service.CustomerService;
import dead.lines.service.DeadlineService;
import dead.lines.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomersController {

//    private CustomerService customerService= new CustomerServiceImpl();

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private SpaceService spaceService;

    @Autowired
    public void setSpaceService(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    private DeadlineService deadlineService;

    @Autowired
    public void setDeadlineService(DeadlineService deadlineService) {
        this.deadlineService = deadlineService;
    }



    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView allCustomers(HttpServletRequest request) {
        Customer customer = customerService.findByUsername(request.getRemoteUser());
        List<Customer> customers = customerService.allCustomers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customers");
        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("user", customer);
        return modelAndView;
    }

/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customers");
        customerService.add(customer);
        return modelAndView;
    }
*/



/*    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customers");
        customerService.edit(customer);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Customer customer = customerService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }*/


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customers");
//        customer.setId(5);
        customerService.add(customer);
        return modelAndView;
    }

}





/*

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }*/

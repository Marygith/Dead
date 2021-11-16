package dead.lines.controllers;

import dead.lines.entities.Customer;
import dead.lines.entities.Permission;
import dead.lines.service.CustomerService;
import dead.lines.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {


    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private PermissionService permissionService;

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request,  Map<String, Object> model) {
        Customer customer = customerService.findByUsername(request.getRemoteUser());
//        List<Customer> customers = customerService.allCustomers();
        ModelAndView modelAndView = new ModelAndView();
        model.put("destination", -1);
        modelAndView.setViewName("homePage");
//        modelAndView.addObject("customerList", customers);
        modelAndView.addObject("user", customer);
        return modelAndView;
    }

    @RequestMapping(value = "/redirection", method = RequestMethod.POST)
    public String redirection(HttpServletRequest request, Map<String, Object> model) {
       String code =  request.getParameter("code");
       Customer user = customerService.findByUsername(request.getRemoteUser());
       Permission permission = permissionService.getById(Integer.parseInt(code));
       if(permission != null && permission.getUserId().equals(user.getId())) {
           model.put("message", "Code confirmed");
           user.setCode(Integer.parseInt(code));
           model.put("destination", permissionService.getById(Integer.parseInt(code)).getSpaceId());
       }
       else {
           model.put("message", "Code is not confirmed");
           model.put("destination", -1);
       }
        user.setCode(Integer.parseInt(code));
       customerService.edit(user);
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/setPermission", method = RequestMethod.POST)
    public String setPermission(HttpServletRequest request, Map<String, Object> model) {
        String permissionCode =  request.getParameter("permissionCode");
        Customer user = customerService.findByUsername(request.getRemoteUser());
        Permission permission = new Permission();
        permission.setSpaceId(user.getSpaceId());
        permission.setUserId(Integer.parseInt(permissionCode));
        permissionService.add(permission);
//        permissionService.allPermissions().get(permissionService.allPermissions().size() - 1);
        model.put("message1", "Permission is set, access code is " + permissionService.allPermissions().get(permissionService.allPermissions().size() - 1).getId());
        return "redirect:/homePage";
    }

}

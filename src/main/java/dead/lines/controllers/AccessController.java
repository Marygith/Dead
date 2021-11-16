package dead.lines.controllers;


import dead.lines.entities.Customer;
import dead.lines.service.CustomerService;
import dead.lines.service.DeadlineService;
import dead.lines.service.PermissionService;
import dead.lines.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccessController {


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

    @RequestMapping(value = "/space/edit/{number}")
    public String badEditRequest(HttpServletRequest request) {
        Customer user = customerService.findByUsername(request.getRemoteUser());
       Integer code = user.getCode();
       return "redirect:/space/" + permissionService.getById(code).getSpaceId();
    }
    @RequestMapping(value = "/space/delete/{number}")
    public String badDeleteRequest(HttpServletRequest request) {
        Customer user = customerService.findByUsername(request.getRemoteUser());
        Integer code = user.getCode();
        return "redirect:/space/" + permissionService.getById(code).getSpaceId();
    }

    @RequestMapping(value = "/space/createDeadline")
    public String badCreateRequest(HttpServletRequest request) {
        Customer user = customerService.findByUsername(request.getRemoteUser());
        Integer code = user.getCode();
        return "redirect:/space/" + permissionService.getById(code).getSpaceId();
    }



}

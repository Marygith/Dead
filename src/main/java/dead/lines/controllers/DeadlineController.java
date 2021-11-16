package dead.lines.controllers;


import dead.lines.entities.Customer;
import dead.lines.entities.Deadline;
import dead.lines.entities.Space;
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

@Controller
public class DeadlineController {

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


    @RequestMapping(value = "/createDeadline", method = RequestMethod.GET)
    public ModelAndView createDeadline(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Customer user = customerService.findByUsername(request.getRemoteUser());
        Space space = spaceService.getById(user.getSpaceId());
        Deadline deadline = new Deadline();
        deadline.setId(space.getSpaceId());
        modelAndView.addObject("space", space);
        modelAndView.addObject("user", user);
        modelAndView.addObject("deadline", deadline);
        modelAndView.setViewName("createDeadline");
        return modelAndView;

    }



    @RequestMapping(value = "/createDeadline", method = RequestMethod.POST)
    public String newDeadline(HttpServletRequest request, @ModelAttribute("deadline") Deadline deadline) {
        ModelAndView modelAndView = new ModelAndView();
        Customer user = customerService.findByUsername(request.getRemoteUser());
        Space space = spaceService.getById(user.getSpaceId());
        deadline.setSpaceId(spaceService.getById(user.getSpaceId()).getSpaceId());
        if(deadline.getImportance() == 1) {deadline.setColor("#4C0101");}
        if(deadline.getImportance() == 2) {deadline.setColor("#4C3601");}
        if(deadline.getImportance() == 3) {deadline.setColor("#014C02");}

        deadlineService.add(deadline);
/*        modelAndView.addObject("space", space);
        modelAndView.addObject("user", user);
        modelAndView.addObject("deadline", deadline);
        modelAndView.setViewName("createDeadline");*/
        return "redirect:/space";

    }
}

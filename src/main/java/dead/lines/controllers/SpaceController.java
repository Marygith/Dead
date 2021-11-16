package dead.lines.controllers;


import dead.lines.entities.Customer;
import dead.lines.entities.Deadline;
import dead.lines.entities.Space;
import dead.lines.service.CustomerService;
import dead.lines.service.DeadlineService;
import dead.lines.service.PermissionService;
import dead.lines.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpaceController {

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

    private PermissionService permissionService;

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping(value = "/space", method = RequestMethod.GET)
    public ModelAndView space(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Customer user = customerService.findByUsername(request.getRemoteUser());
//        List<Space> spaces = spaceService.allSpaces();
        Space space;
        if(spaceService.getById(user.getSpaceId()) != null)
        {
            space = spaceService.getById(user.getSpaceId());
        }
        else {
            space = new Space();
            spaceService.add(space);
            user.setSpaceId(space.getSpaceId());
            customerService.edit(user);
        }
        List<Deadline> deadlines = new ArrayList<>();
        for (Deadline deadline: deadlineService.allDeadlines()) {
            if(deadline.getSpaceId().equals(space.getSpaceId())) {deadlines.add(deadline);}
        }
        modelAndView.addObject("authority", "OWNER");
        modelAndView.addObject("deadlines", deadlines);
        modelAndView.addObject("space", space);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("space");
        return modelAndView;

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDeadline(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/space");
        Deadline deadline = deadlineService.getById(id);
        deadlineService.delete(deadline);
        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editDeadline(@ModelAttribute("deadline") Deadline deadline) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/space");
        if(deadline.getImportance() == 1) {deadline.setColor("#4C0101");}
        if(deadline.getImportance() == 2) {deadline.setColor("#4C3601");}
        if(deadline.getImportance() == 3) {deadline.setColor("#014C02");}
        deadlineService.edit(deadline);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDl(@PathVariable("id") int id) {
        Deadline deadline = deadlineService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("deadline", deadline);
        return modelAndView;
    }

    @RequestMapping(value = "/space/{destination}", method = RequestMethod.GET)
    public ModelAndView spaceGuest(HttpServletRequest request, @PathVariable("destination") int id) {

        ModelAndView modelAndView = new ModelAndView();
        Customer user = customerService.findByUsername(request.getRemoteUser());
//        List<Space> spaces = spaceService.allSpaces();
        Space space = spaceService.getById(id);
        if(permissionService.getById(user.getCode()) == null || !permissionService.getById(user.getCode()).getSpaceId().equals(id)) {
            modelAndView.setViewName("redirect:/homePage");
        }
        else {
            List<Deadline> deadlines = new ArrayList<>();
            for (Deadline deadline : deadlineService.allDeadlines()) {
                if (deadline.getSpaceId().equals(space.getSpaceId())) {
                    deadlines.add(deadline);
                }
            }
            modelAndView.addObject("authority", "GUEST");
            modelAndView.addObject("deadlines", deadlines);
            modelAndView.addObject("space", space);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("space");
        }
        return modelAndView;

    }

}

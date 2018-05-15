package cn.gdou.web.controller;

import cn.gdou.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("spring")
public class SpringmvcController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "order",method = RequestMethod.GET)
    public String showOrder(Model model){
        model.addAttribute("order",orderService.saveOrder());
        return "order";
    }
}



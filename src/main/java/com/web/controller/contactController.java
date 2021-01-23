package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
public class contactController extends baseController {
    @GetMapping(value = {"/", ""})
    public ModelAndView contactPage(HttpServletRequest req, HttpServletResponse resp) {
        _mav.setViewName("contact");
        getCart(req ,resp);
        return _mav;
    }
}

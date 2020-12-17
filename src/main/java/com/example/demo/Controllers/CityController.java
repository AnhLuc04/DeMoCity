package com.example.demo.Controllers;


import com.example.demo.Model.City;
import com.example.demo.Model.Nation;
import com.example.demo.service.city.CityService;
import com.example.demo.service.nation.NationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;

    @ModelAttribute("nation")
    public Iterable<Nation> ShowAllProvinces() {
        return nationService.findAll();
    }


    @GetMapping("list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("city/listCity");
        Iterable citys = cityService.findAll();
        modelAndView.addObject("city", citys);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("city/createCity");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveCity(@Validated @ModelAttribute("city")City city, BindingResult bindingResult, @RequestParam int acreage){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("city/createCity");
            modelAndView.addObject("message", "Cú pháp sai bạn nhé");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("city/createCity");
        cityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }

    @GetMapping("/edit/{ID}")
    public ModelAndView updateCity(@PathVariable Long ID) throws NotFoundException {
        Optional<City> city = cityService.findById(ID);
        if(city!= null) {
            ModelAndView modelAndView = new ModelAndView("city/editCity");
            modelAndView.addObject("city",city);
            return modelAndView;
      }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
        @PostMapping("/edit")
    public ModelAndView updateCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
            if (bindingResult.hasFieldErrors()) {
                ModelAndView modelAndView = new ModelAndView("city/editCity");
                modelAndView.addObject("message", "Cú pháp sai bạn nhé");
                return modelAndView;
            }
            cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/listCity");

        Iterable <City> citys = cityService.findAll();

        modelAndView.addObject("city", citys);
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }
    @GetMapping("/delete/{ID}")
    public ModelAndView showDeleteForm(@PathVariable Long ID){
        cityService.remove(ID);
        Iterable<City> city=  cityService.findAll();
        if(city != null) {
            return new ModelAndView("redirect:/city/list");
        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @GetMapping("/detail/{ID}")
    public ModelAndView showLists(@PathVariable Long ID) throws NotFoundException {
        ModelAndView modelAndView= new ModelAndView("city/list-detail");
        Optional<City> city = cityService.findById(ID);
        if(city.get()==null){
            return new ModelAndView("error.404");
        }else {
            modelAndView.addObject("city", city.get());
            return modelAndView;
        }
    }
}

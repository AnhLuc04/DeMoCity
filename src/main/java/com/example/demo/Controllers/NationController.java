package com.example.demo.Controllers;

import com.example.demo.Model.City;
import com.example.demo.Model.Nation;
import com.example.demo.service.nation.NationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("nation")
public class NationController {
    @Autowired
    private NationService nationService;
    @GetMapping("list")
    public ModelAndView listNation(){
        Iterable<Nation>nations = nationService.findAll();
        ModelAndView modelAndView = new ModelAndView("nation/listNation");
        modelAndView.addObject("nations",nations);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("nation/create");
        modelAndView.addObject("nation", new Nation());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveNation(@Validated @ModelAttribute("nation") Nation nation, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("nation/create");
            modelAndView.addObject("message", "Cú pháp sai bạn nhé");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("nation/create");
        nationService.save(nation);
        modelAndView.addObject("nation", new Nation());
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }

    @GetMapping("/edit/{ID}")
    public ModelAndView updateNation(@PathVariable Long ID) throws NotFoundException {
        Optional<Nation> nation = nationService.findById(ID);
        if(nation != null) {
            ModelAndView modelAndView = new ModelAndView("nation/edit");
            modelAndView.addObject("nation",nation);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView updateNation(@ModelAttribute("nation") Nation nation){
        nationService.save(nation);
        ModelAndView modelAndView = new ModelAndView("redirect:/nation/list");
        List<Nation> nations= (List<Nation>) nationService.findAll();;
        modelAndView.addObject("nation", nations);
        modelAndView.addObject("message", "OKE BẠN NHÉ");
        return modelAndView;
    }
    @GetMapping("/delete-nation/{ID}")
    public ModelAndView showDeleteForm(@PathVariable Long ID){
       nationService.remove(ID);
        List<Nation> nation= (List<Nation>) nationService.findAll();
        if(nation != null) {
            return new ModelAndView("redirect:/nation/list");
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}

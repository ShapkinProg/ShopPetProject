package ru.petProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.petProject.dao.PersonDAo;
import ru.petProject.dao.PicDAO;
import ru.petProject.models.pic;

import javax.validation.Valid;

@Controller
public class mainController {

    private final PersonDAo personDAo;
    private final PicDAO picDAO;

    @Autowired
    public mainController(PersonDAo personDAo, PicDAO picDAO) {
        this.personDAo = personDAo;
        this.picDAO = picDAO;
    }

    @GetMapping("/")
    public String index(Model model)//получаемся всех людей из дао и передаём в предсатвление
    {
        model.addAttribute("pics", picDAO.index());
        model.addAttribute("people", personDAo.index());
        return "people/main";
    }
        @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("pic", picDAO.show(id));
        return "people/show"; // поулчение 1 челика из дао п передат ьв представние
    }
        @GetMapping("/new")
    public String newPerson(@ModelAttribute("pic") pic pic)
    {
        return "people/new";
    }
    @PostMapping
    public String create(@ModelAttribute("pic") @Valid pic pic,
                         BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "people/new";
        picDAO.save(pic);
        return "redirect:/";
    }

        @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("pic", picDAO.show(id));
        return "people/edit";
    }
        @PatchMapping("/{id}")
    public String update(@ModelAttribute("pic") @Valid pic pic,
                         BindingResult bindingResult, @PathVariable("id") int id)
    {
        if(bindingResult.hasErrors())
            return "people/edit";
        picDAO.update(id, pic);
        return "redirect:/";
    }
        @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id)
    {
        picDAO.delete(id);
        return "redirect:/";
    }
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model)
//    {
//        model.addAttribute("person", personDAo.show(id));
//        return "people/show"; // поулчение 1 челика из дао п передат ьв представние
//    }
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("person") person person)
//    {
//        return "people/new";
//    }
//    @PostMapping
//    public String create(@ModelAttribute("person") @Valid person person,
//                         BindingResult bindingResult)
//    {
//        if(bindingResult.hasErrors())
//            return "people/new";
//        personDAo.save(person);
//        return "redirect:/people";
//    }
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id)
//    {
//        model.addAttribute("person", personDAo.show(id));
//        return "people/edit";
//    }
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") @Valid person person,
//                         BindingResult bindingResult, @PathVariable("id") int id)
//    {
//        if(bindingResult.hasErrors())
//            return "people/edit";
//        personDAo.update(id, person);
//        return "redirect:/people";
//    }
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id)
//    {
//        personDAo.delete(id);
//        return "redirect:/people";
//    }
}

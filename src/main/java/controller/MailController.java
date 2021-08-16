package controller;

import model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.MailService;

@Controller
public class MailController {
    private MailService mailService = new MailService();
    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listMail", mailService.list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("listLanguages", mailService.listLanguages);
        modelAndView.addObject("listPageSize", mailService.listPageSize);
        modelAndView.addObject("mail", new Mail());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("mail", mailService.list.get(index));
        modelAndView.addObject("listLanguages", mailService.listLanguages);
        modelAndView.addObject("listPageSize", mailService.listPageSize);
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int index) {
        mailService.delete(index);
        return new ModelAndView("redirect:/");
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("mail") Mail mail) {
        mailService.save(mail);
        return new ModelAndView("redirect:/");
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("mail") Mail mail, @RequestParam int index) {
        mailService.edit(index, mail);
        return new ModelAndView("redirect:/");
    }
}

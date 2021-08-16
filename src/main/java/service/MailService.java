package service;

import model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailService {
    public List<Mail> list = new ArrayList<>();
    public String[] listLanguages = {"English", "Vietnamese", "Japanese", "Chinese"};
    public int[] listPageSize = {5, 10, 15, 25, 50, 100};
    public MailService() {
        list.add(new Mail("English", 25, false, "Thor King, Asgard"));
        list.add(new Mail("Vietnamese", 5, false, "John, Sena"));
        list.add(new Mail("Japanese", 100, true, "Messi, Lionel"));
        list.add(new Mail("English", 25, true, "Puth, Charlie"));
    }

    public void save(Mail mail) {
        list.add(mail);
    }
    public void delete(int index) {
        list.remove(index);
    }
    public void edit(int index, Mail mail) {
        list.set(index, mail);
    }

}

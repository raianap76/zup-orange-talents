package zupdesafio.api.com.controller.Form;

import java.time.LocalDate;

import zupdesafio.api.com.model.User;

public class UserForm {
    public String name;
    public String email;
    private int CPF;
    public LocalDate birthDate;

    public User convert(UserForm form) {
        return new User(form.name, form.email, form.CPF, form.birthDate);
    }
}

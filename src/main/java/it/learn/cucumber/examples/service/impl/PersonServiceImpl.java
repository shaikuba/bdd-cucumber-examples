package it.learn.cucumber.examples.service.impl;

import it.learn.cucumber.examples.context.LoginContext;
import it.learn.cucumber.examples.service.PersonService;
import it.learn.cucumber.examples.shopping.Person;

public class PersonServiceImpl implements PersonService {
    @Override
    public void login(Person person) {
        if (!LoginContext.hasLogin()) {
            LoginContext.login(person);
        }
    }
}

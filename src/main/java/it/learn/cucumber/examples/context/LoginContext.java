package it.learn.cucumber.examples.context;

import it.learn.cucumber.examples.shopping.Person;

public class LoginContext {

    private static ThreadLocal<Person> loginContext = new ThreadLocal<>();

    public static void login(Person person) {
        if (!hasLogin()) {
            if (person.getUsername() == null || person.getUsername().trim().equals("")) {
                throw new RuntimeException("Illegal username.");
            }
            loginContext.set(person);
        }
    }

    public static boolean hasLogin() {
        return loginContext.get() != null;
    }

    public static void loginRequired() {
        if (!hasLogin()) {
            throw new RuntimeException("Login is required.");
        }
    }

}

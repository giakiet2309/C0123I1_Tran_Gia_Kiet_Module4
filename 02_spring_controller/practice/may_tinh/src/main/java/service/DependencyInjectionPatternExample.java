package service;


import com.controller.UserController;

import javax.management.InstanceNotFoundException;

public class DependencyInjectionPatternExample  {

    public static void main(String[] args) throws InstanceNotFoundException {

        MessageService messageService = (MessageService) Injector.getInstance("messageService");
        UserController userController = new UserController(messageService);
        userController.send();
    }
}
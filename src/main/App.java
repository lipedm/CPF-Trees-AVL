package main;

import views.Console;

public class App {
    public static void main(String[] args) throws Exception {

        Console app = new Console();
        app = app.mainMenu(app);
        System.out.println("A aplicação foi finalizada, até mais :)\n\n");
    }

}

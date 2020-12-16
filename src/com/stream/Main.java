package com.stream;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.stream.controllers.LoginController;
import com.stream.controllers.SignupController;
import com.stream.viewmodels.LoginViewModel;
import com.stream.viewmodels.SignupViewModel;
import com.stream.views.LoginView;
import com.stream.views.SignupView;

import javax.swing.*;


public class Main {

    /**
     * Main method that runs first when starting the program
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.setupTheme();
        main.createGUI();
    }

    /**
     * Setup dark mode theme
     */
    public void setupTheme() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (Exception ex) {
            System.out.println("Failed to initialize theme");
        }
    }

    /**
     * Create Login frontpage
     */
    public void createGUI() {
        SignupViewModel viewModel = new SignupViewModel();
        SignupView view = new SignupView();

        SignupController controller = new SignupController(viewModel, view);
        controller.updateView();

//        LoginViewModel viewModel = new LoginViewModel();
//        LoginView view = new LoginView();
//
//        LoginController controller = new LoginController(viewModel, view);
//        controller.updateView();
    }
}

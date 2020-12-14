package com.stream.controllers;


import com.stream.listeners.LoginListener;
import com.stream.viewmodels.LoginViewModel;
import com.stream.views.LoginView;

public class LoginController extends BaseController {
    private LoginViewModel viewModel;
    private LoginView view;

    public LoginController(LoginViewModel viewModel, LoginView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    public void updateView() {
        view.updateView();
        view.addPasswordField(new LoginListener(view, viewModel));
        view.addLoginButton(new LoginListener(view, viewModel));

        pageController.setView(view.getPanel());
    }
}

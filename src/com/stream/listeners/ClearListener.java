package com.stream.listeners;

import com.stream.controllers.CatalogController;
import com.stream.controllers.FilterController;
import com.stream.controllers.PageController;
import com.stream.models.User;
import com.stream.models.UserManager;
import com.stream.viewmodels.CatalogViewModel;
import com.stream.views.CatalogView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClearListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.getCurrentUser();
        user.setMyListToggled(false);

        CatalogViewModel c = new CatalogViewModel();
        CatalogView cv = new CatalogView();
        FilterController filterController = FilterController.getInstance();
        filterController.setCatalog(c, cv);

        CatalogController cc = new CatalogController(c, cv);
        cc.updateView();

        PageController pageController = PageController.getInstance();
        pageController.setView(cv.getPanel());
    }
}

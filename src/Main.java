import com.formdev.flatlaf.FlatDarculaLaf;
import models.SingletonFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.createGUI();
    }

    public void createGUI() {

        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (Exception ex) {
            System.out.println("Failed to initialize theme");
        }
        JFrame frame = SingletonFrame.getInstance();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stream Lime");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Catalog c = new Catalog();
        CatalogView cv = new CatalogView();

        CatalogController cc = new CatalogController(c, cv);
        cc.updateView();

    }
}

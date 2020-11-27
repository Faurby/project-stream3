import models.Media;
import models.Movie;
import models.Series;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;

public class CatalogView {

    private JFrame frame;
    private JPanel mainPanel;
    private Catalog c;

    public CatalogView(Catalog c) {
        frame = new JFrame();
        this.c = c;
    }

    public void updateGUI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Streaming service");
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        mainPanel = new JPanel();

        //TODO: Make this less scuffed
        mainPanel.setPreferredSize(new Dimension(800, 10000));

        JScrollPane scroll = new JScrollPane(mainPanel);
        scroll.setSize(new Dimension(800, 600));

        mainPanel.setLayout(new GridLayout(34, 6, 20, 20));

        frame.add(scroll);

        List<Media> mediaList = c.getMediaList();

        for (Media m : mediaList) {
            addMedia(m);
        }
        frame.pack();
        frame.setVisible(true);
    }

    public void addMedia(Media m) {
        JPanel mediaPanel = new JPanel();
        mediaPanel.setLayout(new BorderLayout());

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(m.getImagePath());
            BufferedImage pic = ImageIO.read(is);

            int width = pic.getWidth();
            int height = pic.getHeight();

            //TODO: Handle max width/height

            JLabel imageLabel = new JLabel();
            imageLabel.setSize(new Dimension(width, height));

            JLabel titleLabel = new JLabel(m.getTitle());
            titleLabel.setSize(new Dimension(width, height));

            imageLabel.setIcon(new ImageIcon(pic));
            imageLabel.setSize(new Dimension(width, height));

            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            titleLabel.setHorizontalAlignment(JLabel.CENTER);

            mediaPanel.add(imageLabel, BorderLayout.CENTER);
            mediaPanel.add(titleLabel, BorderLayout.PAGE_END);

        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPanel.add(mediaPanel);
    }
}

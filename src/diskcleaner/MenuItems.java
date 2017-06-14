package diskcleaner;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuItems extends JPanel {

    public static JButton fullButton;
    public static JButton homeButton;
    public static JButton prefetchButton;
    public static JButton tempButton;
    public static JButton userButton;

    public MenuItems() throws IOException {

        setBounds(0, 0, 200, 800);
        setLayout(null);
        setBackground(Color.white);

        homeButton = new JButton("HOME");
        homeButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        homeButton.setBackground(Color.white);
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        Image img = ImageIO.read(getClass().getResource("/images/home.PNG"));
        homeButton.setIcon(new ImageIcon(img));

        fullButton = new JButton("FullClean");
        fullButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fullButton.setOpaque(false);
        fullButton.setContentAreaFilled(false);
        fullButton.setFocusPainted(false);
        Image img1 = ImageIO.read(getClass().getResource("/images/full.PNG"));
        fullButton.setIcon(new ImageIcon(img1));

        prefetchButton = new JButton("Prefetch");
        prefetchButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        prefetchButton.setOpaque(false);
        prefetchButton.setContentAreaFilled(false);
        prefetchButton.setFocusPainted(false);
        Image img2 = ImageIO.read(getClass().getResource("/images/folder.PNG"));
        prefetchButton.setIcon(new ImageIcon(img2));

        tempButton = new JButton("Temp");
        tempButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tempButton.setOpaque(false);
        tempButton.setContentAreaFilled(false);
        tempButton.setFocusPainted(false);
        Image img3 = ImageIO.read(getClass().getResource("/images/folder.PNG"));
        tempButton.setIcon(new ImageIcon(img3));

        userButton = new JButton("%Temp%");
        userButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        userButton.setOpaque(false);
        userButton.setContentAreaFilled(false);
        userButton.setFocusPainted(false);
        Image img4 = ImageIO.read(getClass().getResource("/images/folder.PNG"));
        userButton.setIcon(new ImageIcon(img4));

        homeButton.setBounds(40, 40, 200, 30);

        fullButton.setBounds(40, 100, 180, 30);
        prefetchButton.setBounds(40, 160, 200, 30);
        tempButton.setBounds(40, 220, 200, 30);
        userButton.setBounds(40, 280, 200, 30);

        homeButton.addActionListener(e -> {
            DiskCleaner.setRightComponent(new HomeView());
        });
        tempButton.addActionListener(e -> {

            DiskCleaner.setRightComponent(
                    Folders.getService(services.Services.getServices(
                                    "C:\\Windows\\Temp").toArray(), "Temp Files"));//calls method getservice
        });
        prefetchButton.addActionListener(e -> {
            DiskCleaner.setRightComponent(
                    Folders.getService(services.Services.getServices(
                                    "C:\\Windows\\Prefetch").toArray(),
                            "Prefetch Files"));

        });
        userButton.addActionListener(e -> {
            DiskCleaner.setRightComponent(
                    Folders.getService(services.Services.getServices(""
                                    + "C:\\Users\\FRIDAH\\AppData\\Local\\Temp"
                            ).toArray(), "%Temp%"));

        });
        fullButton.addActionListener(e -> {
            DiskCleaner.setRightComponent(
                    Folders.getService(services.Services.
                            getFullCleanFiles().toArray(), "All Files"));
        });

        add(homeButton);
        add(fullButton);
        add(prefetchButton);
        add(tempButton);
        add(userButton);

    }

}

package diskcleaner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DiskCleaner extends JFrame {

    public static JSplitPane splitPane, splitpane1;
    public static JPanel panelRight, panelLeft, panelLeft1, panelSouth, panelNorth, panel, panel1;
    public static JButton deleteAll, deletePrefetch, deleteTemp, deleteTem2, exit;
    public static JLabel imageLabel, label;
    public static JLabel prefetchButton;
    public static JLabel tempButton;
    public static JLabel userButton;
    public static JLabel label1;
    public static JTextField text1;
    public static JTextField text2;
    public static JTextField text3;

    static FolderSize folderSize = new FolderSize();

    public DiskCleaner() throws IOException {
        super("DISK CLEANER");//title
        setSize(1100, 600);
        setLayout(null);
        setLocation(0, 0);
        // getContentPane().setBackground(Color.BLUE);//background color to the parent panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        splitPane = new JSplitPane();
        splitPane.setDividerSize(1);//size of the split line
        splitPane.setDividerLocation(200);// where the line should appear
        splitPane.setEnabled(false);

        splitpane1 = new JSplitPane();
        splitpane1.setDividerSize(1);
        splitpane1.setDividerLocation(200);
        splitpane1.setEnabled(false);

        panel1 = new JPanel();
        panel1.setBounds(0, 500, 500, 400);
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        label1 = new JLabel("MEMORY OCCUPIED");
        label1.setBounds(40, 40, 150, 30);
        panel1.add(label1);

        prefetchButton = new JLabel("Prefetch");
        prefetchButton.setBounds(40, 100, 100, 30);
        panel1.add(prefetchButton);

        text1 = new JTextField();
        text1.setEditable(false);
        text1.setText("" + folderSize.whenGetFolderSize("C:\\Windows\\Prefetch") + "MB");
        text1.setBounds(120, 106, 100, 20);
        panel1.add(text1);

        tempButton = new JLabel("Temp");
        tempButton.setBounds(40, 160, 100, 30);
        panel1.add(tempButton);

        text2 = new JTextField();
        text2.setEditable(false);
        text2.setText("" + folderSize.whenGetFolderSize("C:\\Windows\\Temp") + "MB");
        text2.setBounds(120, 166, 100, 20);
        panel1.add(text2);

        userButton = new JLabel("%Temp%");
        userButton.setBounds(40, 220, 100, 30);
        panel1.add(userButton);

        text3 = new JTextField();
        text3.setEditable(false);
        text3.setText("" + folderSize.whenGetFolderSize("C:\\Users\\FRIDAH\\AppData\\Local\\Temp") + "MB");
        text3.setBounds(120, 226, 100, 20);
        panel1.add(text3);

        deleteAll = new JButton("CLEAN NOW");
        deleteAll.setBounds(40, 280, 120, 120);
        deleteAll.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteAll.setOpaque(false);
        Image img = ImageIO.read(getClass().getResource("/images/delete.PNG"));
        deleteAll.setIcon(new ImageIcon(img));
        deleteAll.setContentAreaFilled(false);
        deleteAll.setFocusPainted(false);
        panel1.add(deleteAll, BorderLayout.SOUTH);
        panelRight = new JPanel();
        panelLeft = new JPanel();

        panelNorth = new JPanel();
        panelNorth.setBounds(0, 0, 100, 100);
        imageLabel = new JLabel(new ImageIcon(getClass().getResource("/images/icon.PNG")));
        imageLabel.setBounds(0, 0, 100, 100);
        panelNorth.add(imageLabel, BorderLayout.WEST);

        panel = new JPanel();
        panel.setBounds(100, 0, 900, 100);
        panel.setBackground(Color.blue);

        label = new JLabel("DISK CLEANER");
        label.setFont(new Font("Calibri", Font.PLAIN, 35));
        label.setForeground(Color.white);
        panel.add(label);

        panelSouth = new JPanel();
        panelSouth.setBounds(0, 500, 1000, 100);
        panelSouth.setBackground(Color.blue);

        exit = new JButton("EXIT");
        exit.setBounds(1000, 500, 100, 100);
        panelSouth.add(exit, BorderLayout.SOUTH);

        splitPane.setRightComponent(panel1);
        splitPane.setLeftComponent(new MenuItems());
        splitPane.setBounds(0, 100, 500, 400);

        splitpane1.setRightComponent(new HomeView());
        splitpane1.setLeftComponent(panelLeft1);
        splitpane1.setBounds(500, 100, 500, 400);

        add(splitPane);
        add(splitpane1);
        add(panelNorth);
        add(panelSouth);
        add(panel);
    }

    public static void setRightComponent(JPanel nextPanel) {//the method sets components on the right panel

        splitpane1.remove(splitpane1.getRightComponent());//removes the current panel and gets the panel requested.
        splitpane1.setRightComponent(nextPanel);//launches the right panel
        splitpane1.setDividerSize(1);
        splitpane1.setDividerLocation(200);
        splitpane1.setEnabled(false);

    }

    public void cleanFiles(String path) {
        try {

            File file = new File(path);
            file.listFiles();

            for (File content : file.listFiles()) {
                content.delete();

            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) throws IOException {
        DiskCleaner clean = new DiskCleaner();
        clean.setResizable(true);
        clean.setLocationRelativeTo(null);
        clean.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clean.setVisible(true);

        try {
            deleteAll.addActionListener((ActionEvent event) -> {

                if (event.getSource() == deleteAll) {
                    clean.cleanFiles("C:\\Windows\\Temp");
                    clean.cleanFiles("C:\\Windows\\Prefetch");
                    clean.cleanFiles("C:\\Users\\FRIDAH\\AppData\\Local\\Temp");

                    final JOptionPane optionPane = new JOptionPane("CLEANING FILES....");
                    final JDialog dialog = new JDialog();
                    dialog.setTitle("CLEANING IN PROGRESS...");
                    dialog.setModal(true);
                    dialog.setLocationRelativeTo(null);
                    dialog.setContentPane(optionPane);
                    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    dialog.pack();

                    Timer timer = new Timer(4000, new AbstractAction() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dialog.dispose();
                        }
                    });

                    timer.setRepeats(false);
                    timer.start();
                    dialog.setVisible(true);
                    JOptionPane.showMessageDialog(null, "DISK FILES CLEANED");
                }

                text1.setText("" + folderSize.whenGetFolderSize("C:\\Windows\\Prefetch") + "MB");
                text2.setText("" + folderSize.whenGetFolderSize("C:\\Windows\\Temp") + "MB");
                text3.setText("" + folderSize.whenGetFolderSize("C:\\Users\\FRIDAH\\AppData\\Local\\Temp") + "MB");
                splitpane1.setRightComponent(panelLeft);
            });

        } catch (Exception e) {
        }

        exit.addActionListener((ActionEvent event) -> {
            int option = JOptionPane.showConfirmDialog(null,
                    "Are you sure that you want to exit ?",
                    "ConfirmDialog", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
            }
        });
    }

}

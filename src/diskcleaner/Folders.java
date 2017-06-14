package diskcleaner;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

//displays the files generated from the class Service
public class Folders extends JPanel {

    private static JLabel label;
    private static JPanel mainpanel;
    private static JList temporaryFilesList;
    private static JScrollPane scrollPane;

    //method to diplay temporary files in  the folders
    public static JPanel getService(Object[] object, String folderNames) {
        mainpanel = new JPanel();
        mainpanel.setBounds(0, 0, 600, 600);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setLayout(null);

        scrollPane = new JScrollPane();
        label = new JLabel(folderNames);
        temporaryFilesList = new JList(object);//accepts files with the object from the folders

        label.setBounds(10, 10, 300, 30);
        scrollPane.setBounds(1, 50, 490, 350);
        scrollPane.getViewport().add(temporaryFilesList);//add files to the scrollpane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        label.setFont(new Font("Calibri Bold", Font.BOLD, 28));

        mainpanel.add(label);
        mainpanel.add(scrollPane);

        return mainpanel;
    }
}

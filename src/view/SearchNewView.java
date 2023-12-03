package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchNewView {

    public final String viewName = "search";
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JPanel SearchView;
    private JPanel bigPanel;

    public JPanel getSearchView() {
        return bigPanel;
    }

    public SearchNewView() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button1 clicked");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button2 clicked");
            }
        });
    }
}

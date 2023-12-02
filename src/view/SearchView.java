package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchView {

    public final String viewName = "search";

    private JPanel SearchView;
    private JLabel title;
    private JTextField searchFieldTextField;
    private JButton buttonSearch;


    public JPanel getSearchView() {
        return SearchView;
    }

    public SearchView() {
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

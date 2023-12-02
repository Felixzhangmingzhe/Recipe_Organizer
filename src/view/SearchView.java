package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView implements ActionListener, PropertyChangeListener {

    public String viewName = "search";
    private JPanel SearchPanel;
    private JButton buttonSearch;
    private JButton returnButton;
    private JPanel labelPanel;

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    // Use Case: Search
    private ViewSearchController searchController;
    private ViewSearchViewModel searchViewModel;

    public SearchView(BackController backController, BackViewModel backViewModel,
                      ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel) {
        // 初始化面板和组件
        initComponents();

        this.backController = backController;
        this.backViewModel = backViewModel;
        this.searchController = viewSearchController;
        this.searchViewModel = viewSearchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);
    }

    private void initComponents() {
        // 创建并设置 SearchPanel
        SearchPanel = new JPanel();
        // 可以在这里添加其他组件设置，比如布局等

        // 创建按钮并添加事件监听器
        buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(this);

        returnButton = new JButton("Return");
        returnButton.addActionListener(this);

        // 添加按钮到面板
        SearchPanel.add(buttonSearch);
        SearchPanel.add(returnButton);

        // 其他组件的初始化...
    }

    public JPanel getSearchPanel() {
        return SearchPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    // 其他方法...
}

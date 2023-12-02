package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchState;
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

    //Use Case: Search
    private ViewSearchController searchController;
    private ViewSearchViewModel searchViewModel;

    public JPanel getSearchPanel() {
        return SearchPanel;
    }

    public SearchView(BackController backController, BackViewModel backViewModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel){
//        initComponents();
        this.backController = backController;
        this.backViewModel = backViewModel;
        this.searchController = viewSearchController;
        this.searchViewModel = viewSearchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);


    }

    public SearchView() {
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSearch) {
//            // 处理保存按钮点击事件，可能需要获取输入的菜谱信息并保存
//            String recipeName = recipeNameField.getText();
//            String recipeContent = recipeContentArea.getText();
            searchController.execute();
            // 执行保存逻辑...
        } else if (e.getSource() == returnButton) {
            // 处理取消按钮点击事件，可能需要关闭编辑界面
            // 执行取消逻辑...
            backController.execute();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewSearchState currentState = searchViewModel.getState();
//        JOptionPane.showMessageDialog(this, currentState.getSearchResult());


    }
}

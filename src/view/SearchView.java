package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.click_search.ClickSearchController;
import interface_adapter.click_search.ClickSearchState;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends Component implements ActionListener, PropertyChangeListener{

    public final String viewName = "search";

    private JPanel LabelPanel;
    private JLabel title;
    private JTextField searchTextField;
    private JButton buttonSearch;
    private JButton returnButton;
    private JPanel SearchPanel;

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    //Use Case: Search
    private ViewSearchController searchController;
    private ViewSearchViewModel searchViewModel;

    private ClickSearchController clickSearchController;
    private ClickSearchViewModel clickSearchViewModel;


    public JPanel getSearchMainPanel() {
        return SearchPanel;
    }

    public SearchView(BackController backController, BackViewModel backViewModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel, ClickSearchController clickSearchController, ClickSearchViewModel clickSearchViewModel) {
        initComponents();


        this.backController = backController;
        this.backViewModel = backViewModel;
        this.searchController = viewSearchController;
        this.searchViewModel = viewSearchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);
        
        this.clickSearchController = clickSearchController;
        this.clickSearchViewModel = clickSearchViewModel;

//        JFrame frame = new JFrame("SearchView");
//        frame.setContentPane(new SearchView(backController, backViewModel, viewSearchController, viewSearchViewModel).SearchPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        // 这个好像也没用

        //界面元素
//        title = new JLabel("Search");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        buttonSearch = new JButton("Search");
//        returnButton = new JButton("Return");
//        searchTextField = new JTextField(15);

        // 设置布局
//        this.setLayout(new CardLayout()); // For example, using FlowLayout
//        this.add(title);
//        this.add(searchTextField);
//        this.add(buttonSearch);
//        this.add(returnButton);


        searchTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 这里什么都不做
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 这里也什么都不做
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 在这里处理文本更新
                ClickSearchState currentState = clickSearchViewModel.getState();
                if (currentState != null){
                    currentState.setSearchQuery(searchTextField.getText());
                    clickSearchViewModel.setState(currentState);
                } else{
                    currentState = new ClickSearchState();
                    currentState.setSearchQuery(searchTextField.getText());
                    clickSearchViewModel.setState(currentState);
                }

//                currentState.setSearchQuery(searchTextField.getText());
//                clickSearchViewModel.setState(currentState);

//                ViewSearchState currentState = searchViewModel.getState();
//                currentState.setSearchQuery(searchTextField.getText());
//                viewSearchViewModel.setState(currentState);
            }
        });

        buttonSearch.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(buttonSearch)) {
                            ClickSearchState currentState = clickSearchViewModel.getState();
                            clickSearchController.execute(currentState.getSearchQuery());
                        }
                        // 处理取消按钮点击事件，可能需要关闭编辑界面
                        // 执行取消逻辑...

                    }
                }
        );


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(returnButton)) {
                }
                // 处理取消按钮点击事件，可能需要关闭编辑界面
                // 执行取消逻辑...
                backController.execute();
            }
        });
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

        searchTextField = new JTextField(15);
        searchTextField.addActionListener(this);

        // 添加按钮到面板
        SearchPanel.add(buttonSearch);
        SearchPanel.add(returnButton);
        SearchPanel.add(searchTextField);

        // 其他组件的初始化...
    }

//    private void initComponents() {
//    }


    public JPanel getSearchView() {
        return SearchPanel;
    }

//    public SearchView() {
//        //不知道干嘛因为不会空着来吧
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSearch) {
//            // 处理保存按钮点击事件，可能需要获取输入的菜谱信息并保存
//            String recipeName = recipeNameField.getText();
//            String recipeContent = recipeContentArea.getText();
            clickSearchController.execute(searchViewModel.getState().getSearchQuery());
            // 执行保存逻辑...
        } else if (e.getSource() == returnButton) {
            // 处理取消按钮点击事件，可能需要关闭编辑界面
            // 执行取消逻辑...
            backController.execute();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        ViewSearchState currentState = searchViewModel.getState();
//        JOptionPane.showMessageDialog(this, currentState.getSearchResult());
        ClickSearchState clickSearchState = clickSearchViewModel.getState();
        getAndDisplaySearchRecipeError(clickSearchState);
    }

    public void getAndDisplaySearchRecipeError(ClickSearchState state) {
        if (state.getSearchError() != null) {
            JOptionPane.showMessageDialog(this, state.getSearchError());
        }
    }


    public JPanel getSearchPanel() {
        return SearchPanel;
    }


}

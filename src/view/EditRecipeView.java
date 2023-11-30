package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.create_recipe.CreateRecipeState;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JButton saveButton;
    private final JButton cancelButton;
    private final JTextArea recipeNameField;
    private final JTextArea recipeContentArea;
    public String viewName = "edit recipe";
    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;
    // Use Case: Create Recipe
    private CreateRecipeController createRecipeController;
    private CreateRecipeViewModel createRecipeViewModel;

    public EditRecipeView(BackController backController, BackViewModel backViewModel,
                          CreateRecipeController createRecipeController, CreateRecipeViewModel createRecipeViewModel) {
        this.backController = backController;
        this.backViewModel = backViewModel;
        this.createRecipeController = createRecipeController;
        this.createRecipeViewModel = createRecipeViewModel;
        // 初始化界面元素
        JLabel titleLabel = new JLabel("Edit Recipe");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        recipeNameField = new JTextArea();
        recipeContentArea = new JTextArea();
        saveButton = new JButton("Save");
        cancelButton = new JButton("Back");

        // 设置布局
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 添加元素到面板,使用 GridBagLayout
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Recipe Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        add(new JScrollPane(recipeNameField), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Content:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(recipeContentArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        add(saveButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(cancelButton, gbc);

        // 添加事件监听器
        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(saveButton)) {
                            CreateRecipeState currentState = createRecipeViewModel.getState();
                            createRecipeController.execute(
                                    currentState.getRecipeName(),
                                    currentState.getContent()
                            );
                        }
                    }
                });

        cancelButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(cancelButton)) {
                        }
                        // 处理取消按钮点击事件，可能需要关闭编辑界面
                        // 执行取消逻辑...
                        backController.execute();
                    }
                }
        );




        // Add AddKeyListener to the recipeNameField
        recipeNameField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreateRecipeState currentState = createRecipeViewModel.getState();
                        currentState.setRecipeName(recipeNameField.getText() + e.getKeyChar());
                        createRecipeViewModel.setState(currentState);

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                }
            }
        );
        // Add AddKeyListener to the recipeContentArea
        recipeContentArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateRecipeState currentState = createRecipeViewModel.getState();
                currentState.setContent(recipeContentArea.getText() + e.getKeyChar());
                createRecipeViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            // 处理保存按钮点击事件，可能需要获取输入的菜谱信息并保存
            String recipeName = recipeNameField.getText();
            String recipeContent = recipeContentArea.getText();
            // 执行保存逻辑...
        } else if (e.getSource() == cancelButton) {
            // 处理取消按钮点击事件，可能需要关闭编辑界面
            // 执行取消逻辑...
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // 处理属性变化事件
    }
}

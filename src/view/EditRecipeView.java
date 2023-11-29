package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JButton saveButton;
    private final JButton cancelButton;
    private final JTextField recipeNameField;
    private final JTextArea recipeContentArea;
    public String viewName = "edit recipe";
    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    public EditRecipeView(BackController backController, BackViewModel backViewModel) {
        this.backController = backController;
        this.backViewModel = backViewModel;
        // 初始化界面元素
        JLabel titleLabel = new JLabel("Edit Recipe");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        recipeNameField = new JTextField();
        recipeContentArea = new JTextArea();
        saveButton = new JButton("Save");
        cancelButton = new JButton("Back");

        // 设置布局
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 添加元素到面板
        this.add(titleLabel);
        this.add(new JLabel("Recipe Name:"));
        this.add(recipeNameField);
        this.add(new JLabel("Recipe Content:"));
        this.add(new JScrollPane(recipeContentArea));
        this.add(saveButton);
        this.add(cancelButton);

        // 添加事件监听器
        saveButton.addActionListener(this);
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

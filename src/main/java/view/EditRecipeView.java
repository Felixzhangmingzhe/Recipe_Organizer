package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.create_recipe.CreateRecipeState;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.create_recipe.CreateRecipeState;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeState;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditController;
import interface_adapter.jump_to_edit.JumpToEditState;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import org.json.JSONException;
import use_case.open_create_recipe.OpenCreateRecipeInputBoundary;

public class EditRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JButton saveButton;
    private final JButton cancelButton;
    private final JTextArea recipeNameField;
    private final JTextArea recipeContentArea;
    private final JumpToEditViewModel jumpToEditViewModel;
    private int recipeId;
    private String recipeName;
    private String recipeOringinalName;
    private String recipeContent;
    private boolean recipeIsFavorite;
    private double recipeCalories;
    private boolean recipeCooked;
    private String recipeCreationTime;
    private JScrollPane scrollName;
    private JScrollPane scrollContent;
    private String createOrEdit = "edit";

    public String viewName = "edit recipe";
    // Use Case: Open Create Recipe
    private OpenCreateRecipeViewModel openCreateRecipeViewModel;
    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;
    // Use Case: Create Recipe
    private CreateRecipeController createRecipeController;
    private CreateRecipeViewModel createRecipeViewModel;
    // Use Case: Jump To Edit
    private EditRecipeViewModel editRecipeViewModel;
    private EditRecipeController editRecipeController;

    public EditRecipeView(BackController backController, BackViewModel backViewModel,
                          JumpToEditViewModel jumpToEditViewModel,
                          OpenCreateRecipeViewModel openCreateRecipeViewModel,
                          EditRecipeViewModel editRecipeViewModel, EditRecipeController editRecipeController,
                          CreateRecipeController createRecipeController, CreateRecipeViewModel createRecipeViewModel) {
        this.backController = backController;
        this.backViewModel = backViewModel;
        this.createRecipeController = createRecipeController;
        this.createRecipeViewModel = createRecipeViewModel;
        this.createRecipeViewModel.addPropertyChangeListener(this);
        this.jumpToEditViewModel = jumpToEditViewModel;
        this.jumpToEditViewModel.addPropertyChangeListener(this);
        this.openCreateRecipeViewModel = openCreateRecipeViewModel;
        this.openCreateRecipeViewModel.addPropertyChangeListener(this);
        this.editRecipeViewModel = editRecipeViewModel;
        this.editRecipeViewModel.addPropertyChangeListener(this);
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
        scrollName = new JScrollPane(recipeNameField);
        recipeNameField.setLineWrap(true);
        scrollName.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Content:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        scrollContent = new JScrollPane(recipeContentArea);
        recipeContentArea.setLineWrap(true);
        scrollContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollContent, gbc);

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
                            System.out.println("When Save,CreateOrEdit is " + createOrEdit);
                            if (createOrEdit.equals("edit")) {
                                System.out.println("When Save,EditUsecase Run");
                                EditRecipeState currentState = editRecipeViewModel.getState();
                                try {
                                    editRecipeController.execute(
                                            recipeOringinalName,
                                            currentState.getRecipeTitle(),
                                            currentState.getRecipeContent());
                                } catch (JSONException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            else {
                                System.out.println("When Save,CreatUsecase Run");
                                CreateRecipeState currentState = createRecipeViewModel.getState();
                                createRecipeController.execute(
                                        currentState.getRecipeName(),
                                        currentState.getContent());
                            }

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

        recipeTextListener();

    }

    private void recipeTextListener() {
        // 使用 DocumentListener 监听文本内容变化
        recipeNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateState();
            }

            private void updateState() {
                recipeNameField.requestFocusInWindow();
                CreateRecipeState currentState = createRecipeViewModel.getState();
                currentState.setRecipeName(recipeNameField.getText());
                createRecipeViewModel.setState(currentState);
                //
                EditRecipeState editState = editRecipeViewModel.getState();
                editState.setRecipeTitle(recipeNameField.getText());
                editRecipeViewModel.setState(editState);

            }
        });
        recipeContentArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateState();
            }

            private void updateState() {
                recipeContentArea.requestFocusInWindow();
                CreateRecipeState currentState = createRecipeViewModel.getState();
                currentState.setContent(recipeContentArea.getText());
                createRecipeViewModel.setState(currentState);
                //
                EditRecipeState editState = editRecipeViewModel.getState();
                editState.setRecipeContent(recipeContentArea.getText());
                editRecipeViewModel.setState(editState);
            }
        });
    }
        // Add AddKeyListener to the recipeNameField
//        recipeNameField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        CreateRecipeState currentState = createRecipeViewModel.getState();
//                        currentState.setRecipeName(recipeNameField.getText() + e.getKeyChar());
//                        createRecipeViewModel.setState(currentState);
//
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                }
//            }
//        );




//        Add AddKeyListener to the recipeContentArea
//        recipeContentArea.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                CreateRecipeState currentState = createRecipeViewModel.getState();
//                currentState.setContent(recipeContentArea.getText() + e.getKeyChar());
//                createRecipeViewModel.setState(currentState);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        }





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
        if (evt.getPropertyName().equals("state")) {
            CreateRecipeState state = (CreateRecipeState) evt.getNewValue();
            getAndDisplayCreateRecipeError(state);
        }
        else if (evt.getPropertyName().equals("jump")) {
            System.out.println("EditRecipeView.propertyChange");
            JumpToEditState state = (JumpToEditState) evt.getNewValue();
            getAndDisplayJumpToEdit(state);
        }
    }

    public void getAndDisplayCreateRecipeError(CreateRecipeState state) {
        if (state.getRecipeNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getRecipeNameError());
        }
        else if (state.getContentError() != null) {
            JOptionPane.showMessageDialog(this, state.getContentError());
        }
        else if (state.getConflictError() != null) {
            JOptionPane.showMessageDialog(this, state.getConflictError());
        }
    }

    public void getAndDisplayJumpToEdit(JumpToEditState state) {
        recipeName = state.getRecipeTitle();
        recipeOringinalName = state.getRecipeTitle();
        recipeContent = state.getRecipeContent() ;
        recipeId = state.getRecipeId();
        recipeIsFavorite = state.getRecipeIsFavorite();
        recipeCalories = state.getRecipeCalories();
        recipeCooked = state.getRecipeCooked();
        recipeCreationTime = state.getRecipeCreationTime().toString();
        System.out.println(recipeName);
        System.out.println(recipeContent);

        recipeNameField.setText(recipeName);
        scrollName.setViewportView(recipeNameField);
        recipeContentArea.setText(recipeContent);
        scrollContent.setViewportView(recipeContentArea);
        createOrEdit = "edit";
    }
    public void refresh() {
        recipeNameField.setText("");
        recipeContentArea.setText("");
        createOrEdit = "create";
    }
//     public void getAndDisplayCreateRecipeError(EditRecipeState state) {
//        if (state.getRecipeNameError() != null) {
//            JOptionPane.showMessageDialog(this, state.getRecipeNameError());
//        }
//        else if (state.getContentError() != null) {
//            JOptionPane.showMessageDialog(this, state.getContentError());
//        }
//    }
}

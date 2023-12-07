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
    // UI components
    private final JButton saveButton;
    private final JButton cancelButton;
    private final JTextArea recipeNameField;
    private final JTextArea recipeContentArea;
    private final JScrollPane scrollName;
    private final JScrollPane scrollContent;

    // ViewModels and Controllers
    private final BackController backController;
    private final BackViewModel backViewModel;
    private final CreateRecipeController createRecipeController;
    private final CreateRecipeViewModel createRecipeViewModel;
    private EditRecipeController editRecipeController;
    private final EditRecipeViewModel editRecipeViewModel;
    private final JumpToEditViewModel jumpToEditViewModel;
    private final OpenCreateRecipeViewModel openCreateRecipeViewModel;

    // Variables of recipe entity
    private int recipeId;
    private String recipeTitle;
    private String recipeOriginalTitle;
    private String recipeContent;
    private boolean recipeIsFavorite;
    private double recipeCalories;
    private boolean recipeCooked;
    private String recipeCreationTime;
    private JScrollPane scrollName;
    private JScrollPane scrollContent;
    private String createOrEdit = "edit";

    private String createOrEdit = "create";
    public String viewName = "edit recipe";

    // Constructor
    public EditRecipeView(BackController backController,
                          BackViewModel backViewModel,
                          CreateRecipeController createRecipeController,
                          CreateRecipeViewModel createRecipeViewModel,
                          EditRecipeController editRecipeController,
                          EditRecipeViewModel editRecipeViewModel,
                          JumpToEditViewModel jumpToEditViewModel,
                          OpenCreateRecipeViewModel openCreateRecipeViewModel) {
        // Initialize UI components
        // Add action listeners to buttons
        this.backController = backController;
        this.backViewModel = backViewModel;
        this.createRecipeController = createRecipeController;
        this.createRecipeViewModel = createRecipeViewModel;
        this.createRecipeViewModel.addPropertyChangeListener(this);
        this.editRecipeViewModel = editRecipeViewModel;
        this.editRecipeViewModel.addPropertyChangeListener(this);
        this.jumpToEditViewModel = jumpToEditViewModel;
        this.jumpToEditViewModel.addPropertyChangeListener(this);
        this.openCreateRecipeViewModel = openCreateRecipeViewModel;
        this.openCreateRecipeViewModel.addPropertyChangeListener(this);

        // 初始化界面元素
        // Initialize UI
        JLabel titleLabel = new JLabel("Edit Recipe");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        recipeNameField = new JTextArea();
        recipeContentArea = new JTextArea();
        saveButton = new JButton("Save");
        cancelButton = new JButton("Back");

        // 设置布局
        // Set layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 添加元素到面板，使用 GridBagLayout
        // Use GridBagLayout to add elements to the panel
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
        // Add event listeners
        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveButton)) {
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
                                editRecipeController.execute(recipeOriginalTitle, currentState.getRecipeTitle(), currentState.getRecipeContent());
                            }
                            else {
                                System.out.println("When Save,CreatUsecase Run");
                                CreateRecipeState currentState = createRecipeViewModel.getState();
                                try {
                                    createRecipeController.execute(
                                            currentState.getRecipeName(),
                                            currentState.getContent());
                                } catch (JSONException ex) {
                                    throw new RuntimeException(ex);
                                }
                                createRecipeController.execute(currentState.getRecipeName(), currentState.getContent());
                            }

                        }
                    }
                });

        cancelButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancelButton)) {
                        }
                        // 处理取消按钮点击事件，可能需要关闭编辑界面
                        // 执行取消逻辑...
                        // Execute cancel action
                        backController.execute();
                    }
                }
        );

        // Add document listeners to recipe title and content
        recipeTextListener();

    }

    private void recipeTextListener() {
        // 使用 DocumentListener 监听文本内容变化
        // Use DocumentListener to listen the text content changes

        // Add AddKeyListener to the recipeNameField
        recipeNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent evt) {
                updateState();
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                updateState();
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
                updateState();
            }

            private void updateState() {
                recipeNameField.requestFocusInWindow();
                CreateRecipeState currentState = createRecipeViewModel.getState();
                currentState.setRecipeName(recipeNameField.getText());
                createRecipeViewModel.setState(currentState);
                EditRecipeState editState = editRecipeViewModel.getState();
                editState.setRecipeTitle(recipeNameField.getText());
                editRecipeViewModel.setState(editState);
            }
        });

        // Add AddKeyListener to the recipeContentArea
        recipeContentArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent evt) {
                updateState();
            }

            @Override
            public void removeUpdate(DocumentEvent evt) {
                updateState();
            }

            @Override
            public void changedUpdate(DocumentEvent evt) {
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


        // ##########################################Discarded Code Blocks##########################################


        // recipeNameField.addKeyListener(
        //         new KeyListener() {
        //             @Override
        //             public void keyTyped(KeyEvent evt) {
        //                 CreateRecipeState currentState = createRecipeViewModel.getState();
        //                 currentState.setRecipeName(recipeNameField.getText() + evt.getKeyChar());
        //                 createRecipeViewModel.setState(currentState);

        //             }

        //             @Override
        //             public void keyPressed(KeyEvent evt) {
        //             }

        //             @Override
        //             public void keyReleased(KeyEvent evt) {
        //         }
        //     }
        // );


        // recipeContentArea.addKeyListener(new KeyListener() {
        //     @Override
        //     public void keyTyped(KeyEvent evt) {
        //         CreateRecipeState currentState = createRecipeViewModel.getState();
        //         currentState.setContent(recipeContentArea.getText() + evtgetKeyChar());
        //         createRecipeViewModel.setState(currentState);
        //     }

        //     @Override
        //     public void keyPressed(KeyEvent evt) {

        //     }

        //     @Override
        //     public void keyReleased(KeyEvent evt) {
        //     }
        // }

        // ##########################################Discarded Code Blocks##########################################



    // Add action listener methods
    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }


    // Implement ActionListener
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == saveButton) {
            // 处理保存按钮点击事件，可能需要获取输入的菜谱信息并保存
            String recipeName = recipeNameField.getText();
            String recipeContent = recipeContentArea.getText();
            // 执行保存逻辑...
            // Save action
        } else if (evt.getSource() == cancelButton) {
            // 处理取消按钮点击事件，可能需要关闭编辑界面
            // 执行取消逻辑...
            // Cancel action
        }
    }

    // Implement PropertyChangeListener
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        // StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // 遍历输出调用栈信息
        // for (StackTraceElement element : stackTrace) {
        //     System.out.println(element.toString());
        // }

        if (evt.getPropertyName().equals("state")) {
            CreateRecipeState state = (CreateRecipeState) evt.getNewValue();
            getAndDisplayCreateRecipeError(state);
        } else if (evt.getPropertyName().equals("jump")) {
            System.out.println("EditRecipeView.propertyChange");
            JumpToEditState state = (JumpToEditState) evt.getNewValue();
            getAndDisplayJumpToEdit(state);
        } else if (evt.getPropertyName().equals("open")) {
            EditRecipeState state = (EditRecipeState) evt.getNewValue();
            refresh();
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
        recipeTitle = state.getRecipeTitle();
        recipeOriginalTitle = state.getRecipeTitle();
        recipeContent = state.getRecipeContent() ;
        recipeId = state.getRecipeId();
        recipeIsFavorite = state.getRecipeIsFavorite();
        recipeCalories = state.getRecipeCalories();
        recipeCooked = state.getRecipeCooked();
        recipeCreationTime = state.getRecipeCreationTime().toString();
        System.out.println(recipeTitle);
        System.out.println(recipeContent);

        recipeNameField.setText(recipeTitle);
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

    // public void getAndDisplayCreateRecipeError(EditRecipeState state) {
    //     if (state.getRecipeNameError() != null) {
    //         JOptionPane.showMessageDialog(this, state.getRecipeNameError());
    //     }
    //     else if (state.getContentError() != null) {
    //         JOptionPane.showMessageDialog(this, state.getContentError());
    //     }
    // }

}

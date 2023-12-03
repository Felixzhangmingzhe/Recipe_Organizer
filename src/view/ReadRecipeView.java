package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.add_to_favorites.AddToFavoritesController;
import interface_adapter.add_to_favorites.AddToFavoritesState;
import interface_adapter.add_to_favorites.AddToFavoritesViewModel;
import interface_adapter.cooked.CookedController;
import interface_adapter.cooked.CookedState;
import interface_adapter.cooked.CookedViewModel;
import interface_adapter.create_recipe.CreateRecipeState;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditController;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReadRecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Read Recipe";
    private final JButton backButton;
    private final JButton favoritesButton;
    private final JButton cookedButton;
    private final JButton editButton;

    // Components for displaying recipe information
    private final JLabel recipeNameLabel;
    private final JTextArea recipeContentTextArea;
    private final JLabel caloriesLabel;
    private final JLabel lastEditTimeLabel;
    private final CreateRecipeViewModel createRecipeViewModel;
    private final ViewRecipeViewModel viewRecipeViewModel;
    private String recipeName;

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;
    // Use Case: Add to Favorites
    private AddToFavoritesController addToFavoritesController;
    private AddToFavoritesViewModel addToFavoritesViewModel;
    // Use Case: Cooked
    private CookedController cookedController;
    private CookedViewModel cookedViewModel;
    // Use Case: Jump to Edit
    private JumpToEditController jumpToEditController;
    private JumpToEditViewModel jumpToEditViewModel;

    public ReadRecipeView(BackViewModel backViewModel, BackController backController, ViewRecipeViewModel viewRecipeViewModel, CreateRecipeViewModel createRecipeViewModel
    , AddToFavoritesController addToFavoritesController, AddToFavoritesViewModel addToFavoritesViewModel,
                          JumpToEditController jumpToEditController, JumpToEditViewModel jumpToEditViewModel,
                          CookedViewModel cookedViewModel, CookedController cookedController) {
        // Initialize view model and controller
        this.backViewModel = backViewModel;
        this.backController = backController;
        this.createRecipeViewModel = createRecipeViewModel;
        this.createRecipeViewModel.addPropertyChangeListener(this);//Listen to the change of createRecipeViewModel
        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewRecipeViewModel.addPropertyChangeListener(this);//Listen to the change of viewRecipeViewModel
        this.addToFavoritesController = addToFavoritesController;
        this.addToFavoritesViewModel = addToFavoritesViewModel;
        this.addToFavoritesViewModel.addPropertyChangeListener(this);//Listen to the change of addToFavoritesViewModel
        this.cookedController = cookedController;
        this.cookedViewModel = cookedViewModel;
        this.cookedViewModel.addPropertyChangeListener(this);//Listen to the change of cookedViewModel
        this.jumpToEditController = jumpToEditController;
        this.jumpToEditViewModel = jumpToEditViewModel;
        this.jumpToEditViewModel.addPropertyChangeListener(this);//Listen to the change of jumpToEditViewModel

        // Initialize String RecipeName
        recipeName = "";
        // Initialize components
        recipeNameLabel = new JLabel("Recipe Name");
        recipeContentTextArea = new JTextArea("Recipe Content");
        recipeContentTextArea.setEditable(false);
        caloriesLabel = new JLabel("Calories: ");
        lastEditTimeLabel = new JLabel("Last Edited: ");

        // Initialize buttons
        backButton = new JButton("Back");
        favoritesButton = new JButton("Favorites");
        cookedButton = new JButton("Cooked");
        editButton = new JButton("Edit");

        // Add action listeners to buttons
        backButton.addActionListener(this);
        favoritesButton.addActionListener(this);
        cookedButton.addActionListener(this);
        editButton.addActionListener(this);

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(recipeNameLabel, BorderLayout.NORTH);
        add(new JScrollPane(recipeContentTextArea), BorderLayout.CENTER);

        // Create a panel for additional information (calories and last edit time)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.add(caloriesLabel);
        infoPanel.add(lastEditTimeLabel);
        add(infoPanel, BorderLayout.SOUTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(favoritesButton);
        buttonPanel.add(cookedButton);
        buttonPanel.add(editButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Handle button actions
        if (evt.getSource() == backButton) {
            // Implement action for back button
            backController.execute();
        } else if (evt.getSource() == favoritesButton) {
            // Implement action for favorites button
            addToFavoritesController.execute(recipeName);
            System.out.println("favorites button clicked");
        } else if (evt.getSource() == cookedButton) {
            // Implement action for cooked button
            cookedController.execute(recipeName);
        } else if (evt.getSource() == editButton) {
            // Implement action for edit button
            jumpToEditController.execute(recipeName);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("the evt is " + evt.getPropertyName());

        if (evt.getPropertyName().equals("state")) {
            getAndDisplay(createRecipeViewModel.getState());
            updateFavoritesButton(createRecipeViewModel.getState());
        } else if (evt.getPropertyName().equals("recipe")) {
            getAndDisplay(viewRecipeViewModel);
            updateFavoritesButton(viewRecipeViewModel);
        } else if (evt.getPropertyName().equals("add")) {
            getAndDisplay(addToFavoritesViewModel.getState());
            updateFavoritesButton(addToFavoritesViewModel.getState());
        }else if (evt.getPropertyName().equals("cooked")) {
            System.out.println("cooked property changed");
            getAndDisplay((CookedState) evt.getNewValue());
        }
    }

    public void getAndDisplay(CreateRecipeState currentState) {
        // Update the labels and text area with the recipe information
        String recipeName = currentState.getRecipeName();
        String recipeContent = currentState.getContent();
        String calories = String.valueOf(currentState.getCalories());
        String lastEditTime = String.valueOf(currentState.getCreatedAt());

        recipeNameLabel.setText("Recipe Name: " + recipeName);
        recipeContentTextArea.setText(recipeContent);
        caloriesLabel.setText("Calories: " + calories);
        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
    }
    public void getAndDisplay(ViewRecipeViewModel currentState) {
        // Update the labels and text area with the recipe information
        recipeName = currentState.getTitle();
        String recipeContent = currentState.getContent();
        String calories = String.valueOf(currentState.getCalories());
        String lastEditTime = String.valueOf(currentState.getCreationTime());

        recipeNameLabel.setText("Recipe Name: " + recipeName);
        recipeContentTextArea.setText(recipeContent);
        caloriesLabel.setText("Calories: " + calories);
        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
    }
    public void getAndDisplay(AddToFavoritesState currentState) {
        // Show the message that A. has been added to favorites.B. has been removed from favorites
        String addToFavoritesMessage = currentState.getAddToFavoritesMessage();
        String removeFromFavoritesMessage = currentState.getDeleteFromFavoritesMessage();
        if (addToFavoritesMessage != "") {
            JOptionPane.showMessageDialog(this, addToFavoritesMessage);
        } else{
            System.out.println("removeFromFavoritesMessage is " + removeFromFavoritesMessage);
            JOptionPane.showMessageDialog(this, removeFromFavoritesMessage);
        }
    }
    public void getAndDisplay(CookedState currentState) {
        // Show the message that A. has been added to favorites.B. has been removed from favorites
        boolean firstCookedSuccess = currentState.getSetCookedSuccess();
        if (firstCookedSuccess) {
            JOptionPane.showMessageDialog(this, "Hooray! For the first time you cooked this recipe!");
        } else {
            JOptionPane.showMessageDialog(this, "You have already cooked this recipe!");
        }
    }
    private void updateFavoritesButton(AddToFavoritesState currentState) {
        // 根据 addToFavoritesViewModel 或其他相关信息判断 Recipe 是否在 favorites 中
        String addToFavoritesMessage = currentState.getAddToFavoritesMessage();
        boolean isInFavorites;
        if (addToFavoritesMessage != "") {
            isInFavorites = true;
        } else {
            isInFavorites = false;
        }

        // 更新按钮标签
        if (isInFavorites) {
            favoritesButton.setText("Unfavorite");
        } else {
            favoritesButton.setText("Favorite");
        }
    }
    private void updateFavoritesButton(CreateRecipeState currentState) {
        // According to the createRecipeViewModel or other related information to determine whether the recipe is in favorites
        boolean isInFavorites = currentState.getIsInFavorites();
        // 更新按钮标签
        if (isInFavorites) {
            favoritesButton.setText("Unfavorite");
        } else {
            favoritesButton.setText("Favorite");
        }
    }
    private void updateFavoritesButton(ViewRecipeViewModel currentState) {
        // According to the createRecipeViewModel or other related information to determine whether the recipe is in favorites
        boolean isInFavorites = currentState.getIsFavorite();
        // 更新按钮标签
        if (isInFavorites) {
            favoritesButton.setText("Unfavorite");
        } else {
            favoritesButton.setText("Favorite");
        }
    }
}

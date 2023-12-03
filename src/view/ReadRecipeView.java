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
import interface_adapter.show_daily_special.ShowDailySpecialController;
import interface_adapter.show_daily_special.ShowDailySpecialState;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
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
    // Use Case: Show Daily Special
    private ShowDailySpecialViewModel showDailySpecialViewModel;
    private ShowDailySpecialController showDailySpecialController;

    public ReadRecipeView(BackViewModel backViewModel, BackController backController, ViewRecipeViewModel viewRecipeViewModel, CreateRecipeViewModel createRecipeViewModel
    , AddToFavoritesController addToFavoritesController, AddToFavoritesViewModel addToFavoritesViewModel,
                           CookedViewModel cookedViewModel, CookedController cookedController,
                           ShowDailySpecialViewModel showDailySpecialViewModel, ShowDailySpecialController showDailySpecialController) {
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
        this.showDailySpecialController = showDailySpecialController;
        this.showDailySpecialViewModel = showDailySpecialViewModel;
        this.showDailySpecialViewModel.addPropertyChangeListener(this);//Listen to the change of showDailySpecialViewModel

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

        // Arrange the components on the panel
        arrangemrnt();
    }
    public void arrangemrnt(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        // Add components to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        add(recipeNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        recipeContentTextArea.setLineWrap(true);  // 自动换行
        JScrollPane scrollPane = new JScrollPane(recipeContentTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, gbc);

// Create a panel for additional information (calories and last edit time)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.add(caloriesLabel);
        infoPanel.add(lastEditTimeLabel);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(infoPanel, gbc);

// Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(favoritesButton);
        buttonPanel.add(cookedButton);
        buttonPanel.add(editButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.REMAINDER;
        add(buttonPanel, gbc);

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
            // For example, open the edit view for this recipe
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
        }else if (evt.getPropertyName().equals("daily special")) {
            System.out.println("show daily special property changed");

            getAndDisplay((ShowDailySpecialState) evt.getNewValue());
            updateFavoritesButton(viewRecipeViewModel);}
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
        cookedButton.setText("Cooked");
    }
    public void getAndDisplay(ShowDailySpecialState currentState) {
        // Update the labels and text area with the recipe information
        String recipeContent = currentState.getContent();
        String calories = String.valueOf(currentState.getCalories());
        String lastEditTime = String.valueOf(currentState.getCreationTime());
        recipeName = currentState.getTitle();
        recipeNameLabel.setText("Recipe Name: " + recipeName);
        recipeContentTextArea.setText(recipeContent);
        caloriesLabel.setText("Calories: " + calories);

        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
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
        boolean isCooked = currentState.getIsCooked();
        // 更新按钮标签
        if (isCooked) {
            cookedButton.setText("Cooked");
        } else {
            cookedButton.setText("Cook");
        }
    }

}

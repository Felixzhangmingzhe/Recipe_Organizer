package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.create_recipe.CreateRecipeState;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.show_daily_special.ShowDailySpecialState;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DailySpecialView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Daily Special";
    private final JButton backButton;
    private final JButton favoritesButton;
    private final JButton cookedButton;
    private final JButton editButton;

    // Components for displaying recipe information
    private final JLabel recipeNameLabel;
    private final JTextArea recipeContentTextArea;
    private final JLabel caloriesLabel;
    private final JLabel lastEditTimeLabel;

    private final ViewRecipeViewModel viewRecipeViewModel;
    private final ShowDailySpecialViewModel showDailySpecialViewModel;

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    public DailySpecialView(BackViewModel backViewModel, BackController backController, ViewRecipeViewModel viewRecipeViewModel, ShowDailySpecialViewModel showDailySpecialViewModel) {
        // Initialize view model and controller
        this.backViewModel = backViewModel;
        this.backController = backController;
        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewRecipeViewModel.addPropertyChangeListener(this);
        // Use Case:Show Daily Special
        this.showDailySpecialViewModel = showDailySpecialViewModel;
        this.showDailySpecialViewModel.addPropertyChangeListener(this);

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
        backButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(backButton)) {
                            backController.execute();
                        }
                    }
                }
        );

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
            // For example, add the recipe to favorites
        } else if (evt.getSource() == cookedButton) {
            // Implement action for cooked button
            // For example, mark the recipe as cooked
        } else if (evt.getSource() == editButton) {
            // Implement action for edit button
            // For example, open the edit view for this recipe
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("the evt is " + evt.getPropertyName());

        if (evt.getPropertyName().equals("state")) {
            getAndDisplay(showDailySpecialViewModel.getState());
        } else if (evt.getPropertyName().equals("recipe")) {
            getAndDisplay(viewRecipeViewModel);
        }
    }

    public void getAndDisplay(ShowDailySpecialState currentState) {
        // Update the labels and text area with the recipe information
        String recipeName = currentState.getTitle();
        String recipeContent = currentState.getContent();
        String calories = String.valueOf(currentState.getCalories());
        String lastEditTime = String.valueOf(currentState.getCreationTime());

        recipeNameLabel.setText("Recipe Name: " + recipeName);
        recipeContentTextArea.setText(recipeContent);
        caloriesLabel.setText("Calories: " + calories);
        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
    }
    public void getAndDisplay(ViewRecipeViewModel currentState) {
        // Update the labels and text area with the recipe information
        String recipeName = currentState.getTitle();
        String recipeContent = currentState.getContent();
        String calories = String.valueOf(currentState.getCalories());
        String lastEditTime = String.valueOf(currentState.getCreationTime());

        recipeNameLabel.setText("Recipe Name: " + recipeName);
        recipeContentTextArea.setText(recipeContent);
        caloriesLabel.setText("Calories: " + calories);
        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
    }



}
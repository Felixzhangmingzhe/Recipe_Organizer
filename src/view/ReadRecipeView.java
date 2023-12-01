package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.create_recipe.CreateRecipeState;
import interface_adapter.create_recipe.CreateRecipeViewModel;

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

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    public ReadRecipeView(BackViewModel backViewModel, BackController backController, CreateRecipeViewModel createRecipeViewModel) {
        // Initialize view model and controller
        this.backViewModel = backViewModel;
        this.backController = backController;
        this.createRecipeViewModel = createRecipeViewModel;
        this.createRecipeViewModel.addPropertyChangeListener(this);

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
        System.out.println(evt.getPropertyName());
        // Update view based on property changes
        CreateRecipeState currentState = createRecipeViewModel.getState();
        getAndDisplay(currentState);
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
}

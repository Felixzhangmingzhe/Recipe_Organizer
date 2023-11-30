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
import java.sql.*;

public class ReadRecipeView extends JFrame implements ActionListener, PropertyChangeListener {

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
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateRecipeState currentState = createRecipeViewModel.getState();
        getAndDisplay(currentState);
    }
    public void getAndDisplay(CreateRecipeState currentState) {
        String recipeName = currentState.getRecipeName();
        String recipeContent = currentState.getRecipeContent();
        String calories = currentState.getCalories();
        String lastEditTime = currentState.getLastEditTime();
        recipeNameLabel.setText(recipeName);
        recipeContentTextArea.setText(recipeContent);
        caloriesLabel.setText("Calories: " + calories);
        lastEditTimeLabel.setText("Last Edited: " + lastEditTime);
    }

}

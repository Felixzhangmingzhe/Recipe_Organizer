package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class MainView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "main";

    private final JButton recipe;
    private final JButton favorites;
    private final JButton user;

    private final JButton cancel;

    public MainView(JButton cancel) {
        this.cancel = cancel;
        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        recipe = new JButton("Recipe");
        buttons.add(recipe);
        favorites = new JButton("Favorites");
        buttons.add(favorites);
        user = new JButton("User");
        buttons.add(user);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(title);
        add(buttons);
    }

    public void addRecipeButtonListener(ActionListener listener) {
        recipe.addActionListener(listener);
    }

    public void addFavoritesButtonListener(ActionListener listener) {
        favorites.addActionListener(listener);
    }

    public void addUserButtonListener(ActionListener listener) {
        user.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

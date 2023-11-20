package view;

import entity.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class FavoritesView {
    JPanel TotalFavoritesPanel;// 创建总收藏夹面板,显示所有收藏夹
    JPanel FavoritesPanel;// 创建收藏夹面板,显示单个收藏夹的内容(收藏的菜谱)
    JButton backButton;// 创建返回按钮
    // 构造函数
    public FavoritesView() {
        TotalFavoritesPanel = new JPanel();
        FavoritesPanel = new JPanel();

        // 在构造函数中可以进行面板的初始化工作
        // 例如设置布局、添加组件等
        // 例如：
        // TotalfavoritesPanel.setLayout(new GridLayout(2, 2));
        // JLabel label = new JLabel("收藏夹1");
        // TotalfavoritesPanel.add(label);
        // 假设totalFavoritesCount是收藏夹的总数

// 其他代码...

        try {
            // Read data from JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get("path/to/your/favorites.json")));
            JSONArray favoritesArray = new JSONArray(jsonContent);

            int i = 1;

            for (Object obj : favoritesArray) {
                if (obj instanceof JSONObject) {
                    JSONObject folderJson = (JSONObject) obj;
                    String folderName = folderJson.optString("name");

                    JButton folderButton = new JButton("Favorites" + i + ":" + folderName);
                    folderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                    folderButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            showSingleFolder(); // When a button in the totalFavoritesPanel is clicked, show the single folder
                        }
                    });

                    TotalFavoritesPanel.add(folderButton);

                    i++;
                }
            }

            // If the number of folders is less than 10, fill with blank buttons如果收藏夹数量小于10，则用空白按钮填充
            while (i <= 10) {
                JButton emptyButton = new JButton();
                emptyButton.setOpaque(true);
                emptyButton.setBackground(Color.WHITE);
                emptyButton.setBorderPainted(false);
                emptyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                TotalFavoritesPanel.add(emptyButton);

                i++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FavoritesPanel = new JPanel();
        backButton = new JButton("Return");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTotalFavorites(); // 点击返回按钮时，显示总收藏夹
            }
        });
    }

    // 获取总收藏夹面板
    public JPanel getTotalfavoritesPanel() {
        return TotalFavoritesPanel;
    }

    // 获取单个收藏夹面板
    public JPanel getFavoritesPanel() {
        return FavoritesPanel;
    }

    // 设置单个收藏夹面板
    public void setFavoritesPanel(JPanel panel) {
        this.FavoritesPanel = panel;
    }

    // 添加组件到单个收藏夹面板?????
    public void addToFavoritesPanel(Component component) {
        FavoritesPanel.add(component);
    }
    public void showTotalFavorites() {
        JFrame frame = new JFrame("Total Favorites");
        frame.getContentPane().add(TotalFavoritesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // 显示单个收藏夹
    public void showSingleFolder() {
        JFrame frame = new JFrame("Favorites");
        frame.getContentPane().add(FavoritesPanel);
        frame.getContentPane().add(backButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

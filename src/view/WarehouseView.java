package view;
// 显示所有数据库里有的食谱
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class WarehouseView {
    JPanel WarehousePanel;// 创建总收藏夹面板,显示所有收藏夹
    public WarehouseView() {
        WarehousePanel = new JPanel();

        try {
            FileInputStream serviceAccount = new FileInputStream("path/to/your/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://your-database-name.firebaseio.com/") // 替换成你的数据库URL
                    .build();

            FirebaseApp.initializeApp(options);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("recipes");

            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int i = 1;

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String recipeName = snapshot.child("name").getValue(String.class);

                        JLabel recipeLabel = new JLabel("菜谱 " + i + ": " + recipeName);
                        recipeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        WarehousePanel.add(recipeLabel);

                        i++;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel getWarehousePanel() {
        return WarehousePanel;
    }

    public static void main(String[] args) {
        WarehouseView warehouseView = new WarehouseView();

        JFrame frame = new JFrame("Warehouse View");
        frame.getContentPane().add(warehouseView.getWarehousePanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

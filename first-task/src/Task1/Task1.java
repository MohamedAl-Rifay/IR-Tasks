package Task1;
import GUI.MainMenu;
import javax.swing.UnsupportedLookAndFeelException;
public class Task1 {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getInstalledLookAndFeels()[3].getClassName());
            new MainMenu().setVisible(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
    }

}

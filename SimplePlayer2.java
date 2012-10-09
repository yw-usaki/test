import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.File;
import javax.media.Player;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.protocol.DataSource;

public class SimplePlayer2 {
    public static void main(final String[] args) {
        JFrame app = new JFrame();
        try {
            File file = new File("C:/Users/1151118/test.wmv");
			MediaLocator locator = new MediaLocator(file.toString());
            DataSource source = Manager.createDataSource(locator);
            Player player = Manager.createRealizedPlayer(source);
            if (player.getVisualComponent() != null) {
                app.getContentPane().add(
                    player.getVisualComponent(), BorderLayout.CENTER
                );
                app.getContentPane().add(
                    player.getControlPanelComponent(), BorderLayout.NORTH
                );
            }
            app.pack();
            app.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package nicolas.vycas.nery.client;

import java.util.logging.Logger;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class App {

    private final static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            logger.severe(ex.getMessage());
        } catch (InstantiationException ex) {
            logger.severe(ex.getMessage());
        } catch (IllegalAccessException ex) {
            logger.severe(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            logger.severe(ex.getMessage());
        }
        /* Create and display the ClientUIJFrame */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientUIJFrame().setVisible(true);
            }
        });
    }
}

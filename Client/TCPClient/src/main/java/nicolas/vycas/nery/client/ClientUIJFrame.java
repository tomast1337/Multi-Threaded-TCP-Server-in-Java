package nicolas.vycas.nery.client;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Nicolas Vycas Nery
 */
public class ClientUIJFrame extends JFrame {

    public ClientUIJFrame() {
        initComponents();
        // make this window appear in the center of the screen
        this.setLocationRelativeTo(null);
        // make the window not resizable
        this.setResizable(false);
    }

    private TCPClient tcpClient;
    private final static Logger logger = Logger.getLogger(ClientUIJFrame.class.getName());
    private Thread receiverThread;
    private boolean isConnect = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jButtonConnect = new JButton();
        jTextFieldPort = new JTextField();
        jLabelPort = new JLabel();
        jTextFieldHost = new JTextField();
        jLabelHost = new JLabel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextAreaMessages = new JTextArea();
        jLabelMessages = new JLabel();
        jLabelMessage = new JLabel();
        jTextFieldMessage = new JTextField();
        jButtonSend = new JButton();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jTextFieldPort.setText("8080");
        jTextFieldPort.setToolTipText("host port");

        jLabelPort.setText("port");

        jTextFieldHost.setText("localhost");
        jTextFieldHost.setToolTipText("host ip");

        jLabelHost.setText("host");

        jPanel2.setToolTipText("");

        jTextAreaMessages.setEditable(false);
        jTextAreaMessages.setColumns(20);
        jTextAreaMessages.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMessages);

        jLabelMessages.setText("Messages");

        jLabelMessage.setText("Message");

        jTextFieldMessage.setToolTipText("Type Your message here");
        jTextFieldMessage.setEnabled(false);
        jTextFieldMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMessageKeyPressed(evt);
            }
        });

        jButtonSend.setText("Send");
        jButtonSend.setEnabled(false);
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabelMessage)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldMessage))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabelMessages)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jButtonSend, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelMessages)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldMessage, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelMessage))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSend)
                                .addContainerGap()));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelHost)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldHost)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPort)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPort, GroupLayout.PREFERRED_SIZE, 120,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConnect, GroupLayout.PREFERRED_SIZE, 88,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldPort, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelHost)
                                        .addComponent(jTextFieldHost, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPort)
                                        .addComponent(jButtonConnect))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jLabel1.setText("TCP Client");

        jLabel2.setText("Nicolas Vycas Nery 2023.2");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMessageKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sendHandle();
        }
    }

    private void sendHandle() {
        String message = this.jTextFieldMessage.getText();
        if (this.tcpClient != null && message != null && !message.isEmpty()) {
            try {
                this.tcpClient.send(message);
                this.jTextFieldMessage.setText("");
                // this.jTextAreaMessages.append("You: " + message + "\n");
            } catch (Exception e) {
                logger.severe(e.getMessage());
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jButtonSendActionPerformed(ActionEvent evt) {
        sendHandle();
    }

    private void jButtonConnectActionPerformed(ActionEvent evt) {
        String host = jTextFieldHost.getText();
        int port = Integer.parseInt(jTextFieldPort.getText());

        this.tcpClient = TCPClient.create(host, port);
        try {
            this.tcpClient.connect();
            this.jButtonConnect.setEnabled(false);
            this.jTextFieldHost.setEnabled(false);
            this.jTextFieldPort.setEnabled(false);
            this.jButtonSend.setEnabled(true);

            this.jTextFieldMessage.setEnabled(true);
            this.jTextAreaMessages.setEnabled(true);
            this.jTextFieldMessage.setText("");

            JOptionPane.showMessageDialog(this, "Connected to " + host + ":" + port, "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            this.jTextFieldMessage.requestFocus();
            this.isConnect = true;
            this.receiverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String message = tcpClient.receive();
                            if (message == null) {
                                continue;
                            }
                            jTextAreaMessages.append(message + "\n");
                            Thread.sleep(500);
                        } catch (IOException e) {
                            logger.severe(e.getMessage());
                            JOptionPane.showMessageDialog(ClientUIJFrame.this, e.getMessage(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        } catch (InterruptedException e) {
                            logger.severe(e.getMessage());
                            JOptionPane.showMessageDialog(ClientUIJFrame.this, e.getMessage(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        if (isConnect == false) {
                            break;
                        }
                    }
                }
            });

            this.receiverThread.start();
        } catch (HeadlessException e) {
            logger.severe(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            logger.severe(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void formWindowClosing(WindowEvent evt) {
        try {
            if (this.tcpClient != null) {
                this.tcpClient.disconnect();
                this.isConnect = false;
                this.receiverThread.interrupt();
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonConnect;
    private JButton jButtonSend;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabelHost;
    private JLabel jLabelMessage;
    private JLabel jLabelMessages;
    private JLabel jLabelPort;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaMessages;
    private JTextField jTextFieldHost;
    private JTextField jTextFieldMessage;
    private JTextField jTextFieldPort;
    // End of variables declaration//GEN-END:variables
}
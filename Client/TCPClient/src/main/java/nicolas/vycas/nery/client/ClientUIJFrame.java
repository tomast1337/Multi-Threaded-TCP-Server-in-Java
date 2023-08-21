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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMessages = new javax.swing.JTextArea();
        jLabelMessage = new javax.swing.JLabel();
        jTextFieldMessage = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonDisconnect = new javax.swing.JButton();
        jButtonConnect = new javax.swing.JButton();
        jTextFieldPort = new javax.swing.JTextField();
        jLabelPort = new javax.swing.JLabel();
        jTextFieldHost = new javax.swing.JTextField();
        jLabelHost = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Messages"));
        jPanel2.setToolTipText("");

        jTextAreaMessages.setEditable(false);
        jTextAreaMessages.setColumns(20);
        jTextAreaMessages.setRows(5);
        jTextAreaMessages.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaMessages);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMessage))
                    .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSend)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection Options"));

        jButtonDisconnect.setText("Disconnect");
        jButtonDisconnect.setEnabled(false);
        jButtonDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisconnectActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldHost, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDisconnect, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHost)
                    .addComponent(jTextFieldHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPort)
                    .addComponent(jButtonDisconnect)
                    .addComponent(jButtonConnect))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("TCP Client");

        jLabel2.setText("Nicolas Vycas Nery 2023.2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void disconnectHandle() {
        try {
            if (this.tcpClient != null) {
                this.tcpClient.disconnect();
                this.isConnect = false;
                this.receiverThread.interrupt();
                this.jButtonConnect.setEnabled(true);
                this.jButtonDisconnect.setEnabled(false);
                this.jTextFieldHost.setEnabled(true);
                this.jTextFieldPort.setEnabled(true);
                this.jButtonSend.setEnabled(false);

                this.jTextFieldMessage.setEnabled(false);
                this.jTextAreaMessages.setEnabled(false);
                this.jTextFieldMessage.setText("");

                JOptionPane.showMessageDialog(this, "Disconnected", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            this.jButtonDisconnect.setEnabled(true);
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

    private void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDisconnectActionPerformed
        disconnectHandle();
    }// GEN-LAST:event_jButtonDisconnectActionPerformed

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
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelHost;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMessages;
    private javax.swing.JTextField jTextFieldHost;
    private javax.swing.JTextField jTextFieldMessage;
    private javax.swing.JTextField jTextFieldPort;
    // End of variables declaration//GEN-END:variables
}
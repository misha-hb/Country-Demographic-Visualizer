package login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 * Login Window for the system
 */
public class LoginWindow extends javax.swing.JFrame {

    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel usrLabel;
    private javax.swing.JLabel pwdLabel;
    private javax.swing.JTextField textUsername;
    private javax.swing.JPasswordField textPassword;

    
    public LoginWindow() {
        initComponents();
    }
    
    
    private void submitButtonPerformed(java.awt.event.ActionEvent evt) {
        String username = textUsername.getText();
        String password = String.valueOf(textPassword.getPassword());
        
        Login proxy = new LoginProxy(username, password);
       
        if (!proxy.authenticate()) {
        	javax.swing.JFrame errorWindow = new javax.swing.JFrame();
        	errorWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        	JOptionPane.showMessageDialog(errorWindow, "Username or password is incorrect.");
        	errorWindow.dispose();
        }
        dispose();
    }
    
    
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }


    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        usrLabel = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        pwdLabel = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        usrLabel.setText("Username: ");

        pwdLabel.setText("Password: ");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usrLabel)
                    .addComponent(pwdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textUsername)
                    .addComponent(textPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addGap(0, 65, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usrLabel)
                    .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdLabel)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        

        pack();
    }

}
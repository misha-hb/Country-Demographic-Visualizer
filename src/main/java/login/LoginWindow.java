package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 * Validates user login through JFrame login window
 */
public class LoginWindow extends JFrame {

    private JPanel mainPanel;
    private JButton submitButton;
    private JLabel usrLabel;
    private JLabel pwdLabel;
    private JTextField textUsername;
    private JPasswordField textPassword;

    
    public LoginWindow() {
        initComponents();
    }
    
    /**
     * Invoked by trigger on the submit button
     * Validates input credentials
     * Displays the main user interface if credentials are valid
     * Displays error window and terminates system otherwise
     * @param evt
     */
    private void submitButtonPerformed(ActionEvent evt) {
        String username = textUsername.getText();
        String password = String.valueOf(textPassword.getPassword());
        
        if (username.contentEquals("") || password.contentEquals("")) {
        	JFrame errorWindow = new JFrame();
        	errorWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        	JOptionPane.showMessageDialog(errorWindow, "Username or password field is blank");
        	errorWindow.dispose();
        	return;
        }
        
        Login proxy = new LoginProxy(username, password);
       
        if (!proxy.authenticate()) {
        	JFrame errorWindow = new JFrame();
        	errorWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        	JOptionPane.showMessageDialog(errorWindow, "Username or password is incorrect.");
        	errorWindow.dispose();
        }
        dispose();
    }
    

    /**
     * Displays login window
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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

    /**
     * Initiates window graphic components
     */
    private void initComponents() {

        mainPanel = new JPanel();
        usrLabel = new JLabel();
        textUsername = new JTextField();
        pwdLabel = new JLabel();
        textPassword = new JPasswordField();
        submitButton = new JButton();

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        usrLabel.setText("Username: ");

        pwdLabel.setText("Password: ");

        submitButton.setText("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
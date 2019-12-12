import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI {
    public JFrame view;

    //public JButton btnSystemConfiguration = new JButton("Setup System Configuration");
    public JButton btnManageUser= new JButton("Add New User or Update User Class");
    public JButton btnChangeUserInfo= new JButton("Change Password or Fullname");
    //public JButton btnEditUserClass = new JButton("Edit User Class");

    public AdminUI(UserModel user) {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Admin View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        //panelButtons.add(btnSystemConfiguration);
        panelButtons.add(btnManageUser);
        panelButtons.add(btnChangeUserInfo);
        //panelButtons.add(btnEditUserClass);

        view.getContentPane().add(panelButtons);


        btnManageUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageUserUI ui = new ManageUserUI();
                ui.run();
            }
        });

        btnChangeUserInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChangeUserInfoUI ui = new ChangeUserInfoUI();
                ui.run();
            }
        });

    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSearchUI {

    public JFrame view;
    public JTable productTable;
    public UserModel user = null;

    public JButton btnSearch = new JButton("Search");

    public JTextField txtName = new JTextField(20);
    public JTextField txtMaxPrice = new JTextField(20);
    public JTextField txtMinPrice = new JTextField(20);


    public ProductSearchUI(UserModel user) {
        this.user = user;

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Search Product");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnSearch);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("Product Name: "));
        line1.add(txtName);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Max Price: "));
        line2.add(txtMaxPrice);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Min Price: "));
        line3.add(txtMinPrice);
        view.getContentPane().add(line3);

        btnSearch.addActionListener(new SearchButtonListerner());


    }
    public void run() {
        view.setVisible(true);
    }
    class SearchButtonListerner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JLabel title = new JLabel("Search results for " + user.mFullname);

            title.setFont (title.getFont().deriveFont (24.0f));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            view.getContentPane().add(title);

            String name = txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Product name cannot be empty!");
                return;
            }

            String maxPrice = txtMaxPrice.getText();
            double maxPriceDouble;
            try {
                maxPriceDouble = Double.parseDouble(maxPrice);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            String minPrice = txtMinPrice.getText();
            double minPriceDouble;
            try {
                minPriceDouble = Double.parseDouble(minPrice);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            ProductListUI ui = new ProductListUI(name,minPriceDouble,maxPriceDouble);
            ui.run();
        }
    }
}

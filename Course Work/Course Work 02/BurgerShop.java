import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


// ===== HomePage Class =====
class HomePage extends JFrame {
    
    // ===== Button Declaration =====
    private JButton btnPlaceOrder;
    private JButton btnSearch;
    private JButton btnViewOrders;
    private JButton btnUpdateOrderDetails;
    private JButton btnExit;
    
    private JLabel lblImage;
    
    // Constructor - HomePage
    public HomePage() {
        setTitle("iHungry Burger Shop Management System");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
    }
    
    private void initComponents() {
        // ===== MAIN PANEL - BorderLayout =====
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 222, 179)); // Light brown
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // ===== CENTER PANEL - Left (Welcome + Image) | Right (Buttons) =====
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(245, 222, 179));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // ---- LEFT SIDE: Welcome + Image ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        centerPanel.add(createLeftPanel(), gbc);
        
        // ---- RIGHT SIDE: Buttons ----
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        centerPanel.add(createRightPanel(), gbc);
        
        // ===== BOTTOM PANEL - @ICET =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(new Color(139, 69, 19)); // Brown
        bottomPanel.setPreferredSize(new Dimension(900, 40));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel lblICET = new JLabel("@ICET");
        lblICET.setFont(new Font("Arial", Font.BOLD, 16));
        lblICET.setForeground(Color.WHITE);
        bottomPanel.add(lblICET);
        
        // Add all panels to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        addActionListeners();
    }
    
    // ===== LEFT PANEL: Welcome + Image =====
    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(245, 222, 179));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
        
        // ---- Title Section ----
        JPanel titlePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        JLabel lblWelcome = new JLabel("Welcome to", JLabel.CENTER);
        lblWelcome.setFont(new Font("Serif", Font.PLAIN, 28));
        lblWelcome.setForeground(new Color(139, 69, 19));
        
        JLabel lblTitle = new JLabel("BURGERS", JLabel.CENTER);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 52));
        lblTitle.setForeground(new Color(139, 69, 19));
        lblTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(139, 69, 19)));
        
        titlePanel.add(lblWelcome);
        titlePanel.add(lblTitle);
        
        // ---- Image Section ----
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(245, 222, 179));
        imagePanel.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2));
        
        // Load Image from images folder
        loadImage();
        imagePanel.add(lblImage, BorderLayout.CENTER);
        
        // Add to left panel
        leftPanel.add(titlePanel, BorderLayout.NORTH);
        leftPanel.add(imagePanel, BorderLayout.CENTER);
        
        return leftPanel;
    }
    
    // ===== Load Image Method =====
    private void loadImage() {
        try {
            // FIX: Image path changed to images folder
            File imgFile = new File("images/BugerShop.png");
            
            if (imgFile.exists()) {
                ImageIcon burgerIcon = new ImageIcon(imgFile.getAbsolutePath());
                Image img = burgerIcon.getImage();
                Image resizedImg = img.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImg);
                
                lblImage = new JLabel(resizedIcon);
                lblImage.setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                // If image not found, show text
                lblImage = new JLabel("BURGER", JLabel.CENTER);
                lblImage.setFont(new Font("Serif", Font.BOLD, 80));
                lblImage.setForeground(new Color(139, 69, 19));
                System.out.println("Image not found at: images/burgerShop.png");
                System.out.println("Current directory: " + System.getProperty("user.dir"));
            }
        } catch (Exception e) {
            lblImage = new JLabel("BURGER", JLabel.CENTER);
            lblImage.setFont(new Font("Serif", Font.BOLD, 80));
            lblImage.setForeground(new Color(139, 69, 19));
            System.out.println("Error loading image: " + e.getMessage());
        }
    }
    
    // ===== RIGHT PANEL: Buttons =====
    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(245, 222, 179));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        
        // Buttons Create
        btnPlaceOrder = createStyledButton("Place Order");
        btnSearch = createStyledButton("Search");
        btnViewOrders = createStyledButton("View Orders");
        btnUpdateOrderDetails = createStyledButton("Update Order Details");
        btnExit = createStyledButton("Exit");
        
        // Buttons Add
        gbc.gridy = 0;
        rightPanel.add(btnPlaceOrder, gbc);
        
        gbc.gridy = 1;
        rightPanel.add(btnSearch, gbc);
        
        gbc.gridy = 2;
        rightPanel.add(btnViewOrders, gbc);
        
        gbc.gridy = 3;
        rightPanel.add(btnUpdateOrderDetails, gbc);
        
        // Exit Button - Bottom Right
        gbc.gridy = 4;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        rightPanel.add(btnExit, gbc);
        
        return rightPanel;
    }
    
    // ===== Styled Button Create Method =====
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(210, 180, 140));
        button.setForeground(new Color(80, 40, 20));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(139, 69, 19), 2),
            BorderFactory.createEmptyBorder(14, 25, 14, 25)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover Effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(188, 143, 143));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(210, 180, 140));
            }
        });
        
        return button;
    }
    
    // ===== Button Actions =====
    private void addActionListeners() {
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HomePage.this, "Place Order Window Coming Soon!");
            }
        });
        
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HomePage.this, "Search Window Coming Soon!");
            }
        });
        
        btnViewOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HomePage.this, "View Orders Window Coming Soon!");
            }
        });
        
        btnUpdateOrderDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HomePage.this, "Update Order Details Window Coming Soon!");
            }
        });
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    HomePage.this,
                    "Are you sure you want to exit?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}

// ===== BurgerShop Class =====
class BurgerShop {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
}

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ChatGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel chatDisplayPanel;
    private JTextField messageField;
    private JButton sendButton;
    private JButton addParticipantButton;
    private JComboBox<String> participantSelector;
    private JLabel statusLabel;
    private ChatRoom chatRoom;
    private List<ChatParticipant> participants;
    private JButton adminButton;
    
    public ChatGUI() {
        this.chatRoom = new ChatRoom();
        this.participants = new ArrayList<>();
        initUI();
    }
    
    private void initUI() {
        setTitle("iCET Chat Application - OOP Coursework");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 550);
        setLocationRelativeTo(null);
        
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(240, 248, 255));
        
        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Chat Display Panel
        chatDisplayPanel = createChatDisplayPanel();
        JScrollPane scrollPane = new JScrollPane(chatDisplayPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Input Panel
        JPanel inputPanel = createInputPanel();
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setVisible(true);
        
        // Add welcome message
        updateChatDisplay("SYSTEM", "🚀 Welcome to iCET Chat Application!");
        updateChatDisplay("SYSTEM", "💡 Click 'Add Participant' to join the chat");
        updateChatDisplay("SYSTEM", "📝 Select your name and start messaging");
    }
    
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(70, 130, 180));
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        
        JLabel titleLabel = new JLabel("💬 iCET Chat Room");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.WEST);
        
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setOpaque(false);
        
        JLabel participantLabel = new JLabel("Participant:");
        participantLabel.setForeground(Color.WHITE);
        rightPanel.add(participantLabel);
        
        participantSelector = new JComboBox<>();
        participantSelector.setPreferredSize(new Dimension(130, 25));
        rightPanel.add(participantSelector);
        
        addParticipantButton = new JButton("➕ Add");
        addParticipantButton.setBackground(new Color(50, 205, 50));
        addParticipantButton.setForeground(Color.WHITE);
        addParticipantButton.setFocusPainted(false);
        addParticipantButton.addActionListener(e -> addParticipant());
        rightPanel.add(addParticipantButton);
        
        adminButton = new JButton("👑 Admin");
        adminButton.setBackground(new Color(255, 165, 0));
        adminButton.setForeground(Color.WHITE);
        adminButton.setFocusPainted(false);
        adminButton.addActionListener(e -> showAdminPanel());
        rightPanel.add(adminButton);
        
        header.add(rightPanel, BorderLayout.EAST);
        return header;
    }
    
    private JPanel createChatDisplayPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        return panel;
    }
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JPanel messagePanel = new JPanel(new BorderLayout(10, 0));
        
        messageField = new JTextField();
        messageField.setFont(new Font("Arial", Font.PLAIN, 14));
        messageField.addActionListener(e -> sendMessage());
        messageField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        
        sendButton = new JButton("📤 Send");
        sendButton.setBackground(new Color(30, 144, 255));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.addActionListener(e -> sendMessage());
        sendButton.setFont(new Font("Arial", Font.BOLD, 12));
        
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);
        
        statusLabel = new JLabel("Ready - Add a participant to start chatting");
        statusLabel.setForeground(Color.GRAY);
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 11));
        
        panel.add(messagePanel, BorderLayout.CENTER);
        panel.add(statusLabel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void addParticipant() {
        String name = JOptionPane.showInputDialog(this, 
            "Enter participant name:", 
            "Add New Participant", 
            JOptionPane.QUESTION_MESSAGE);
            
        if (name != null && !name.trim().isEmpty()) {
            ChatParticipant participant;
            
            if (name.toLowerCase().contains("admin")) {
                participant = new AdminParticipant(name.trim());
                updateChatDisplay("SYSTEM", "👑 " + name.trim() + " joined as ADMIN!");
            } else {
                participant = new ChatParticipant(name.trim());
                updateChatDisplay("SYSTEM", "👋 " + name.trim() + " joined the chat!");
            }
            
            participants.add(participant);
            chatRoom.addParticipant(participant);
            participantSelector.addItem(name.trim());
            participantSelector.setSelectedItem(name.trim());
            statusLabel.setText("✓ " + name.trim() + " added to chat");
            
            // Update participant count
            updateTitle();
        }
    }
    
    private void updateTitle() {
        setTitle("iCET Chat Application - " + participants.size() + " participants");
    }
    
    private void sendMessage() {
        String selectedParticipant = (String) participantSelector.getSelectedItem();
        String message = messageField.getText().trim();
        
        if (selectedParticipant == null) {
            JOptionPane.showMessageDialog(this, 
                "Please add a participant first!", 
                "No Participant", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a message!", 
                "Empty Message", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ChatParticipant sender = findParticipantByName(selectedParticipant);
        if (sender != null) {
            // Send message to all participants
            sender.sendMessage(message, chatRoom);
            
            // Display message in GUI
            updateChatDisplay(selectedParticipant, message);
            messageField.setText("");
            statusLabel.setText("📨 Message sent by " + selectedParticipant + " at " + 
                java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
        }
    }
    
    private ChatParticipant findParticipantByName(String name) {
        for (ChatParticipant p : participants) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
    private void updateChatDisplay(String sender, String message) {
        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        messagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        messagePanel.setBackground(Color.WHITE);
        
        // Time stamp
        String time = java.time.LocalTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        
        JPanel bubblePanel = new JPanel();
        bubblePanel.setLayout(new BoxLayout(bubblePanel, BoxLayout.Y_AXIS));
        
        // Sender name with time
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        
        JLabel senderLabel = new JLabel(sender);
        senderLabel.setFont(new Font("Arial", Font.BOLD, 13));
        
        if (sender.equals("SYSTEM")) {
            senderLabel.setForeground(new Color(255, 69, 0));
        } else if (sender.toLowerCase().contains("admin")) {
            senderLabel.setForeground(new Color(255, 165, 0));
        } else {
            senderLabel.setForeground(new Color(70, 130, 180));
        }
        
        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        timeLabel.setForeground(Color.GRAY);
        
        headerPanel.add(senderLabel, BorderLayout.WEST);
        headerPanel.add(timeLabel, BorderLayout.EAST);
        
        // Message content
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        bubblePanel.add(headerPanel);
        bubblePanel.add(Box.createRigidArea(new Dimension(0, 2)));
        bubblePanel.add(messageLabel);
        
        // Bubble styling
        if (sender.equals("SYSTEM")) {
            bubblePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 200, 200), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
            ));
            bubblePanel.setBackground(new Color(255, 240, 240));
        } else {
            bubblePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
            ));
            bubblePanel.setBackground(new Color(240, 248, 255));
        }
        
        bubblePanel.setOpaque(true);
        messagePanel.add(bubblePanel, BorderLayout.WEST);
        
        chatDisplayPanel.add(messagePanel);
        chatDisplayPanel.add(Box.createRigidArea(new Dimension(0, 3)));
        chatDisplayPanel.revalidate();
        chatDisplayPanel.repaint();
        
        // Auto scroll to bottom
        SwingUtilities.invokeLater(() -> {
            JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(
                JScrollPane.class, chatDisplayPanel);
            if (scrollPane != null) {
                scrollPane.getVerticalScrollBar().setValue(
                    scrollPane.getVerticalScrollBar().getMaximum());
            }
        });
    }
    
    private void showAdminPanel() {
        String[] options = {"Kick User", "View Users", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
            "Admin Panel - Select Action",
            "👑 Admin Controls",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[2]);
        
        if (choice == 0) {
            // Kick User
            if (participants.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No participants to kick!");
                return;
            }
            
            String[] userNames = participants.stream()
                .map(ChatParticipant::getName)
                .toArray(String[]::new);
            
            String selected = (String) JOptionPane.showInputDialog(this,
                "Select user to kick:",
                "Kick User",
                JOptionPane.QUESTION_MESSAGE,
                null,
                userNames,
                userNames[0]);
            
            if (selected != null) {
                ChatParticipant target = findParticipantByName(selected);
                if (target != null && !(target instanceof AdminParticipant)) {
                    participants.remove(target);
                    participantSelector.removeItem(selected);
                    updateChatDisplay("SYSTEM", "👢 " + selected + " was kicked by Admin!");
                    statusLabel.setText("🔴 " + selected + " kicked from chat");
                    updateTitle();
                } else if (target instanceof AdminParticipant) {
                    JOptionPane.showMessageDialog(this, "Cannot kick an Admin!");
                }
            }
        } else if (choice == 1) {
            // View Users
            StringBuilder users = new StringBuilder("👥 All Participants:\n\n");
            for (ChatParticipant p : participants) {
                String type = (p instanceof AdminParticipant) ? "👑 Admin" : "👤 User";
                users.append(type).append(": ").append(p.getName()).append("\n");
            }
            JOptionPane.showMessageDialog(this, users.toString(), "User List", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new ChatGUI();
        });
    }
}

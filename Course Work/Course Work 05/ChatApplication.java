import java.util.Scanner;

public class ChatApplication {
    private ChatRoom chatRoom;
    private Scanner scanner;
    
    public ChatApplication() {
        this.chatRoom = new ChatRoom();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("=========================================");
        System.out.println("    WELCOME TO iCET CHAT APPLICATION    ");
        System.out.println("=========================================");
        
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Join Chat");
            System.out.println("2. Send Message");
            System.out.println("3. View Chat History");
            System.out.println("4. Add New Participant");
            System.out.println("5. View All Participants");
            System.out.println("6. Admin Kick Participant");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    joinChat();
                    break;
                case 2:
                    sendMessage();
                    break;
                case 3:
                    viewChatHistory();
                    break;
                case 4:
                    addNewParticipant();
                    break;
                case 5:
                    viewAllParticipants();
                    break;
                case 6:
                    adminKickParticipant();
                    break;
                case 7:
                    System.out.println("Exiting chat application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private void joinChat() {
        System.out.print("Enter your name to join the chat: ");
        String name = scanner.nextLine();
        if (name.toLowerCase().contains("admin")) {
            AdminParticipant admin = new AdminParticipant(name);
            chatRoom.addParticipant(admin);
            System.out.println("Welcome Admin: " + name);
        } else {
            ChatParticipant participant = new ChatParticipant(name);
            chatRoom.addParticipant(participant);
            System.out.println("Welcome: " + name);
        }
    }
    
    private void sendMessage() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        ChatParticipant sender = findParticipant(name);
        if (sender != null) {
            System.out.print("Enter your message: ");
            String message = scanner.nextLine();
            sender.sendMessage(message, chatRoom);
            System.out.println("✓ Message sent!");
        } else {
            System.out.println("❌ Participant not found. Please join the chat first.");
        }
    }
    
    private ChatParticipant findParticipant(String name) {
        for (ChatParticipant p : chatRoom.getParticipants()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
    private void viewChatHistory() {
        System.out.println("\n===== CHAT HISTORY =====");
        if (chatRoom.getChatHistory().isEmpty()) {
            System.out.println("No messages yet.");
        } else {
            for (Message msg : chatRoom.getChatHistory()) {
                System.out.println(msg);
            }
        }
        System.out.println("=========================");
    }
    
    private void addNewParticipant() {
        System.out.print("Enter name of new participant: ");
        String name = scanner.nextLine();
        if (name.toLowerCase().contains("admin")) {
            AdminParticipant admin = new AdminParticipant(name);
            chatRoom.addParticipant(admin);
        } else {
            ChatParticipant newParticipant = new ChatParticipant(name);
            chatRoom.addParticipant(newParticipant);
        }
        System.out.println("✓ Participant added successfully!");
    }
    
    private void viewAllParticipants() {
        System.out.println("\n===== ALL PARTICIPANTS =====");
        if (chatRoom.getParticipants().isEmpty()) {
            System.out.println("No participants yet.");
        } else {
            System.out.println("Total: " + chatRoom.getParticipants().size() + " participants");
            System.out.println("-----------------------------");
            for (ChatParticipant p : chatRoom.getParticipants()) {
                String type = (p instanceof AdminParticipant) ? "👑 [ADMIN]" : "👤 [USER]";
                System.out.println(type + " " + p.getName());
            }
        }
        System.out.println("==============================");
    }
    
    private void adminKickParticipant() {
        System.out.print("Enter admin name: ");
        String adminName = scanner.nextLine();
        ChatParticipant admin = findParticipant(adminName);
        
        if (admin instanceof AdminParticipant) {
            System.out.print("Enter participant name to kick: ");
            String kickName = scanner.nextLine();
            ChatParticipant target = findParticipant(kickName);
            
            if (target != null && target != admin) {
                ((AdminParticipant) admin).kickParticipant(target, chatRoom);
            } else if (target == admin) {
                System.out.println("❌ Admin cannot kick themselves!");
            } else {
                System.out.println("❌ Participant not found!");
            }
        } else {
            System.out.println("❌ You are not an admin!");
        }
    }
    
    public static void main(String[] args) {
        ChatApplication app = new ChatApplication();
        app.start();
    }
}

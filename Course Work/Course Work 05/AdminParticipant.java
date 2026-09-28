public class AdminParticipant extends ChatParticipant {
    private boolean canKick;
    private boolean canMute;
    
    public AdminParticipant(String name) {
        super(name);
        this.canKick = true;
        this.canMute = true;
    }
    
    @Override
    public void sendMessage(String content, ChatRoom chatRoom) {
        if (content.toLowerCase().contains("admin")) {
            super.sendMessage("[ADMIN] " + content, chatRoom);
        } else {
            super.sendMessage(content, chatRoom);
        }
    }
    
    @Override
    public void displayMessage(Message message) {
        if (message.getSender().equals("SYSTEM")) {
            System.out.println("🔔 " + message.getFormattedMessage());
        } else {
            System.out.println("👑 " + message.getFormattedMessage());
        }
    }
    
    public void kickParticipant(ChatParticipant participant, ChatRoom chatRoom) {
        if (canKick) {
            System.out.println("Admin " + getName() + " kicked " + participant.getName());
            chatRoom.broadcastSystemMessage(participant.getName() + " was kicked by " + getName());
        }
    }
}

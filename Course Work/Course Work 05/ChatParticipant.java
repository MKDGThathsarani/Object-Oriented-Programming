import java.util.ArrayList;
import java.util.List;

public class ChatParticipant {
    private String name;
    private List<Message> messages;
    
    public ChatParticipant(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void sendMessage(String content, ChatRoom chatRoom) {
        Message message = new Message(name, content);
        chatRoom.broadcastMessage(message, this);
    }
    
    public void receiveMessage(Message message) {
        messages.add(message);
        displayMessage(message);
    }
    
    public void displayMessage(Message message) {
        System.out.println(message.getFormattedMessage());
    }
    
    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }
}

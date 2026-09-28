import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<ChatParticipant> participants;
    private List<Message> chatHistory;
    
    public ChatRoom() {
        this.participants = new ArrayList<>();
        this.chatHistory = new ArrayList<>();
    }
    
    public void addParticipant(ChatParticipant participant) {
        participants.add(participant);
        System.out.println(participant.getName() + " joined the chat!");
        broadcastSystemMessage(participant.getName() + " joined the chat");
    }
    
    public void broadcastMessage(Message message, ChatParticipant sender) {
        chatHistory.add(message);
        for (ChatParticipant participant : participants) {
            if (participant != sender) {
                participant.receiveMessage(message);
            }
        }
    }
    
    public void broadcastSystemMessage(String content) {
        Message systemMessage = new Message("SYSTEM", content);
        chatHistory.add(systemMessage);
        for (ChatParticipant participant : participants) {
            participant.receiveMessage(systemMessage);
        }
    }
    
    public List<ChatParticipant> getParticipants() {
        return new ArrayList<>(participants);
    }
    
    public List<Message> getChatHistory() {
        return new ArrayList<>(chatHistory);
    }
}

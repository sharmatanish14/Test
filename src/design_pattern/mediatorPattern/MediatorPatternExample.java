package design_pattern.mediatorPattern;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String msg, ChatUser sender);

    void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator {
    List<ChatUser> chatUsers;

    public ChatRoom() {
        this.chatUsers = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, ChatUser sender) {
        for (ChatUser user : chatUsers) {
            if (user != sender) {
                user.receiveMessage(msg, sender);
            }
        }
    }

    @Override
    public void addUser(ChatUser user) {
        chatUsers.add(user);
    }
}

class ChatUser {
    private String name;
    private ChatMediator chatMediator;

    public ChatUser(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public void sendMessage(String msg) {
        System.out.println(name + " sending message " + msg);
        chatMediator.sendMessage(msg, this);
    }

    public void receiveMessage(String msg, ChatUser sender) {
        System.out.println(this.name + " received message " + msg + " from " + sender.name);
    }
}

public class MediatorPatternExample {


    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();

        ChatUser tanish = new ChatUser("tanish", mediator);
        ChatUser jay = new ChatUser("jay", mediator);
        ChatUser vijay = new ChatUser("vijay", mediator);

        mediator.addUser(tanish);
        mediator.addUser(jay);
        mediator.addUser(vijay);

        tanish.sendMessage("Hello everyone");
    }


}

package test;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import test.Services.ChatService;

import java.util.LinkedList;
import java.util.List;

public class ChatWebSocket {
    private ChatService chatService;
    private List<Session> sessionList= new LinkedList<>();
    private Session session = null;
    public ChatWebSocket(ChatService chatService){
        this.chatService = chatService;
    }
    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.session = session;
        sessionList.add(session);
    }
    @OnWebSocketClose
    public void onClose(Session session){
        sessionList.remove(session);
    }
    @OnWebSocketError
    public void onError(Session session, Throwable throwable){
        throwable.printStackTrace();
    }
    @OnWebSocketMessage
    public void onMessage(Session session, Message message){
       //sessionList.forEach(s -> s.get);
    }

}

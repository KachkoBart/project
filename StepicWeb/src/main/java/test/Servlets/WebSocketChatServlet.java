package test.Servlets;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import test.ChatWebSocket;
import test.Services.ChatService;

public class WebSocketChatServlet extends WebSocketServlet {
private static final int LOGOUT_OUT = 10 * 60 * 1000;
    private final ChatService chatService;
    public WebSocketChatServlet(ChatService chatService){
        this.chatService = chatService;
    }
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(LOGOUT_OUT);
//        factory.setCreator((req, resp) -> new ChatWebSocket(chatService));
    }
}

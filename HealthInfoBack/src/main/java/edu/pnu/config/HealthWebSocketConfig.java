package edu.pnu.config;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;

@Configuration
@EnableWebSocket	// Boot WebSocket 활성화
public class HealthWebSocketConfig extends TextWebSocketHandler implements WebSocketConfigurer {

	// 연결된 클라이언트들을 저정하는 Set
	// WebSocketSession 객체를 만들어서 clients에 추가한다. Collections.synchronizedSet으로 감싸면 다중 스레드 환경에서 쓸 수 있다고 함.
	private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	public void pushService(String msg) throws IOException {
		// 연결된 클라이언트가 없으면 그냥 리턴
	    if (clients.size() == 0) {
	    	System.out.println("연결된 클라이언트가 없습니다.");
	    	return;
    	}
		
	    // msg를 Bytes 형태로 받아서 객체를 만들고
		TextMessage message = new TextMessage(msg.getBytes());
		
		// 모든 clients에 대해 sendMessage로 메시지를 날린다.
	    for(WebSocketSession sess: clients) {
	        sess.sendMessage(message);
	    }
	}
	
	// WebSocket 연결명 설정
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(this, "ws/health").setAllowedOrigins("*");
	}


	/* Client가 접속 시 호출되는 메서드 */
	@Override
	// 접속이 되면 WebSocketSession의 객체를 받아서 clients의 변수에 추가한다.
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		clients.add(session);
	    System.out.println(session + " 클라이언트 접속");
	}

	/* Client가 접속 해제 시 호출되는 메서드 */
	@Override
	// clients의 데이터타입이 set인데 그거를 없애는 거.
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session + " 클라이언트 접속 해제");
	    clients.remove(session);
	}
	
	//************************************************************************************************
	//
	@OnOpen	// 클라이언트가 접속했을 때 요청되는 메서드
	public void onOpen(WebSocketSession s) {
		System.out.println("open session : " + s.toString());
		if(!clients.contains(s)) {
			clients.add(s);
			System.out.println("session open : " + s);
		}else {
			System.out.println("이미 연결된 session!");
		}
	}
	
	@OnClose // 클라이언트의 접속이 종료되면 실행되는 메서드
	public void onClose(WebSocketSession s) {
		System.out.println("session close : " + s);
		clients.remove(s);
	}
	
	@OnMessage // 클라이언트로부터 메시지가 전송되었을 때 실행되는 메서드
	public void onMessage(WebSocketSession s) {
		System.out.println("session message : " + s);
	}
	//
	//************************************************************************************************
}

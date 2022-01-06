package com.websocket.chat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RequiredArgsConstructor     // 의존성 주입
@Configuration               // 설정 및 빈 등록
@EnableWebSocket             // 웹소켓 활성화
public class WebSockConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // end poing 는 /ws/chat 설정
        // 다른 서버에서 접속 가능하도록 CORS 설정
        // ws://localhost:8080/ws/chat
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }

}

package com.websocket.chat.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j                        // 로깅
@RequiredArgsConstructor      // 의존성 주입
@Component                    // 빈 등록
public class WebSockChatHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();      // 클라이언트 로부터 받은 메시지
        log.info("payload {}", payload);            // 출력
        TextMessage textMessage = new TextMessage("Welcome chatting server");
        session.sendMessage(textMessage);           // 클라이언트로 메세지 전송

    }
}

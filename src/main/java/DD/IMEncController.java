package DD;

import DD.model.ChatMessage;
import DD.Die;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class IMEncController {
	
	@MessageMapping("/enc.sendMessage")
	@SendTo("/topic/encounter")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		System.out.println(chatMessage.toString());
		return chatMessage;
	}
	
//	@MessageMapping("/chat.addUser")
//	@SendTo("/topic/public")
//	public ChatMessage addUser(@Payload ChatMessage chatMessage,
//			SimpMessageHeaderAccessor headerAccessor) {
//		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//		return chatMessage;
//	}
//	
//	@MessageMapping("/chat.rollDie")
//	@SendTo("/topic/public")
//	public ChatMessage rollDie(@Payload ChatMessage chatMessage) {
//		chatMessage.setType(ChatMessage.MessageType.DICE);
//		int faces = Integer.parseInt(chatMessage.getContent());
//		chatMessage.setContent(Die.roll(faces).toString());
//		System.out.println(chatMessage.toString());
//		return chatMessage;
//	}

}

package DD;

import DD.model.ChatMessage;
import DD.Die;
import DD.im.IMEncounter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class IMEncController {
	ChatMessage oldState;
	@MessageMapping("/enc.sendMessage")
	@SendTo("/topic/encounter")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		if(oldState==null) {
			oldState = chatMessage;
		}
		System.out.println(chatMessage.toString());
        IMEncounter newEncounter = IMEncounter.fromJSON(chatMessage.getContent());
        int sender = Integer.parseInt(chatMessage.getSender());
        if(newEncounter.getTurn().isNext(sender)) {
        	System.out.println("Success Correct Turn");
        	System.out.println("enc object: " + newEncounter.toString());
        	oldState = chatMessage;
        	return chatMessage;
        }
        System.out.println("Failure Incorrect Turn");
        System.out.println("enc object: " + newEncounter.toString());
        return oldState;
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

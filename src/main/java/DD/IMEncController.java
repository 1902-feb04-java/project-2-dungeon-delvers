package DD;

import DD.model.EncMessage;
import DD.Die;
import DD.im.IMEncounter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class IMEncController {
	EncMessage oldState;
	@MessageMapping("/enc.sendMessage")
	@SendTo("/topic/encounter")
	public EncMessage sendMessage(@Payload EncMessage encMessage) {
		if(oldState==null) {
			oldState = encMessage;
		}
		System.out.println(encMessage.toString());
        IMEncounter newEncounter = IMEncounter.fromJSON(encMessage.getContent());
        int sender = Integer.parseInt(encMessage.getSender());
        if(newEncounter.getTurn().isNext(sender)) {
        	System.out.println("Success Correct Turn");
        	System.out.println("enc object: " + newEncounter.toString());
        	encMessage.setContent(newEncounter.toJSON());
        	oldState = encMessage;
        	return encMessage;
        }
        System.out.println("Failure Incorrect Turn");
        System.out.println("enc object: " + newEncounter.toString());
        return oldState;
	}
	
//	@MessageMapping("/chat.addUser")
//	@SendTo("/topic/public")
//	public EncMessage addUser(@Payload EncMessage encMessage,
//			SimpMessageHeaderAccessor headerAccessor) {
//		headerAccessor.getSessionAttributes().put("username", encMessage.getSender());
//		return encMessage;
//	}
//	
//	@MessageMapping("/chat.rollDie")
//	@SendTo("/topic/public")
//	public EncMessage rollDie(@Payload EncMessage encMessage) {
//		encMessage.setType(EncMessage.MessageType.DICE);
//		int faces = Integer.parseInt(encMessage.getContent());
//		encMessage.setContent(Die.roll(faces).toString());
//		System.out.println(encMessage.toString());
//		return encMessage;
//	}

}

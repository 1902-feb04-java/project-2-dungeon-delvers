package DD;

import DD.model.EncMessage;
import DD.Die;
import DD.im.IMEncounter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class IMEncController {
	EncMessage oldState;
	ArrayList<Integer> player_accounts = new ArrayList<Integer>();
	
	@MessageMapping("/enc.sendMessage")
	@SendTo("/topic/encounter")
	public EncMessage sendMessage(@Payload EncMessage encMessage) {
		
        IMEncounter newEncounter = IMEncounter.fromJSON(encMessage.getContent());
        newEncounter.RemoveDeadMonsters();
        int sender = Integer.parseInt(encMessage.getSender());
        
        //instantiate oldState from whatever (should be DM)
		if(oldState==null) {
			oldState = encMessage;
		}
        
		if(encMessage.getType().equals(EncMessage.MessageType.CREATE)) {
			int num_monsters = newEncounter.getMonsterArray().size()-1;
			newEncounter.setTurn(new Turn(sender, num_monsters,
					player_accounts.toArray(new Integer[0])));
			encMessage.setContent(newEncounter.toJSON());
			player_accounts = new ArrayList<Integer>();
			oldState = encMessage;
			return encMessage;
		}
		
		if (encMessage.getType().equals(EncMessage.MessageType.SKIP)) {
			newEncounter.getTurn().skipTurn();
			encMessage.setContent(newEncounter.toJSON());
			oldState = encMessage;
			return encMessage;
		}

        if(encMessage.getType().equals(EncMessage.MessageType.DM)) {
        	oldState = encMessage;
	        return encMessage;
        } else if(newEncounter.getTurn().isNext(sender)) {
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
	
	@MessageMapping("/enc.join")
	public void addPlayer(@Payload EncMessage encMessage) {
		int sender = Integer.parseInt(encMessage.getSender());
		player_accounts.add(sender);
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

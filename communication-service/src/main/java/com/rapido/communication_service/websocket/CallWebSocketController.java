package com.rapido.communication_service.websocket;

import com.rapido.communication_service.dto.CallSignalDTO;
import com.rapido.communication_service.service.CallService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.Timer;
import java.util.TimerTask;

@Controller
public class CallWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private CallService callService;

    @MessageMapping("/call.signal")
    public void callSignal(CallSignalDTO signalDTO) {

        String type = signalDTO.getSignalType();

        if ("OFFER".equalsIgnoreCase(type)) {
        	callService.initiateCall(signalDTO);

        	new Timer().schedule(new TimerTask() {
        	    @Override
        	    public void run() {
        	        callService.markMissedCall(signalDTO.getRideId());
        	    }
        	}, 30000);
            System.out.println("Call initiated for rideId: " + signalDTO.getRideId());
        }

        else if ("ACCEPT".equalsIgnoreCase(type)) {
            callService.acceptCall(signalDTO);
            System.out.println("Call accepted for rideId: " + signalDTO.getRideId());
        }

        else if ("REJECT".equalsIgnoreCase(type)) {
            callService.rejectCall(signalDTO);
            System.out.println("Call rejected for rideId: " + signalDTO.getRideId());
        }

        else if ("CALL_END".equalsIgnoreCase(type)) {
            callService.endCall(signalDTO);
            System.out.println("Call ended for rideId: " + signalDTO.getRideId());
        }

        messagingTemplate.convertAndSend(
                "/topic/call/" + signalDTO.getRideId(),
                signalDTO
        );
    }
}
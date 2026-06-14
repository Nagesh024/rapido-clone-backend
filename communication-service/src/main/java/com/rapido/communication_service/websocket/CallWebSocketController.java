package com.rapido.communication_service.websocket;

import com.rapido.communication_service.dto.CallSignalDTO;
import com.rapido.communication_service.service.CallService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CallWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private CallService callService;

    @MessageMapping("/call.signal")
    public void callSignal(
            CallSignalDTO signalDTO
    ) {

        if ("OFFER".equalsIgnoreCase(
                signalDTO.getSignalType())) {

            callService.initiateCall(signalDTO);

            System.out.println(
                    "Call initiated for rideId: "
                            + signalDTO.getRideId()
            );
        }

        if ("CALL_END".equalsIgnoreCase(
                signalDTO.getSignalType())) {

            System.out.println(
                    "Call ended for rideId: "
                            + signalDTO.getRideId()
            );
        }

        messagingTemplate.convertAndSend(
                "/topic/call/" + signalDTO.getRideId(),
                signalDTO
        );
    }
}
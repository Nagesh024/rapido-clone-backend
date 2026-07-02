package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.IncidentTimelineResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IncidentTimelineService {

    public IncidentTimelineResponse getTimeline() {

        IncidentTimelineResponse response =
                new IncidentTimelineResponse();

        response.setIncidentId("INC-20260702-001");

        response.setTimeline(Arrays.asList(
                "10:00 - Alert Created",
                "10:01 - Incident Opened",
                "10:03 - Engineer Assigned",
                "10:08 - Mitigation Started",
                "10:15 - Recovery Completed",
                "10:18 - Incident Resolved"
        ));

        response.setAssignedEngineer("Platform SRE Team");

        response.setCurrentStatus("RESOLVED");

        return response;
    }
}
package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.PortalModuleDTO;
import com.rapido.platformengineering.entity.PortalModule;
import com.rapido.platformengineering.repository.PortalModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalService {

    private final PortalModuleRepository repository;

    public PortalService(PortalModuleRepository repository) {
        this.repository = repository;
    }

    public List<PortalModuleDTO> getModules() {

        return repository.findAll()
                .stream()
                .map(module -> new PortalModuleDTO(
                        module.getId(),
                        module.getModuleName(),
                        module.getDescription(),
                        module.getStatus()
                ))
                .toList();
    }
}
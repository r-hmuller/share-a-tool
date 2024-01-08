package dev.rodrigomuller.service;

import dev.rodrigomuller.DTO.request.ToolRequestDTO;
import dev.rodrigomuller.DTO.response.ToolResponseDTO;
import dev.rodrigomuller.entity.Tool;
import dev.rodrigomuller.mapper.ToolMapper;
import dev.rodrigomuller.repository.ToolRepository;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

import static io.smallrye.config.ConfigLogging.log;

@ApplicationScoped
public class ToolService {
    private final ToolRepository toolRepository;
    private final ToolMapper toolMapper;
    public ToolService(
            ToolRepository toolRepository,
            ToolMapper toolMapper
            ) {
        this.toolRepository = toolRepository;
        this.toolMapper = toolMapper;
    }

    public List<ToolResponseDTO> getAll() {
        List<Tool> tools = this.toolRepository.listAll();
        return this.toolMapper.toDTOList(tools);
    }

    public ToolResponseDTO get(Long id) {
        Tool tool = this.toolRepository.findByIdOptional(id)
                .orElseThrow();
        return this.toolMapper.toDTO(tool);
    }

    public ToolResponseDTO save(ToolRequestDTO toolRequestDTO) {
        Tool tool = this.toolMapper.toEntity(toolRequestDTO);
        this.toolRepository.persist(tool);
        return this.toolMapper.toDTO(tool);
    }

    public ToolResponseDTO update(Long id, ToolRequestDTO toolRequestDTO) {
        Tool updatedTool = this.toolRepository.findByIdOptional(id).orElseThrow();
        updatedTool.setName(toolRequestDTO.getName());
        updatedTool.setDescription(toolRequestDTO.getDescription());
        updatedTool.setPrice(toolRequestDTO.getPrice());
        updatedTool.setValidFrom(toolRequestDTO.getValidFrom());
        updatedTool.setValidTo(toolRequestDTO.getValidTo());
        this.toolRepository.persist(updatedTool);
        return this.toolMapper.toDTO(updatedTool);
    }

    public void delete(Long id) {
        Tool tool = this.toolRepository.findByIdOptional(id).orElseThrow();
        this.toolRepository.deleteById(tool.getId());
    }


    public List<ToolResponseDTO> getUserOffers(SecurityIdentity securityIdentity) {
        System.out.println(securityIdentity.getPrincipal().getName());
        System.out.println(securityIdentity.getPrincipal());

        return new ArrayList<>();
    }
}

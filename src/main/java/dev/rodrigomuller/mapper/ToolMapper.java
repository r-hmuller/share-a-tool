package dev.rodrigomuller.mapper;

import dev.rodrigomuller.DTO.request.ToolRequestDTO;
import dev.rodrigomuller.DTO.response.ToolResponseDTO;
import dev.rodrigomuller.entity.Tool;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "cdi")
public interface ToolMapper {
    Tool toEntity(ToolRequestDTO toolRequestDTO);
    ToolResponseDTO toDTO(Tool tool);

    List<ToolResponseDTO> toDTOList(List<Tool> tools);
}

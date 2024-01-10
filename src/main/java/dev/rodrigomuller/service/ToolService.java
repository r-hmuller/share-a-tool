package dev.rodrigomuller.service;

import dev.rodrigomuller.DTO.request.ToolRequestDTO;
import dev.rodrigomuller.DTO.response.ToolResponseDTO;
import dev.rodrigomuller.entity.Customer;
import dev.rodrigomuller.entity.Tool;
import dev.rodrigomuller.exception.CustomerNotFoundException;
import dev.rodrigomuller.mapper.ToolMapper;
import dev.rodrigomuller.repository.CustomerRepository;
import dev.rodrigomuller.repository.ToolRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class ToolService {
    private final ToolRepository toolRepository;
    private final ToolMapper toolMapper;

    private final CustomerRepository customerRepository;

    private final JsonWebToken jwt;

    private static final Logger LOG = Logger.getLogger(ToolService.class);
    public ToolService(
            ToolRepository toolRepository,
            ToolMapper toolMapper,
            CustomerRepository customerRepository,
            JsonWebToken jwt
            ) {
        this.toolRepository = toolRepository;
        this.toolMapper = toolMapper;
        this.customerRepository = customerRepository;
        this.jwt = jwt;
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

    @Transactional
    public ToolResponseDTO save(ToolRequestDTO toolRequestDTO) {
        Customer customer = this.getCustomer();
        Tool tool = this.toolMapper.toEntity(toolRequestDTO);
        tool.setOwner(customer);
        this.toolRepository.persist(tool);
        return this.toolMapper.toDTO(tool);
    }

    @Transactional
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


    public List<ToolResponseDTO> getUserOffers() {
        Customer customer = this.getCustomer();
        return this.toolMapper.toDTOList(customer.getTools().stream().toList());
    }

    private Customer getCustomer() {
        return this.customerRepository.findByKeycloakId(this.jwt.getSubject()).
                orElseThrow(CustomerNotFoundException::new);
    }
}

package dev.rodrigomuller.controller;

import dev.rodrigomuller.DTO.request.ToolRequestDTO;
import dev.rodrigomuller.DTO.response.ToolResponseDTO;
import dev.rodrigomuller.service.ToolService;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import org.jboss.resteasy.reactive.NoCache;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;


@Path("/tools")
@ApplicationScoped
public class ToolController {

    private final ToolService toolService;
    private final SecurityIdentity securityIdentity;

    ToolController(
            ToolService toolService,
            SecurityIdentity securityIdentity
            ) {
        this.toolService = toolService;
        this.securityIdentity = securityIdentity;
    }

    @GET
    @NoCache
    public List<ToolResponseDTO> getAll() {
        return this.toolService.getAll();
    }

    @GET
    @Path("/{id}")
    public ToolResponseDTO get(@RestPath("id") Long id) {
        return this.toolService.get(id);
    }

    @POST
    @RolesAllowed("user")
    public ToolResponseDTO create(@Valid ToolRequestDTO toolRequestDTO) {
        return this.toolService.save(toolRequestDTO);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("user")
    public ToolResponseDTO update(@RestPath("id") Long id, @Valid ToolRequestDTO toolRequestDTO) {
        return this.toolService.update(id, toolRequestDTO);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("user")
    public void delete(@RestPath("id") Long id) {
        this.toolService.delete(id);
    }

    @GET
    @Path("/me")
    @RolesAllowed("user")
    public List<ToolResponseDTO> getMyOffers() {
        return this.toolService.getUserOffers(this.securityIdentity);
    }
}

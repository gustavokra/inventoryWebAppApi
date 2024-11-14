package com.kraemer.presentation.controllers;

import org.jboss.resteasy.annotations.jaxrs.HeaderParam;

import com.kraemer.domain.entities.dto.UserCredentialsDTO;
import com.kraemer.domain.entities.dto.UserDTO;
import com.kraemer.domain.entities.enums.EnumDBImpl;
import com.kraemer.service.UserService;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/v1/user")
public class UserController {

    @Inject
    private UserService userService;

    @POST
    @PermitAll
    @Path("/cadaster")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserDTO userDTO, @HeaderParam EnumDBImpl dbImpl) {
        var created = userService.create(userDTO, dbImpl);

        return Response.ok(created).build();
    }

}

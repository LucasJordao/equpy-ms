package com.app.adapters.in.controllers;

import com.app.adapters.in.requests.UserRequest;
import com.app.domain.ports.in.RegisterUserUseCase;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

import java.net.URI;

import static com.app.adapters.in.mappers.UserRequestMapper.toUser;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@AllArgsConstructor
@Path("/auth/v1")
public class AuthController {

    private RegisterUserUseCase registerUseCase;

    @POST
    @Path("/register")
    @Produces(APPLICATION_JSON)
    public Response register(@Valid UserRequest request) {
        var user = registerUseCase.register(toUser(request));

        return Response.created(URI.create(user.getId().toString())).build();
    }
}

package com.example.openliberty.secure;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/protected")
@RequestScoped
public class ProtectedController {

    @Inject
    @Claim("custom-value")
    private ClaimValue<String> custom;

    @Inject JsonWebToken token;
    @GET
    @RolesAllowed("protected")
    public String getJWTBasedValue() {
        return "jc Custom value : " + custom.getValue() + "  JsonWebToken: " + token.getRawToken();
    }
}

package io.gdiazs.banking;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/api/v1")

@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@DeclareRoles({"ROLE_OWNER", "ROLE_ADMIN"})
public class AccountsRestApplication extends Application {


	
	
	
}

package io.gdiazs.banking.accounts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import io.gdiazs.banking.accounts.annotations.HandleAccountException;

@Path("/ping")
@Named
public class AccountsController {

	@Inject
	private AccountsRepository accountsDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@HandleAccountException
	public Response  get(@QueryParam("userId") String userId) throws AccountsException {
		Response response = null;
		List<Account> findAllAccountsByUserId = accountsDao.findAllAccountsByUserId(userId);
		
		if(findAllAccountsByUserId == null ||  findAllAccountsByUserId.size() == 0) {
			response = Response.status(Status.NOT_FOUND).build();
		}else {
			response = Response.ok().entity(findAllAccountsByUserId).build();
		}
		
	
		return  response;
	}
}

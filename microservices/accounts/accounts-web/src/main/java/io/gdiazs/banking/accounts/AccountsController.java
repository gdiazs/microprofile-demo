package io.gdiazs.banking.accounts;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.gdiazs.banking.accounts.annotations.HandleAccountException;

@Path("/ping")
@Named
public class AccountsController {

	@Inject
	private AccountsRepository accountsDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@HandleAccountException
	public List<Account> get(@QueryParam("userId") String userId) throws AccountsException {
		return accountsDao.findAllAccountsByUserId(userId);
	}
}

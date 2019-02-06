package io.gdiazs.banking.accounts;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;

import io.gdiazs.banking.accounts.annotations.HandleAccountException;
import io.gdiazs.banking.commons.ErrorApi;

@HandleAccountException
@Interceptor
@Priority(value = Interceptor.Priority.APPLICATION)
public class AccountsInterceptor {

	@AroundInvoke
	public Object onAccountException(InvocationContext invocationContext) {
		Object proceed = null;

		try {
			proceed = invocationContext.proceed();
		} catch (Exception e) {
			if (e instanceof AccountsException) {
				ErrorApi api = new ErrorApi("409", "1002", e.getMessage());
				proceed = Response.status(409).entity(api).build();
			}
		}

		return proceed;
	}

}

package io.gdiazs.banking.accounts;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import io.gdiazs.banking.accounts.annotations.HandleAccountException;

@HandleAccountException
@Interceptor
@Priority(value = Interceptor.Priority.APPLICATION)
public class AccountsInterceptor {

	@AroundInvoke
	public Object onAccountException(InvocationContext invocationContext)  {
		Object proceed = null;
		
		try {
			proceed = invocationContext.proceed();
		} catch (Exception e) {
			if (e instanceof HandleAccountException) {
				System.out.println(e);
			}
		}
		
		return proceed;
	}

}

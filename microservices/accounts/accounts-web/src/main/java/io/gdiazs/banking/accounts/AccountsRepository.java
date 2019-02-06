package io.gdiazs.banking.accounts;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Named
public class AccountsRepository {

	private static final String JPQL_FIND_ACCOUNTS_BY_USER_ID = "select e from Account e where e.accountId.userId = :userId";

	@PersistenceContext(unitName = "accountsPU")
	private EntityManager entityManager;

	public List<Account> findAllAccountsByUserId(String userId) throws AccountsException {
		List<Account> resultList = null;
		try {

			resultList = entityManager.createQuery(JPQL_FIND_ACCOUNTS_BY_USER_ID, Account.class)
					.setParameter("userId", userId).getResultList();				

		} catch (PersistenceException ex) {
			throw new AccountsException("Error al consultar las cuentas del usuario: " + userId, ex.getCause());
		}

		return resultList;
	}
}

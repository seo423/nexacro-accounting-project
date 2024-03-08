package kr.co.seoulit.erp.account.sys.common.transaction;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Configuration
@Aspect
@Slf4j
public class TransactionAspect {
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Around("execution(* kr.co.seoulit.erp.account..service.*Impl.*(..)) ")
	public Object transaction(ProceedingJoinPoint joinPoint) throws Throwable {
		TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionAttribute());
		Object object = null;
		try {
			object = joinPoint.proceed();
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
		}
		return object;
	}
}
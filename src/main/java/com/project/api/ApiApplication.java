package com.project.api;


import com.project.api.model.Account;
import com.project.api.repository.AccountDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;


@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ApiApplication {

	public static AccountDataAccessService accountDAO;

	@Autowired
	public ApiApplication(@Qualifier("postgres") AccountDataAccessService accountDAO) {
		this.accountDAO = accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("HOLAAAAAAAAAAAAAAAAAAAAA");
		//Account account = Account.createNew("eaa40c0a-d02e-4f99-a2da-4508a2f08c00","carlitos", "carlitosemail", "pass");
		//System.out.println(accountDAO.save(account));
		accountDAO.findById(UUID.fromString("167194ae-bb37-4ebe-b9fc-f101de580305")).ifPresent(user -> {
			System.out.println(user.getUsername());
		});
		List<Account> users = accountDAO.findAll();
		for (Account user : users){
			System.out.println(user.getId());
			System.out.println(user.getUsername());
		}

	}

}

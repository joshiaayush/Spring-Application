package com.codekul.java21febspring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JavaMailSender mailSender;

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @PostMapping("saveUser")
    public String saveUser(@RequestBody Users users) {
        Users users1 = usersRepository.save(users);
//        https://myaccount.google.com/u/0/apppasswords
        return users1.getUserName();
    }

    @GetMapping("getLogger")
    public String getLogger() {
        logger.info("Logger info");
        logger.error("Logger Error");
        logger.warn("Logger Warning");
        logger.trace("Logger Trace");
        return "logger";
    }


    @PostMapping("login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        String userNm = usersRepository.getLoginUser(loginRequestDto.getUserName(), loginRequestDto.getPassword());
        if (userNm != null) {
            return "login successfully..";
        } else {
            return "login failed";
        }
    }


}
/*
select * from fn_login('ak123','12345')
CREATE OR REPLACE FUNCTION public.fn_login(
	userName character varying,
	pass character varying)
    RETURNS TABLE(_name character varying)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$

begin
	return query
		select name from users where user_name=userName and password = pass;
    end;
$BODY$;
 */
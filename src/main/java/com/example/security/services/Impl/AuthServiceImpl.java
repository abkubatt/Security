package com.example.security.services.Impl;

import com.example.security.configurations.EmailSender;
import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.RoleDto;
import com.example.security.models.dtos.UserCodeDto;
import com.example.security.models.dtos.UserDto;
import com.example.security.models.entities.UserCode;
import com.example.security.models.request.SignInRequest;
import com.example.security.models.response.Message;
import com.example.security.services.AccountService;
import com.example.security.services.AuthService;
import com.example.security.services.RoleService;
import com.example.security.services.UserService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmailSender emailSender;



    @Override
    public ResponseEntity<?> signIn(SignInRequest signInRequest) {
        AccountDto accountDto = accountService.findByEmail(signInRequest.getEmail());
        System.out.println("check");
        if (accountDto != null){
            System.out.println("test");
            return new ResponseEntity<>(Message.of("User with this account already registered"), HttpStatus.NOT_ACCEPTABLE);
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<SignInRequest>> constraintViolations = validator.validate(signInRequest);

        if (constraintViolations.size()>0){
            Set<String> violationMessage  = new HashSet<String>();

            for (ConstraintViolation<SignInRequest> constraintViolation : constraintViolations){
                violationMessage.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
            }

            return new ResponseEntity<>(Message.of("Wrong dates:\n" + StringUtils.join(violationMessage, '\n')), HttpStatus.NOT_ACCEPTABLE);
        }

        try {
            RoleDto role = RoleDto.builder().role(signInRequest.getRole()).build();
            role = roleService.save(role);

            UserDto userDto = userService.save(UserDto.builder()
                    .email(signInRequest.getEmail())
                    .name(signInRequest.getName())
                    .phone(signInRequest.getPhone())
                    .role(role)
                    .confirm(false)
                    .build());

            accountService.save(AccountDto.builder()
                    .login(signInRequest.getEmail())
                    .password(signInRequest.getPassword())
                    .user(userDto)
                    .build());
            System.out.println("OK");
            ResponseEntity<?> codeSendResponse = sendCode(signInRequest.getEmail());

            if (!codeSendResponse.getStatusCode().equals(HttpStatus.OK)) return codeSendResponse;

            UserCodeDto userCodeDto = UserCodeDto.builder()
                    .user(userDto)
                    .code(codeSendResponse.getBody().toString())
                    .sendDate(new Date())
                    .confirm(false)
                    .build();

            return new ResponseEntity<>(Message.of("Code have send to podverjdat to your email"),HttpStatus.OK);
            //вызвать метод sendCode, он вернет код, который был сгенерирован и отправлен на почту
            //Надо сохранить этот код в нашей базе. Для этого создаем новый объект UserCode
            // заполняем его поля
            /// return new ResponseEntity<>(Message.of("You successfully registered to system"), HttpStatus.OK);

        }
        catch (Exception ex){
            return new ResponseEntity<>(Message.of(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<?> logIn(String login, String password) {
        AccountDto accountDto = accountService.findByEmail(login);
        if (accountDto == null){
            return new ResponseEntity<>(Message.of("Login is wrong"),HttpStatus.NOT_ACCEPTABLE);
        }else if (!accountDto.getPassword().equals(password)){
            return new ResponseEntity<>(Message.of("Password is not correct"),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(Message.of("Welcome to system"), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> sendCode(String email) {
        String randCode = (int)(Math.random()*10000) + "";
        //String code = confirmCodeGenerator.generatePassword(4);

        //generate random code - рандомно сгеренрировать 4-х значное число
        try {
            emailSender.sendSimpleMessage(email, "Код подтверждения", "Ваш код подтверждения: " + randCode);
        }catch (Exception ex){
            return new ResponseEntity<>(Message.of("Error while sending message"), HttpStatus.NOT_IMPLEMENTED);
            // вернуть ответ с ошибкой, что произошла ошибка в процессе отправки кода
        }
        //return code;
        return new ResponseEntity<>(randCode, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> confirmation(String email, String code) {
        AccountDto accountDto = accountService.findByEmail(email);

        // найти User по email
        // найти UserCode по User
        // сравнить код из UserCode с code
        // если совпадают подтверждаем и в UserCode апдейтим поле confirm = true
        // если нет, возвращаем ответ, что введен неверный код
        return null;
    }

}

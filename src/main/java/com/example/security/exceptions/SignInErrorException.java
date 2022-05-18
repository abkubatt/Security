package com.example.security.exceptions;

public class SignInErrorException extends RuntimeException{

     public SignInErrorException(String message){
         super(message);
     }
}

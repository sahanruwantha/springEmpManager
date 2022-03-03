package com.sahan.springempmanager.exeption;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(String message)
    {
        super(message);
    }
}

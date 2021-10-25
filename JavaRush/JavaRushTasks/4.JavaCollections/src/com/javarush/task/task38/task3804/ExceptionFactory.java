package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static <T extends Enum<T>> Throwable throwException(Enum<T> e) {
        if (e instanceof ApplicationExceptionMessage) {
            if (e.equals(ApplicationExceptionMessage.UNHANDLED_EXCEPTION))
                return new Exception("Unhandled exception");
            else if (e.equals(ApplicationExceptionMessage.SOCKET_IS_CLOSED))
                return new Exception("Socket is closed");
        } else if (e instanceof DatabaseExceptionMessage) {
            if (e.equals(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT))
                return new RuntimeException("No result due to timeout");
            else if (e.equals(DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS))
                return new RuntimeException("Not enough connections");
        } else if (e instanceof UserExceptionMessage) {
            if (e.equals(UserExceptionMessage.USER_DOES_NOT_EXIST))
                return new Error("User does not exist");
            else if (e.equals(UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS))
                return new Error("User does not have permissions");
        } else
            return new IllegalArgumentException();
        return null;
    }

}

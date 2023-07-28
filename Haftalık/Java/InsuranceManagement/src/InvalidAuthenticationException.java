public class InvalidAuthenticationException extends Throwable {

        public InvalidAuthenticationException(String msg){
            super(msg);
            System.out.println("Invalid password !");
        }
    }


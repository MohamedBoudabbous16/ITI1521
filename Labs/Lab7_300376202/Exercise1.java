import java.io.IOException;

public class Exercise1 {

    public static void throwException(int exceptionNumber) throws Exception{
        if(exceptionNumber==1){
            throw new Exception();
        }
        if(exceptionNumber==2){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(exceptionNumber==3){
            throw new IOException();
        }
        if(exceptionNumber==4){
            throw new IllegalArgumentException();
        }
        if(exceptionNumber==5){
            throw new NullPointerException();
        }
    }

    /*
        Returns the name of the exception thrown by the method throwException.
        Method that handles the exceptions thrown by the throwException method.
        
        @param exceptionNumber
        @return The exception name or "NoException" if no exception was caught.
     */
    public static String catchException(int exceptionNumber) {
        String exceptionName = "NoException";

        try {
            throwException(exceptionNumber);
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionName = "ArrayIndexOutOfBoundsException";
            System.out.println("The exception type is: " + exceptionName + ", the exceptionNumber is: " + exceptionNumber);
        } catch (IOException e) {
            exceptionName = "IOException";
            System.out.println("The exception type is: " + exceptionName + ", the exceptionNumber is: " + exceptionNumber);
        } catch (IllegalArgumentException e) {
            exceptionName = "IllegalArgumentException";
            System.out.println("The exception type is: " + exceptionName + ", the exceptionNumber is: " + exceptionNumber);
        } catch (NullPointerException e) {
            exceptionName = "NullPointerException";
            System.out.println("The exception type is: " + exceptionName + ", the exceptionNumber is: " + exceptionNumber);
        } catch (Exception e) {
            exceptionName = "Exception";
            System.out.println("The exception type is: " + exceptionName + ", the exceptionNumber is: " + exceptionNumber);
        }
        return exceptionName;
    }

    public static void main(String[] args) {
        int exceptionNumber=(int)(Math.random()*5) + 1;
        String exceptionName = catchException(exceptionNumber);
        System.out.println("Exception number: " + exceptionNumber);
        System.out.println("Exception name: " + exceptionName);
    }

}
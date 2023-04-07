package LibarariOperation;

public class MyDrive {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Load class");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
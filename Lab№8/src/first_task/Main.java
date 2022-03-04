package first_task;

public class Main {
    public static void main(String[] args) {
        var connection = new InternetConnection();
        connection.getLocalHost();
        connection.getByName("www.belstu.by");
        byte[] ip = {(byte)127, (byte)0, (byte)0, (byte)7};
        connection.getByAddress("Unknown", ip);
        connection.readHTML("https://www.sputnik.by");
        connection.getInfo("https://www.onliner.by");
    }
}

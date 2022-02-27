package date;

public class Instant {
    
    public static void main(String[] args){

        System.out.println(java.time.Instant.ofEpochSecond(System.currentTimeMillis()/1000).toString());

        Long now1 = System.currentTimeMillis()/1000;
        String startTime = java.time.Instant.ofEpochSecond(now1).toString();
        System.out.println(startTime);

        startTime = java.time.Instant.ofEpochSecond(now1+=3600).toString();
        System.out.println(startTime);
    }
}

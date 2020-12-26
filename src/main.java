import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class main {
    public static void main(String[] args) {
        Worker w1 =  new Worker(1337, "Oleg", new BigDecimal("90000.00"),getDate("01.02.2061"));
        Worker w2 =  new Worker(1338, "Dima", new BigDecimal("80000.00"),getDate("09.11.2061"));

        ConcurrentMap<Worker,String> empMap = new ConcurrentHashMap<>();
        empMap.put(w1, "IT");
        empMap.put(w2, "IT");


        Set<Entry<Worker, String>> entrySet = empMap.entrySet();

        for (Entry<Worker, String> entry : entrySet) {
            Worker worker = entry.getKey();
            String dept = entry.getValue();
            System.out.println(worker);
            System.out.println(dept);
        }
        System.out.println("--------------------------------------");
        w2.getDob().setTime(8988878787L);
        System.out.println(w2);
        System.out.println(empMap.get(w2));

    }

    private static Date getDate(String dob){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return dateFormat.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}

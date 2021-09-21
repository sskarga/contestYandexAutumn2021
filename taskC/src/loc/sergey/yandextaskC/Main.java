package loc.sergey.yandextaskC;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {
        // write your code here
        final String fileName = "input_1.txt";
        String filterType = "ERROR";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String result = "-1";

        Queue<Long> queueError;

        long time;

        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line = bufferedReader.readLine();

            final long peroidError = Long.parseLong(line.split(" ")[0]) * 1000;
            final long countError = Long.parseLong(line.split(" ")[1]);

            queueError = new LinkedList<Long>();

            while ((line = bufferedReader.readLine()) != null) {
                time = getTime(line, filterType);
                if (time > 0) {
                    queueError.offer(time);
                    final long diffTime = time - queueError.peek();
                    if (peroidError <= diffTime) {
                        queueError.poll();
                    }
                    ;

                    if (queueError.size() >= countError) {
                        result = simpleDateFormat.format(time);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static long getTime(String msg, String filterType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

        String msgType = msg.split(" ")[2];
        if (msgType.equals(filterType)) {
            String msgTime = msg.substring(1, msg.indexOf("]"));
            try {
                return simpleDateFormat.parse(msgTime).getTime();
            } catch (ParseException e) {
                return 0;
            }
        }
        return 0;
    }
}

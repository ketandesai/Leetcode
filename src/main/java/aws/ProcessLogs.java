import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ProcessLogs {

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        List<String> result = new ArrayList<>();
        TreeMap<Long, Integer> map = new TreeMap<>();

        for (String log: logs){
            String[] arr = log.split(" ");
            long sender_user_id = Long.parseLong(arr[0]);
            long rec_user_id = Long.parseLong(arr[1]);

            if (sender_user_id == rec_user_id){
                map.put(sender_user_id, map.getOrDefault(sender_user_id, 0) + 1);
            } else {
                map.put(sender_user_id, map.getOrDefault(sender_user_id, 0) + 1);
                map.put(rec_user_id, map.getOrDefault(rec_user_id, 0) + 1);
            }
        }

        for (Long key: map.keySet()){
            if (map.get(key) >= threshold){
                result.add(String.valueOf(key));
            }
        }

        return result;

    }
}
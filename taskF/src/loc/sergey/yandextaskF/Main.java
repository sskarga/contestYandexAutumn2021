package loc.sergey.yandextaskF;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        long countCmd = 0;  // Counter command

        String[] inputValue = new String[2]; // Data from string line
        String requestKey;  // Parse key_id from string line
        long requestValue;  // Parse time_id request from string line

        long countRequest = 0;  // Max count read line with request in file
        long maxSizeCache = 0;  // Max size cache

        Queue<String> cacheQueue = new LinkedList<>();
        Map<String, Long> cacheMap = new HashMap<>();  // Contents kei_id request in cacheQueue
        Map<String, Long> cacheAllMap = new HashMap<>();  // Contents kei_id all request

        try (Scanner scanner = new Scanner(new File("input_2.txt"))) {
            inputValue = scanner.nextLine().split(" ");
            countRequest = Long.parseLong(inputValue[0]);
            maxSizeCache = Long.parseLong(inputValue[1]);

            while (scanner.hasNextLine()) {
                countCmd++;
                if (countCmd > countRequest) break;

                inputValue = scanner.nextLine().split(" ");
                requestKey = inputValue[0];
                requestValue = Long.parseLong(inputValue[1]);

                if (cacheMap.containsKey(requestKey)) {
                    // Update cache only new data request
                    if (requestValue > cacheMap.get(requestKey)) {
                        cacheMap.replace(requestKey, requestValue);
                        cacheAllMap.replace(requestKey, requestValue);
                        System.out.printf("%d %s %s%n", countCmd, "UPDATE", requestKey);
                    }

                } else {
                    // Filter orders request
                    if (
                            cacheAllMap.isEmpty()
                                    || !cacheAllMap.containsKey(requestKey)
                                    || (cacheAllMap.containsKey(requestKey) && requestValue > cacheAllMap.get(requestKey))
                    ) {
                        // Clear cache
                        if (cacheQueue.size() >= maxSizeCache) {
                            final String removeKey = cacheQueue.poll();
                            cacheMap.remove(removeKey);
                            System.out.printf("%d %s %s%n", countCmd, "DELETE", removeKey);
                        }

                        // Add new data to cache
                        cacheQueue.offer(requestKey);
                        cacheMap.put(requestKey, requestValue);
                        cacheAllMap.put(requestKey, requestValue);
                        System.out.printf("%d %s %s%n", countCmd, "PUT", requestKey);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Exception occurred!");
        }

    }

}


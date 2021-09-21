package loc.sergey.yandextaskA;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");

        try {
            FileReader reader = new FileReader("input_3.json");

            JSONParser jsonParser = new JSONParser();

            JSONArray arrOrders= (JSONArray) jsonParser.parse(reader);
            HashMap<Long, Order> orderMap = parseOrderObject(arrOrders);

            JSONArray outObject = getJsonArray(orderMap);
            saveJsonToFile(outObject);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private static JSONArray getJsonArray(HashMap<Long, Order> orderHashMap) {
        JSONArray outObject = new JSONArray();
        for(Map.Entry<Long, Order> entry: orderHashMap.entrySet()) {
            final long key = entry.getKey();
            final Order value = entry.getValue();

            final Set<Product> products = value.getProducts();
            if (products.size() == 0) break;

            final JSONObject order = new JSONObject();
            final JSONArray items = new JSONArray();

            for(Product p: products) {
                if(!p.isShipment() || p.getCount() < 1) break;
                final JSONObject product = new JSONObject();
                product.put("id", p.getId());
                product.put("count", p.getCount());
                items.add(product);
            }

            if (items.size() < 1) continue;

            order.put("id", key);
            order.put("items", items);
            outObject.add(order);
        }
        return outObject;
    }


    private static void saveJsonToFile(JSONArray outObject) {
        try (FileWriter file = new FileWriter("out.json")) {
            file.write(outObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<Long, Order> parseOrderObject(JSONArray arrOrders) {
        HashMap<Long, Order> orderHashMap = new HashMap<Long, Order>();

        Iterator<JSONObject> iterator = arrOrders.iterator();

        while (iterator.hasNext()) {
            final JSONObject jsonOrder = iterator.next();

            final long orderId = (long) jsonOrder.get("order_id");
            final Product product = parseProductObject(jsonOrder);
            Order order;

            if (orderHashMap.containsKey(orderId)) {
                // Update
                Set<Product> products = orderHashMap.get(orderId).getProducts();
                for(Product p: products) {
                    if(product.getEvenId() > p.getEvenId()) {
                        products.remove(p);
                        products.add(product);
                        break;
                    }
                }
            } else {
                // New
                order = new Order(orderId);
                order.getProducts().add(product);
                orderHashMap.put(orderId, order);
            }

        }

        return orderHashMap;
    }

    private static Product parseProductObject(JSONObject product) {
        long id = (long) product.get("item_id");
        long count = (long) product.get("count") - (long) product.get("return_count");
        long evenId = (long) product.get("event_id");
        boolean shipment = product.get("status").toString().equals("OK");

        return new Product(id, count, evenId, shipment);
    }

}

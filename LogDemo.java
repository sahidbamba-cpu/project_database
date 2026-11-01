import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LogDemo {

    @SuppressWarnings("unchecked")
    static Map<String, Object> asMap(Object o) {
        return (Map<String, Object>) o;
    }

    @SuppressWarnings("unchecked")
    static List<Object> asList(Object o) {
        return (List<Object>) o;
    }

    // TODO (README 5.2): uniqueIps
    static Set<String> uniqueIps(List<Object> authEvents) {
        throw new UnsupportedOperationException("uniqueIps is not implemented yet");
    }

    // TODO (README 5.3): failedLoginsPerUser
    static Map<String, Integer> failedLoginsPerUser(List<Object> authEvents) {
        throw new UnsupportedOperationException("failedLoginsPerUser is not implemented yet");
    }

    // TODO (README 5.4): eventsByUser
    static Map<String, List<Object>> eventsByUser(List<Object> authEvents) {
        throw new UnsupportedOperationException("eventsByUser is not implemented yet");
    }

    // PROVIDED (README 5.5): a finished example, do not change
    static List<Object> flowsTouchingBlocklist(List<Object> flows, List<Object> blocklist) {
        Set<Object> blocked = new HashSet<>(blocklist);
        List<Object> hits = new ArrayList<>();
        for (Object f : flows) {
            Map<String, Object> flow = asMap(f);
            if (blocked.contains(flow.get("src")) || blocked.contains(flow.get("dst"))) {
                hits.add(f);
            }
        }
        return hits;
    }

    public static void main(String[] args) {
        Map<String, Object> root = asMap(JsonParser.parseFile("data/logs.json"));
        List<Object> auth = asList(root.get("auth_events"));
        List<Object> flows = asList(root.get("network_flows"));
        List<Object> blocklist = asList(root.get("blocklist"));

        System.out.println("Auth events: " + auth.size());
        System.out.println("Unique source IPs: " + uniqueIps(auth).size() + " " + uniqueIps(auth));
        System.out.println("Failed logins per user: " + failedLoginsPerUser(auth));
        System.out.println("Users with events: " + eventsByUser(auth).keySet());
        System.out.println("Flows touching the blocklist: " + flowsTouchingBlocklist(flows, blocklist).size());
    }
}
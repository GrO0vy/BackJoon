import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];

        HashMap<String, HashSet<String>> logs = new HashMap<>();
        HashMap<String, Integer> reportedCount = new HashMap<>();

        for (String id : id_list) {
            logs.put(id, new HashSet<>());
            reportedCount.put(id, 0);
        }

        for (String users : report) {
            StringTokenizer st = new StringTokenizer(users);
            String reporter = st.nextToken();
            String reportee = st.nextToken();
            logs.get(reporter).add(reportee);
        }

        for (String reporter : logs.keySet()) {
            HashSet<String> reportees = logs.get(reporter);
            for (String reportee : reportees) {
                reportedCount.put(reportee, reportedCount.get(reportee) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            for (String reportee : logs.get(id)) {
                if (reportedCount.get(reportee) >= k) answer[i]++;
            }
        }

        return answer;
    }
}
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoOfGroups {
    public static int countGroups(List<String> related) {
    // Write your code here
        if (related == null || related.isEmpty()) return 0;

        int[][] isConnected = new int[related.size()][related.size()];

        for (int i = 0; i < related.size(); i++){
            String row = related.get(i);
            for (int j = 0; j < row.length(); j++){
                isConnected[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
            }
        }

        int n = isConnected.length;
        int groups[] = new int[n];

        for (int i = 0; i < n; i++){
            groups[i] = i;
        }

        for (int i = 0; i < n -1; i++){
            for (int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j, groups);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < groups.length; i++){
            set.add(find(i, groups));
        }
        return set.size();

    }

    private static void union(int edge1, int edge2, int [] groups){
        int parent1 = find(edge1, groups);
        int parent2 = find(edge2, groups);
        groups[parent1] = parent2;
    }

    private static int find(int edge, int[] groups){
        if (groups[edge] != edge){
            groups[edge] = find(groups[edge], groups);
        }
        return groups[edge];
    }
}

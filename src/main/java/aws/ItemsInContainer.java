public class ItemsInContainer {

    
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        int [] dp = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '|'){
                dp[i] = count;   
            } else {
                count++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < startIndices.size(); i++){
            int start = startIndices.get(i)-1;
            int end = endIndices.get(i)-1;
            
            while (s.charAt(start) != '|') start++;
            while (s.charAt(end) != '|') end--;
            
            if (start < end){
                result.add(dp[end] -dp[start]);
            } else {
                result.add(0);
            }
        }
        
        return result;
        
            
    }

    public static List<Integer> numberOfItemsTreeMap(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        
        //store the count of *, when a | is found
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '|'){
                map.put(i, count);
            } else {
                count++;
            }
        }
        
        for (int i = 0; i < startIndices.size(); i++){
            //subtract 1, to make indexes 0 based
            int startIndex = startIndices.get(i) - 1;
            int endIndex = endIndices.get(i) - 1;
            
            //returns a value of a | index, or the next possible |
            Map.Entry<Integer, Integer> start = map.ceilingEntry(startIndex);
            
            //return a value of a | entry, or the previous possible |
            Map.Entry<Integer, Integer> end = map.floorEntry(endIndex);
            
            if (start != null && end != null){
                int ans = Math.max(0, end.getValue() - start.getValue());
                result.add(ans);
            }
        }
        
        return result;



}
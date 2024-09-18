class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] res = new String[n];
        int p = n-1;

        List<String> letterLogs = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = n-1; i >= 0; i--){
            String log = logs[i];
            String[] logStr = split(log);
            
            String id = logStr[0];
            String content = logStr[1];
            
            char isDig = content.charAt(0);
            if('0' <= isDig && isDig <= '9'){
                res[p--] = log;
                continue;
            }
            
            if(!letterLogs.contains(content))
                letterLogs.add(content);
            List<String> ids = map.getOrDefault(content, new ArrayList<>());
            ids.add(id);
            map.put(content, ids);
        }
        
        Collections.sort(letterLogs);
        p = 0;
        for(String letterLog: letterLogs){
            List<String> ids = map.get(letterLog);
            Collections.sort(ids);
            for(String id: ids)
                res[p++] = id + " " + letterLog;
        }
        
        return res;
    }
    
    public String[] split(String s){
        String[] words = s.split(" ");
        
        String[] res = new String[2];
        res[0] = words[0];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < words.length; i++){
            sb.append(words[i]);
            if(i < words.length-1)
                sb.append(" ");
        }
        res[1] = sb.toString();
        return res;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedHashMap<String,Integer> mp=new LinkedHashMap<>();
        ArrayList<String> lst=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        for (Map.Entry<String, Integer> map : mp.entrySet()) {
            lst.add(map.getKey());
        }
        Collections.sort(lst, (a, b) -> {

            if (mp.get(a) != mp.get(b)) {
                return mp.get(b) - mp.get(a);
            }

            return a.compareTo(b);
        });
        return lst.subList(0, k);

    }
}
class Solution {
    public String frequencySort(String s) {

        // hashmap count frequency

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){

            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        // as frequenfcy chiye highest ordermap random order we cant apply directly sorting on the map first we convert it into list 

        // map ko list mein convert krvate 
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());

        // nowconverted into list so now descending order 

        list.sort((a,b) ->Integer.compare(b.getValue() , a.getValue()) );

        // after arranging into descending ordr 

        StringBuilder ans = new StringBuilder();
        //listkin puri value or pair ko uthana mereko

        for(Map.Entry<Character,Integer> entry : list){
           char ch = entry.getKey();

           int freq = entry.getValue();


           while (freq > 0){
            ans.append(ch);
            freq--;
           }
        }
        return ans.toString();


        
    }
}


// on my understanding i will divide it into character and tsored it into a rray iterate over evry character use a map if the character is not present store the chractr and increase count =1 else sort map key in the descending order oans store character uske acc return string 
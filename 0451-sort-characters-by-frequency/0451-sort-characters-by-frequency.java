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

 // time complexity will be hashmap o(n) + stringbuilder O(n)+ sorting 0(k logk)

// on my understanding i will divide it into character and tsored it into a rray iterate over evry character use a map if the character is not present store the chractr and increase count =1 else sort map key in the descending order oans store character uske acc return string 



// OPTIMAL SOLUTION IS TO AVOID SORTING THAT TAKES OKLOGK TIME K FOR DISTINCT CHARACTERS 

// APPROACH 
// USE HASHMAP COUNT FREQUENCY 

// SECOND WE KNOW THAT FREQUENCY OF CHARACTER IS NOT MORE THAN THE STRING LENGTH (IDEA OF BUCKET SORT COME SO INSTEAD ODF SOTING THE MAP WE KNOW THE RAMGE SO WE SUE BUCKET SORT)
// MAP.GETVALUE STORED INTO VARIABLE CALLED FREQ 
//INITIALLY BYCKET NULL 
// IF BUCKET NULL U CREATE A LIST AND ADD CHARCATWR ELSE SIMPLE ADD CH 

// FREQ DECENDING ORDER FREQUENCY= INDEX SO START FROM LAST IF IT IS NOT NULL THEN AS TIMES AS INDEX UTNI FREQ JO WE USE INNER LOOP J ALSO 

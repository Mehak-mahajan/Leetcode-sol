class Solution {
    public int[][] merge(int[][] intervals) {

        // sorting + list 
        // 2d array mein we sort comparator use krte 

        Arrays.sort(intervals , (a,b) ->Integer.compare(a[0],b[0]));

        List<int[]> ans = new ArrayList<>() ;

        
        int  currstart = intervals[0][0];
        int  currend  = intervals[0][1];



        for(int i = 1 ; i < intervals.length ; i++){
           
           // core idea as we already sort it so we store it in the ans and compare wd the last merged ans
           // last merged interval ka index 

           int nextstart = intervals[i][0];
           int nextend = intervals[i][1];

          

           if(nextstart <= currend){ // overlap
            // hum koi nyi chij add nhi krte hum uski ko update krdete 
            currend = Math.max(currend , nextend);

           

            
              // yn to cuur end yn jo ans mein store hai uska end 
           }
        else{
        ans.add(new int[]{currstart , currend});

        currstart = nextstart;
        currend = nextend;

        }
        }
        ans.add(new int[]{currstart , currend});

        // last we have to separetely put the value because the last value compare krne konhihai ksii ke sth

        return ans.toArray(new int[ans.size()][]);
        
    }
}

/// as n = 10^4 n2 = 10^8 tle 
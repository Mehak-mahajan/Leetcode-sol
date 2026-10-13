import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;


class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {


        int n = profits.length; // as each profit correspond to 1 project so total no of projects
         int[][] projects = new int[n][2];

         // Sort projects by capital required (ascending)
      

         PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());


        // each project consit of capital and profit 

       

        // lets fill in each project their respective values

        for(int i = 0 ; i < n ; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

          Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));


        int i = 0 ;

        // total chahe jitne mrgi projects ho humne atmost k projects pr kam krna 

        for(int j = 0 ; j < k ; j++){
            // mein ek project pr tbhi kam krskti hu when i have required capital

            while(i < n && projects[i][0] <=w){
                // if my projects ca[ital is less tahn or equals to myy total capital that means project is affordable ]

                // we just keep adding its value or profit 

                maxHeap.offer(projects[i][1]);
                i++;

            }
            // agr hmre next project ko capital jiyada required hai hmre pass utni capital nhi hai that means that is not affordable then i take some prfit value from heap 

            if(maxHeap.isEmpty()){
                // yes that means no project affordable
                break;

            }

            w += maxHeap.poll();
        }
        return w;


        
    }
}

// goal is atmost k projects se we want max profit 

// but to owrk on project we ned the capital if we have the required capital then only we can work on that project 

// but what if the both prject project required same capital then which one i choose i will choose qwd max profit only when both that projects come under same affordability then only i choose the project wd max profit 


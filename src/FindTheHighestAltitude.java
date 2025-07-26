public class FindTheHighestAltitude {
//    1732. Find the Highest Altitude
//    https://leetcode.com/problems/find-the-highest-altitude/description/
//    Adobe, Apple
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};

        int ans = largestAltitude(gain);

        System.out.println(ans);



    }

    public static int largestAltitude(int[] gain){
//        length of gain
        int n = gain.length;

//        initialise starting & max altitude to 0
        int startAltitude = 0;
        int maxAltitude = 0;

//        iterate gain altitudes
        for(int i = 0; i < n; i++){
//            add all the elements to array (Prefix Sum)
            startAltitude += gain[i];

//            compare max altitude
            maxAltitude = Math.max(maxAltitude, startAltitude);
        }

//        return max altitude
        return maxAltitude;
    }
}

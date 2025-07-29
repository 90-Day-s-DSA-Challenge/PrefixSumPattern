import java.util.Arrays;

public class CorpFlightBooking {
//    1109. Corporate Flight Bookings
//    https://leetcode.com/problems/corporate-flight-bookings/description/

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10},{2, 3, 20},{2, 5, 25}};
        int n = 5;

        int[] result = corpFlightBookings2(bookings, n);

        System.out.println(Arrays.toString(result));

    }

    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] totalSeats = new int[n];

//        System.out.println(Arrays.toString(totalSeats));


//        prefix difference
        for(int[] booking: bookings){
//            {1, 2, 10} => [10,   0, -10, 0, 0]
//            {2, 3, 20} => [10,  20, -10, -20, 0]
//            {2, 5, 25} => [10,  45, -10, -20, 0]

            int first = booking[0] -1; // shift index to 1 to 0
            int last = booking[1] -1; // shift index to 2 to 1
            int seats = booking[2];

            totalSeats[first] += seats; // Add seats starting from 'first'

            if(last + 1 < n){
                totalSeats[last+1] -= seats; // Subtract seats after 'last'
            }
            System.out.println("iterations start");
            System.out.println(Arrays.toString(totalSeats));
            System.out.println("iterations end");


        }

//        System.out.println(Arrays.toString(totalSeats));

        //   take prefix sum
        for(int i = 1; i < n; i++){
            totalSeats[i] += totalSeats[i-1];
        }

        return totalSeats;

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int rows = bookings.length;
        int cols = bookings[0].length;

        System.out.println(rows);
        System.out.println(cols);

        // reserved
        int[][] reserved = new int[3][n];

        System.out.println("initialise");
        for(int[] resv: reserved){
            System.out.println(Arrays.toString(resv));
        }

        for(int[] resv: reserved){
            System.out.println(Arrays.toString(resv));
        }

        // iterate to fill reserved
        for(int i = 0; i < rows; i++){
            for(int j = bookings[i][0]; j <= bookings[i].length-2; j++){
                reserved[i][j] = bookings[i][2];
            }
        }

        System.out.println("filled");
        for(int[] resv: reserved){
            System.out.println(Arrays.toString(resv));
        }

        // total seats
        int[] totalSeats = new int[n];

        for(int i = 0; i < reserved.length; i++){
            for(int j=0; j < n; j++){
                totalSeats[i] += reserved[i][j];
            }
        }

        return totalSeats;
    }
}

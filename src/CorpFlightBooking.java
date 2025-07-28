import java.util.Arrays;

public class CorpFlightBooking {
//    1109. Corporate Flight Bookings
//    https://leetcode.com/problems/corporate-flight-bookings/description/

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10},{
            2, 3, 20
        },{
            2, 5, 25
        }};
        int n = 5;

        int[] result = corpFlightBookings(bookings, n);

        System.out.println(Arrays.toString(result));

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

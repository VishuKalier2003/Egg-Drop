/* You are given k identical eggs and you have access to a building with n floors labeled from 1 to n...You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break... Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n)... If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves... Return the minimum number of moves that you need to determine with certainty what the value of f is...
 * Eg 1: k = 1    n = 2    Output = 2
 * Eg 2: k = 2    n = 6    Output = 3
 * Eg 3: k = 4    n = 14   Output = 4
 */
import java.util.*;
public class EggDrop
{
    public int MinimumMovesToFindFloor(int floor, int eggs)
    {
        double f = Math.random() * (floor);
        int building[] = new int[floor];
        int fr = (int)(f);    // Evaluating a random floor...
        System.out.println("Floor value : "+fr);
        for(int j = fr; j < building.length; j++)
            building[j] = -1;
        int i = 0, last = floor, moves = 0;
        while(i != -1)    // The Array is pre-sorted data...
        {
            int mid = (int)((i+last)/2);    // Finding the middle index...
            if(building[mid] == -1)
            {
                System.out.println("Egg Broke !!");
                last = mid;    // Update upper boundary...
                moves++;
            }
            else
            {
                System.out.println("Egg Safe !!");
                i = mid;     // Update lower boundary...
                moves++;
            }
            if(i == fr - 1)   // If the threshold floor is found...
            {
                System.out.println("The Threshold floor is : "+fr);
                i = -1;
            }
        }
        return moves;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int k, n;
        System.out.print("Enter the number of Eggs provided : ");
        k = sc.nextInt();
        System.out.print("Enter the number of floors in the building : ");
        n = sc.nextInt();
        EggDrop eggdrop = new EggDrop();    // object creation...
        System.out.println("Minimum Moves Required : "+eggdrop.MinimumMovesToFindFloor(n, k));
        sc.close();
    }
}

// Time Complexity  - O(log n) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS :- 
 * 1. A Binary Search would solve the purpose...
 * 2. Since we need to find the threshold floor, so we can assume that the threshold floor is the sorting line, and since the array is sorted we can use the Binary Search on it...
 */
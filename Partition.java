import java.util.Random;
import java.util.*;

public class Partition{
  /*Choose a random pivot element between the start and end index inclusive,
 Then modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
private static Random rand = new Random();


public static int partition ( int[] data, int start, int end){

    int pivot = Math.abs(rand.nextInt() % data.length ) ; //making seed from that randgen

    start++;
    int temp = data[start-1];
    data[start-1]=data[pivot];
    data[pivot]=temp;
    pivot = start -1;

    while (start != end){
      //System.out.println(start);
      //System.out.println(end);
      //System.out.println(visual(data));

            if ( data[start] > data[pivot] ){
                temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                end--;
            }

            else if ( data[start] < data[pivot] ){
              start++;
            }

    }

    //System.out.println(start);
    //System.out.println(end);
    //System.out.println(visual(data));

    if (data[start] > data[pivot]){
        temp = data[start-1];
        data[start-1]=data[pivot];
        data[pivot]=temp;
        //System.out.println(visual(data));
        return start-1;
    }

    temp = data[start];
    data[start]=data[pivot];
    data[pivot]=temp;
    //System.out.println(visual(data));

    return start;
}


private static String visual(int[] data){
  String visual = "[";
    for (int v = 0; v < data.length; v++){
        visual = visual + data[v];
        if (v<data.length-1 ) visual += ", ";
    }
    return visual +"]";
}


public static void main(String[] args){
  //int[] data = {1, 2, 3, 4, 5,6,7,8,9,10,11};
//  System.out.println(partition(data,0,0));
}


}

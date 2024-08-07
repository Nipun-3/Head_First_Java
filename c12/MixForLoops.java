package c12;

import java.util.List;

class MixForLoops {
    public static void main (String [] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5) ;
        String output = "";

//        for (int i = 1; i < nums.size(); i++)
//            output += nums.get(i) + " ";           //     2 3 4 5


//        for (Integer num : nums)
//            output += nums + " ";         //   [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5]


//        for (int i= 0; i <= nums.length; i++)        //  compile error
//            output += nums.get(i) + " ";

//        for (int i = 0; i <= nums.size(); i++)        //    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
//            output += nums.get(i) + " ";

        System.out.println (output) ;

    }

}
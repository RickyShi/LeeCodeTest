package repo_2019_2020.first400.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q349_intersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
         Set<Integer> set2 = new HashSet<>();
         List<Integer> ls = new ArrayList<>();

         for (int i:nums1){
             set1.add(i);
         }
         for (int i:nums2){
             set2.add(i);
         }
         for (int i:set1){
             if (set2.contains(i)){
                 ls.add(i);
             }
         }
         return convertListToArray(ls);
     }

     private  int[] convertListToArray(List<Integer> list) {

         int [] rtn = new int[list.size()];
         for (int i = 0;i<list.size();i++) {
             rtn[i]=list.get(i);
         }
         return rtn;
    }
}

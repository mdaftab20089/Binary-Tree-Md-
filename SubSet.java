import java.util.*;
class PAndC {
    public  List<List<Integer>> Subset(int[] nums) {
          List<List<Integer>> list=new ArrayList<>();
          Backtrack(list, new ArrayList<>(), nums, 0); 
          return list;
    }
    public  void Backtrack(List<List<Integer>> list, List<Integer> temp,int[] nums,int start) {
        /*adding the empty list i.e [] */
        list.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            /*Backtrack to the previous element*/
            Backtrack(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}

class Subset {
    public static void main(String[] args) {
        PAndC p=new PAndC();
        int[] arr={1,2,3,4};
        List<List<Integer>> list=new ArrayList<>();
        list=p.Subset(arr);
        for(List<Integer> x: list) System.out.println(x);
    }
}


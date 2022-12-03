package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class MinimumWeightPathInATriangle {
  @EpiTest(testDataFile = "minimum_weight_path_in_a_triangle.tsv")

  public static int minimumPathTotal(List<List<Integer>> triangle) {
    // Time complexity O(number_of_level ^ 2)
    // Space complexity O(number_of_level)
    int n = triangle.size();
    int[] memo = new int[n + 1];
    
    for(int level = n - 1; level >= 0; level--){
        // System.out.println(level);
        int size_level = triangle.get(level).size();
        
        for(int j = 0; j < size_level; j++){
            
              // System.out.println(level);
            memo[j] = triangle.get(level).get(j) + Math.min(memo[j+1], memo[j]);    
        }
        
    }
    
    return memo[0];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MinimumWeightPathInATriangle.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}

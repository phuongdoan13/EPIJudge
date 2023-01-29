package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;

public class NumberOfTraversalsMatrix {
  @EpiTest(testDataFile = "number_of_traversals_matrix.tsv")

  public static int numberOfWays(int N, int M) {
    if(N == 1 || M == 1) return 1;
    int[][] memo = new int[N+1][M + 1];
    for(int i = 0; i <= N; i++){
      memo[i][0] = 1;
    }
    for(int i = 0; i <= M; i++){
      memo[0][i] = 1;
    }

    for(int n = 1; n < N; n++){
      for(int m = 1; m < M; m++){
        memo[n][m] = memo[n-1][m] + memo[n][m-1];
      }
    }
    return memo[N-1][M-1];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfTraversalsMatrix.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}

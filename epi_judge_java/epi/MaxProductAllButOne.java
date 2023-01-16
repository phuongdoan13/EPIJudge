package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.stream.IntStream;
import java.util.List;
public class MaxProductAllButOne {
  @EpiTest(testDataFile = "max_product_all_but_one.tsv")

  public static int findBiggestProductNMinusOneProduct(List<Integer> A) {
    // TODO - you fill in here.
    int numNeg = 0;
    int largestAbsNegIdx = -1;
    int smallestAbsNegIdx = -1;
    int smallestPosIdx = -1;

    for(int i = 0; i < A.size(); i++){
      if(A.get(i) < 0){
        numNeg++;
        if(largestAbsNegIdx == -1 || A.get(largestAbsNegIdx) > A.get(i))
          largestAbsNegIdx = i;
        if(smallestAbsNegIdx == -1 || A.get(smallestAbsNegIdx) < A.get(i))
          smallestAbsNegIdx = i;
      }else{
        if(smallestPosIdx == -1 || A.get(smallestPosIdx) > A.get(i))
          smallestPosIdx = i;
      }
    }
    int idxToSkip = (numNeg % 2 != 0) ? smallestAbsNegIdx : (smallestPosIdx != -1 ? smallestPosIdx : largestAbsNegIdx);

    return IntStream.range(0, A.size())
            .filter(i -> i != idxToSkip)
            .reduce(1, (product, i) -> product * A.get(i));
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxProductAllButOne.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}

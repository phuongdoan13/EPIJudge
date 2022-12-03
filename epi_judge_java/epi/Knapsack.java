package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.List;
public class Knapsack {
  @EpiUserType(ctorParams = {Integer.class, Integer.class})

  public static class Item {
    public Integer weight;
    public Integer value;

    public Item(Integer weight, Integer value) {
      this.weight = weight;
      this.value = value;
    }
  }

  @EpiTest(testDataFile = "knapsack.tsv")

  public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
    Integer[][] memo = new Integer[capacity + 1][items.size()];

    return recursive(items, capacity, memo, 0);
  }
  private static int recursive(List<Item> items, int remaining_capacity, Integer[][] memo, int i){
    if(i >= items.size()) return 0;
    if(memo[remaining_capacity][i] != null) return memo[remaining_capacity][i];
    int withCurr = (remaining_capacity - items.get(i).weight >= 0) ? items.get(i).value + recursive(items, remaining_capacity - items.get(i).weight, memo, i + 1) : 0;
    int withoutCurr = recursive(items, remaining_capacity, memo, i + 1);
    memo[remaining_capacity][i] = Math.max(withoutCurr, withCurr);
    return memo[remaining_capacity][i];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Knapsack.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}

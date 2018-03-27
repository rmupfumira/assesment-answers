package test.russel.com;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

;

/**
 * There is an array with the numbers 1-1000 within it.
 *
 * The array however has 1001 entries, where a single number is repeated only once.
 *
 * The array is not sorted, and the number that duplicates is not sequential.
 *
 * eg1: n=[5,2,3,1,100,50,2] => 2 repeats. eg2: n=[1,5,6,2,3,8,7,9,5] => 5 repeats
 */
public class InterviewQuestion_Duplicate_Number_Test {

    /**
     * Lists have been scaled down to 10 (for illustration), but assume the actual size would be
     * 1001.
     */
    final List<Integer> arr1 = new ArrayList<>(Arrays.asList(5, 2, 3, 1, 100, 50, 2, 8, 10, 4));
    final List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 5, 6, 2, 1000, 8, 7, 9, 5, 256));

    /**
     * Restrictions:
     *
     * Only parse the array once.
     *
     * Do not sort the array.
     */
    private int findDuplicate(final List<Integer> array) {
        int duplicate = -1;
        HashSet<Integer> tempSet = new HashSet<>();
        for(Integer num : array){
            if(!tempSet.add(num)){
                duplicate = num;
                break;
            }
        }
        return duplicate;
    }

    /**
     * Q1. Complete the findDuplicate() method to return the expected duplicate int.
     *
     * Adhere to the java-doc restrictions on the findDuplicate() method.
     *
     * Q2. Why did we impose the restriction of not sorting the array? - If you sort the array in the method then it adds additional complexity of at least 0(n) to both time and space to the algorithm
     *
     * Q3. What are the limitations of your solution? - consider scalability and performance.
     * The complexity of this solution is O(n)(which is not too bad) but it also has space complexity of O(n) because of the Hashset data structure, so if we have 1 million entries then the HashSet needs to store those 1 million elements
     *
     * Q4. Can you suggest alternative's to your solution? - weighing up pro's & con's.
     *  You can also consider the Gaussian sum of integers formula = n*(n+1)/2 and you subtract that from the actual sum.
     *
     *  Pros
     *  -Complexity of O(n) time
     *  - O(1) space
     *
     *  Cons
     *  - assumes and works with sequential numbers(arithmetic series) otherwise the algorithm fails(for instance our current test data set)
     *  - chances of integer overflow as the number range grows
     */
    @Test
    public void find_duplicate_test() throws Exception {
        final int dupe1 = findDuplicate(arr1);
        final int dupe2 = findDuplicate(arr2);
        Assert.assertEquals(2, dupe1);
        Assert.assertEquals(5, dupe2);
    }
}

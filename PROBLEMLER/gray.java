/*An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.

 */
import java.util.*;

public class GrayCodeGenerator {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCodeGenerator generator = new GrayCodeGenerator();
        int n = 3;
        List<Integer> sequence = generator.grayCode(n);
        for (int num : sequence) {
            System.out.println(num);
        }
    }
}

//TC: O(N) SC: O(N)
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class StreamingInputForLargeArray{
    public static int[] hasTwoSum(InputStream stream, int target) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Map<Integer, Integer> seen = new HashMap<>();
        String line;
        int index = 0;
        while((line = reader.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()){ 
                index++; 
                continue;
            }
            int num;
            try{
                num = Integer.parseInt(line);

            } catch(NumberFormatException e){
                System.err.println("Skipping invalid input: " + line);
                index++;
                continue;
            }
            int complement = target - num;
            if(seen.containsKey(complement)){
                return new int[]{seen.get(complement), index};
            }
            seen.put(num, index);
            index++;
        }
        return new int[]{-1, -1};

    }
    public static void main(String[] args) {
        String largeInput = "1000000\n7\n3\n11\n5\n15\n9\n2\n";
        InputStream stream = new ByteArrayInputStream(largeInput.getBytes());
        int target = 10;

        try{
            int[] result = hasTwoSum(stream, target);
            if(result[0] != -1){
                System.out.println("Indices of pair: " + result[0] + " and " + result[1]);
            } else {
                System.out.println("No such pair exists");
            }
        } catch (IOException e){
            System.err.println("Error reading input stream.");
            e.printStackTrace();
        }
    }
}
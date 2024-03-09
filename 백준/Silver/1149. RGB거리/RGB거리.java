import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int color[][] = new int[n][3];
        String input;
        for(int i=0;i<n;i++){
            input = br.readLine();

            color[i][0] = Integer.parseInt(input.split(" ")[0]);
            color[i][1] = Integer.parseInt(input.split(" ")[1]);
            color[i][2] = Integer.parseInt(input.split(" ")[2]);

        }

        for(int i=1;i<n;i++){
            color[i][0] += Math.min(color[i-1][1], color[i-1][2]);
            color[i][1] += Math.min(color[i-1][0], color[i-1][2]);
            color[i][2] += Math.min(color[i-1][0], color[i-1][1]);
        }

        System.out.println(Math.min(Math.min(color[n-1][0], color[n-1][1]), color[n-1][2]));
        
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;
        String text;
        int tri[] = new int[3];

        while (true) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            tri[0] = Integer.parseInt(stringTokenizer.nextToken());
            tri[1] = Integer.parseInt(stringTokenizer.nextToken());
            tri[2] = Integer.parseInt(stringTokenizer.nextToken());

            text = method(tri);

            if(text.equals("끝"))
            {
                break;
            } else{
                System.out.println(text);
            }
        }
    }

    private static String method(int tri[]) {
        String text = "";
        boolean bool = false;

        if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) {
            text = "끝";
        } else {
            if (tri[0] == tri[1] && tri[1] == tri[2]) {
                text = "Equilateral";
            } else {
                int max;
                if (tri[0] >= tri[1] && tri[0] >= tri[2]) {
                    max = tri[0];
                    if (max < tri[1] + tri[2]) {
                        bool = true;
                    } else {
                        text = "Invalid";
                    }
                } else if (tri[1] >= tri[0] && tri[1] >= tri[2]) {
                    max = tri[1];
                    if (max < tri[0] + tri[2]) {
                        bool = true;
                    } else {
                        text = "Invalid";
                    }
                } else if (tri[2] >= tri[0] && tri[2] >= tri[1]) {
                    max = tri[2];
                    if (max < tri[1] + tri[0]) {
                        bool = true;
                    } else {
                        text = "Invalid";
                    }
                }

                if (bool == true) {
                    if (tri[0] == tri[1] || tri[1] == tri[2] || tri[0] == tri[2]) {
                        text = "Isosceles";
                    } else if (tri[0] != tri[1] && tri[1] != tri[2]) {
                        text = "Scalene";
                    }
                }
            }
        }
        return text;

    }
}
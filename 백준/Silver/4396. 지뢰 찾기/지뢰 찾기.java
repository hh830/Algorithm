import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine()); //n x n

        char arr[][] = new char[n+1][n+1];
        char boom[][] = new char[n+1][n+1];

        String str;
        int count = 0, x=0, y=0;

        int dx[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for(int i=1;i<=n;i++){
            str = bufferedReader.readLine();
            for(int j=1;j<=n;j++){
                arr[i][j] = str.charAt(j-1);

            }
        }

        for(int i=1;i<=n;i++){
            str = bufferedReader.readLine();
            for(int j=1;j<=n;j++){
                if(str.charAt(j-1) == 'x'){
                    if(arr[i][j] == '*')
                    {
                        for(int l=1;l<=n;l++){
                            for(int t=1;t<=n;t++){
                                if(arr[l][t] == '*')
                                    boom[l][t] = '*';
                            }
                        }
                    } else{
                        for(int k=0;k<9;k++){
                            x = i+dx[k];
                            y = j+dy[k];

                            if(x >= 1 && x <= n && y >= 1 && y <= n && arr[x][y] == '*')
                            {
                                count++;
                            }
                        }
                        boom[i][j] = (char) (count + '0');
                    }
                } else if(boom[i][j] == 0){
                    boom[i][j] = '.';
                }
                count = 0;

            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(boom[i][j]);
            }
            System.out.println();
        }

    }
}
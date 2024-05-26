import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean check;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p1) {
            return name.compareTo(p1.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int p = Integer.parseInt(str.split(" ")[0]); //플레이어 수
        int m = Integer.parseInt(str.split(" ")[1]); //방의 정원

        //플레이어가 입장을 신청하였을 때 매칭이 가능한 방이 없다면 새로운 방을 생성하고 입장시킨다. 이떄 해당 방에는 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능하다.
        //입장 가능한 방이 있다면 입장시킨 후 방의 정원이 모두 찰 때까지 대기시킨다.
        //이때 입장이 가능한 방이 여러 개라면 먼저 생성된 방에 입장한다.
        //방의 정원이 모두 차면 게임을 시작시킨다.
        Player[] players = new Player[p];
        StringBuilder stringBuilder = new StringBuilder();

        int l;
        String n;
        for (int i = 0; i < p; i++) {
            str = br.readLine();
            l = Integer.parseInt(str.split(" ")[0]);
            n = str.split(" ")[1];

            players[i] = new Player(l, n);
        }
        
        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].check) {
                
                for (int j = i; j < p; j++) {
                    
                    if (room.size() == m) {
                        break;
                    }
                    
                    l = players[j].level;
                    n = players[j].name;
                    
                    if (!players[j].check && players[i].level + 10 >= l && players[i].level - 10 <= l) {
                        players[j].check = true;
                        room.add(new Player(l, n));
                    }
                }

                Collections.sort(room);
                
                if (room.size() == m) {
                    stringBuilder.append("Started!").append("\n");
                } else {
                    stringBuilder.append("Waiting!").append("\n");
                }
                for (Player player : room) {
                    stringBuilder.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }

}





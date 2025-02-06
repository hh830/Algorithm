import java.io.*;
import java.util.*;

// Trie 노드 클래스 
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); // 자식 노드 저장
    boolean isEndOfWord; // 단어의 끝인지 여부
}

// Trie
class Trie {
    private TrieNode root; // 루트 노드

    public Trie() {
        root = new TrieNode(); // Trie 생성 시 루트 노드 초기화
    }

    // 문자열 삽입
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) { // 문자열의 각 문자에 대해
            node.children.putIfAbsent(ch, new TrieNode()); // 자식 노드가 없으면 생성
            node = node.children.get(ch); // 다음 노드로 이동
        }
        node.isEndOfWord = true; // 문자열의 끝 표시
    }

    // 접두사가 Trie에 존재하는지 탐색
    public boolean search(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) { // 접두사의 각 문자에 대해
            if (!node.children.containsKey(ch)) return false; // 없으면 false 반환
            node = node.children.get(ch); // 다음 노드로 이동
        }
        return true; // 접두사가 존재함
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문자열 개수
        int M = Integer.parseInt(st.nextToken()); // 검사할 접두사 개수

        Trie trie = new Trie(); // Trie 객체 생성

        // N개의 문자열을 Trie에 삽입
        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine()); // Trie에 문자열 추가
        }

        int count = 0; // 접두사로 존재하는 문자열 개수

        // M개의 문자열이 접두사인지 확인
        for (int i = 0; i < M; i++) {
            if (trie.search(br.readLine())) { // 접두사가 존재하면
                count++; // 개수 증가
            }
        }

        System.out.println(count); // 결과 출력
    }
}

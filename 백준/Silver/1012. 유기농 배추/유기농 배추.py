import sys #런타임 오류
sys.setrecursionlimit(10000) #파이썬 기본 재귀 한도는 1000, 재귀 깊이가 1000을 넘어갈 경우 모듈 추가

global visited
global array


def dfs(x, y):
    global count
   
    visited[y][x] = 1 #방문 처리
    listx = [0, 0, 1, -1]
    listy = [1, -1, 0, 0]

    for i in range(0,4,1):
        
        dx = int(listx[i]) + x
        dy = int(listy[i]) + y

        if dx >= 0 and dy >= 0 and dx < M and dy < N :
            if array[dy][dx] == 1 and visited[dy][dx] == 0:
                dfs(dx, dy)
            '''else:
                cnt += 1
                print("cnt")
        else:
            cnt += 1
        print("cnt", cnt)
    if cnt == 4:
        count+=1
        print("count", count)

    return count'''


T = int(input()) #테스트케이스 개수

for q in range(0,T,1):
    count = 0
    a = input() #가로 세로 위치개수

    input_arr = a.split()
    M = int(input_arr[0])
    N = int(input_arr[1])
    K = int(input_arr[2])

    visited = [[0] * M for _ in range(N)]

    array =[[0] * M for _ in range(N)]
    
    for p in range(0,K,1):
        b = input()
        str = b.split()
        str0 = int(str[0])
        str1 = int(str[1])
        array[str1][str0]=1 #일반적인 언어 배열은 행,열 순인데 파이썬은 열,행 순임;;

    for i in range(0,M,1):
        for j in range(0,N,1):
            if array[j][i]==1 and visited[j][i] == 0:
                dfs(i, j)
                count += 1
    print(count)
    
    


import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    arr = []

    for _ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        arr.append((a, b))

    arr.sort(key=lambda x: x[0])

    count = 1

    min = arr[0][1]

    for i in range(1, n):
        if arr[i][1] < min:
            count += 1
            min = arr[i][1]

    print(count)

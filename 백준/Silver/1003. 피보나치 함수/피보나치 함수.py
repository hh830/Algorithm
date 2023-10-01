T = int(input())
count = 1

while(count<=T):
    n = int(input())
    count += 1

    zero = [1,0]
    one = [0,1]

    for i in range(2,n+1,1):
        zero.append(one[-1])
        one.append(zero[-2]+one[-1])
    print(zero[n], one[n])
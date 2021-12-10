dx = [1, 0, -1, 0] # dx[0] 은 오른쪽으로 움직일 때, dx[2]은 왼쪽으로 움직일 때 
dy = [0, 1, 0, -1] # dy[1] 은 y축으로 달팽이 배열에서 아래로 움직일 때, dy[3]는 위로 움직일때

T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    Map = [[0]*N for _ in range(N)]
    y, x = 0, -1 # 
    d = 0
    cnt = 0 
    while cnt < N*N:
        # print(bool(not True or True))
        if not (0 <= x + dx[d] < N and 0 <= y + dy[d] < N) or Map[y+dy[d]][x+dx[d]]:
            d = (d+1) % 4

        x += dx[d]
        y += dy[d]
        cnt+=1 # 맵 N*N 의 크기만큼 반복하기 위함 0~15
        Map[y][x] = cnt

    print('#{}'.format(test_case))
    for m in Map:
        print(*m)
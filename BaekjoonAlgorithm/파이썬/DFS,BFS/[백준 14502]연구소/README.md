문제링크: https://www.acmicpc.net/problem/14502

전체 보드의 크기의 최대값은 8 X 8이므로 3개의 벽을 설치할 수 있는 경우의 수는 조합으로 계산했을 때 83328가지로 모든 경우의 수를 따져가기에는
제한 시간 내에 충분히 실행을 할 수가 있습니다. 따라서 다음과 같은 방식으로 구현을 할 수 있습니다.

1. 바이러스를 퍼뜨리는 함수인 virus, 바이러스가 없는 안전영역의 크기를 계산하는 함수 num_of_zero, 울타리 3개를
   dfs방식으로 보드에 배치하는 형식인 dfs 함수를 만든다.

2. dfs 메서드를 호출하여 울타리 3개를 보드에 배치하는 모든 경우의 수마다 virus 메서드에서 bfs 알고리즘을 적용하여 바이러스를
   퍼뜨리고, num_of_zero메서드에서 안전영역의 크기를 계산을 한다.

3. 그 경우의 수마다 안전 영역의 크기의 최댓값을 계산한다.

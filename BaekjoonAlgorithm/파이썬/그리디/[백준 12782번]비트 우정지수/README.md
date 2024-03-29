문제링크: https://www.acmicpc.net/problem/12782

하나의 이진수에서 임의의 자리의 숫자를 0또는 1로 바꾸는 방식과, 서로 다른 자리에 있는 두 숫자의 위치를 바꾸어가며 두 이진수가 같아지기까지의 최소 횟수를 계산을 하려면 다음과 같은 과정을 생각해 볼 수 있습니다.

1. 두 비트 중 아무 비트 하나 골라서 또다른 비트에서의 자리 숫자가 다른 곳들의 경우를 세어줍니다. 그리고 선택한 비트에서 그 자리가 '0'인 경우와 '1'인 경우도 각각 따로 세어줍니다.
2. '0'인 경우의 갯수가 적다면 '0'은 '1'과 바꿔버리면 되므로 **총횟수에서 '0'의 갯수를 빼주면 최소 횟수를 구할 수가 있습니다.**
3. '1'인 경우의 갯수가 적다면 2번의 경우와 반대로 진행하면 되고, '0'과 '1'의 갯수가 같다면 서로 뒤바꿔주면 되므로 **총횟수에서 2로 나눠주면 최소 횟수를 구할 수가 있습니다.**

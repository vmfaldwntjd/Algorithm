문제링크: https://www.acmicpc.net/problem/11256

상자의 개수를 최소로 쓰기 위해서는 사탕을 많이 담을 수 있는 상자를 우선적으로 택하는 그리디 방식을 적용하면 됩니다. 다음과 같은 과정으로 문제를 해결하였습니다.

1. 상자의 정보를 입력받아서 그것의 공간을 계산하여 각각 리스트에 담는다.
2. 리스트를 내림차순으로 정렬하여 상자의 공간만큼 사탕을 제거해나가면서 상자의 개수를 카운트한다.

문제 링크: https://www.acmicpc.net/problem/11054
- - -
> 바이토닉 수열의 간단한 구조를 그림으로 소개  
<img width="714" alt="Screen Shot 2022-07-18 at 4 28 17 PM" src="https://user-images.githubusercontent.com/75198221/179463140-b2833c6e-5676-446f-bb24-a700e2f6b1eb.png">

-> 어떤 수열이 있는데 해당 ***기준점의 왼쪽 부분은 기준점까지의 가장 긴 증가하는 수열이 되야하고***, ***오른쪽 부분은 기준점을 시작으로 가장 긴 감소하는 부분 수열이 되야*** 답을 도출할 수 있다.  

> 해결 과정
- 다이나믹 프로그래밍 문제로 기준점 왼쪽, 오른쪽에 대한 가장 긴 증가하는 수열을 담을 dynamic table을 각각 만들고 문제를 풀어야 한다.  
- 나는 왼쪽에 대한 dp테이블을 d_left로 정의하였고, 오른쪽에 대한 dp테이블을 d_right로 정의하였다. 
- [가장 긴 증가하는 부분 수열에 대한 문제 링크](https://github.com/vmfaldwntjd/Algorithm/blob/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%5B%EB%B0%B1%EC%A4%80%2011053%EB%B2%88%5D%EA%B0%80%EC%9E%A5%20%EA%B8%B4%20%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94%20%EC%88%98%EC%97%B4/%EA%B3%BC%EC%A0%95%20%EC%84%A4%EB%AA%85.md)를 참고해서 d_left를 완성하면 된다.  
 - [가장 긴 감소하는 부분 수열 대한 문제 링크](https://github.com/vmfaldwntjd/Algorithm/blob/master/BaekjoonAlgorithm/%EC%9E%90%EB%B0%94/%5B%EB%B0%B1%EC%A4%80%2011722%EB%B2%88%5D%EA%B0%80%EC%9E%A5%20%EA%B8%B4%20%EA%B0%90%EC%86%8C%ED%95%98%EB%8A%94%20%EB%B6%80%EB%B6%84%20%EC%88%98%EC%97%B4/Main.java)(아직 해결 과정은 만들지 않았다.)를 참고해서 d_right를 완성하면 된다.  
 - 최종 결과 값은 ```d_left[i] + d_right[i] - 1, (1 <= i <= n)```이 된다.  
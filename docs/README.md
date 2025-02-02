### 미션 흐름에 따른 문제 이해

1. 다리 건너기 게임 시작
    1. 게임 시작 문구 출력


2. 다리 길이 입력
    1. 다리 길이 입력 문구 출력
    2. 다리 길이 입력 받기
        - 입력 값 유효성 검사
            - 입력 값은 숫자여야 한다
            - 입력 값은 3 이상, 20 이하여야 한다
            - 위 사항에 부합하지 않는 경우 예외 발생
                - 에러 문구는 “[ERROR]”로 시작되어야 한다

                  → ex) `[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.`


3. 다리 생성
    1. 다리 길이 만큼 위 아래로 2 칸씩 추가하기
        - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
        - 다리 칸의 구분은 `|`(앞뒤 공백 포함) 문자열로 구분
    2. 건널 수 있는지 무작위 값 설정
        - 무작위 값이 0인 경우 : 아래 칸이 건널 수 있는 칸이 된다
        - 무작위 값이 1인 경우 : 윗 칸이 건널 수 있는 칸이 된다
    3. 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다


4. 라운드 별 플레이어가 이동할 칸 입력
    1. U 입력 : 위 칸으로 이동
    2. D 입력 : 아래 칸으로 이동
    3. 그 외 값 입력 : 예외 발생
        - 에러 문구는 “[ERROR]”로 시작되어야 한다

          → ex) `[ERROR] 위 칸으로 이동할 시 'U', 아래 칸으로 이동할 시 'D'를 입력해 주셔야 합니다.`


5. 건널 수 있는 칸인지 확인 및 결과 출력
    1. 건널 수 있는 칸인지 확인
    2. 결과 출력
        - 이동할 수 있는 칸을 선택한 경우 O 표시
        - 이동할 수 없는 칸을 선택한 경우 X 표시
        - 선택하지 않은 칸은 공백 한 칸으로 표시
        - 현재까지 건넌 다리를 모두 출력
        - **예시**

            ```
            [ O ]
            [   ]
            
            [ O | X ]
            [   |   ]
            
            [ O |   |   ]
            [   | O | O ]
            ```

    <br>
6. 4번과 5번 반복
    - 다리를 모두 건너거나 건너기에 실패할 때까지 반복한다

    
7. 게임 종료 및 재시작
    1. 다리를 모두 건넌 경우
        - 게임 종료
        - 최종 다리 결과 출력
        - 게임 성공 여부 ‘성공’으로 출력
        - 시도 횟수 출력

    2. 다리 건너기를 실패한 경우
        - 게임을 종료(Q)할 지 재시작(R)할 지 질문 출력
            1. Q 입력 : 게임 종료 및 시도 횟수 출력
                - 최종 게임 결과 출력
                    - 최종 다리 결과 출력
                    - 게임 성공 여부 ‘실패’로 출력
                    - 시도 횟수 출력
            2. R 입력 : 게임 재시작
                - 재시작해도 처음에 만든 다리로 재사용한다
                - 게임 시도 횟수 +1
            3. 그 외의 값 입력
                - 에러 문구는 “[ERROR]”로 시작되어야 한다

                  → ex) `[ERROR] 게임을 종료하고 싶을 시 'Q', 재시작하고 싶을 시 'R'을 입력해 주셔야 합니다.`

<br>

---
## 기능에 따른 분류

### BridgeGameController

> 게임을 한 번 수행했을 때에 대한 절차를 관리하는 클래스

- [x]  게임 진행
    - [x]  객체 초기화
    - [x]  게임 시작 메시지 호출
    - [x]  다리 길이 입력을 통한 다리 생성
    - [x]  플레이어 게임 시작 -> 플레이어 이동 호출
    - [x]  게임 종료 시 결과 출력


- [x]  플레이어 이동
    - [x]  종료되기 전까지 반복
    - [x]  이동한 다리에 입력에 따른 결과 맵 출력
    - [x]  조건에 따른 게임 종료
    - [x]  실패로 종료될 시 게임 재시작 호출
    - [x]  성공으로 종료될 시 게임 종료


- [x]  게임 재시작
    - [x]  게임 재시작 여부 확인
    - [x]  R, 재시작 선택 : 플레이어 이동 기능 호출
    - [x]  Q. 종료 선택 : 결과 출력 후 controller에 종료를 알림
    - [x]  그 외 값 입력 : 예외 발생
        - 에러 문구는 “[ERROR]”로 시작되어야 한다

          → ex) `[ERROR] 게임 재시도 시 'R', 종료 시 'Q'를 입력해 주셔야 합니다.`


<br>

### BridgeGame

> 플레이어 이동과 관련된 기능을 관리하는 클래스

- [x]  이동과 관련된 객체 초기화
- [x]  플레이어 이동
    - [x]  이동 기록 저장
    - [x]  이동에 따른 다리 맵 가져오기
- [x]  게임 재시작
    - [x]  시도 횟수 +1
    - [x]  관련 객체 초기화
        - `CurrentBridgeMap`
        - `PlayerMovement`
- [x]  게임 상태 전달
    - [x]  게임 종료 여부
        - [x]  입력 값이 다리와 동일하지 않은 경우 종료
        - [x]  다리 크기만큼 입력한 경우 종료 후 성공 여부 체크
    - [x]  게임 성공 여부


<br>

### BridgeMaker

> 사용자에게 입력 받은 다리 길이의 유효성 검사 후 길이에 따라 다리를 생성하는 클래스

- [x]  다리 길이 입력 받기
    - [x]  입력 값 유효성 검사
        - [x]  입력 값은 3 이상, 20 이하여야 한다
        - [x]  위 사항에 부합하지 않는 경우 예외 발생
            - 에러 문구는 “[ERROR]”로 시작되어야 한다

              → ex) `[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.`


- [x]  다리 생성
    - [x]  건널 수 있는지 무작위 값 설정 → `BridgeRandomNumberGanerator` 호출
        - 무작위 값이 0인 경우 : 아래 칸이 건널 수 있는 칸이 된다
        - 무작위 값이 1인 경우 : 윗 칸이 건널 수 있는 칸이 된다
    - [x]  위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다

<br>

### BridgeRandomNumberGenerator

> 미션에서 제공된 클래스 및 코드로, 위아래 중 어떤 칸으로 건널 수 있을지 정해주는 클래스


<br>

### Bridge

> 생성된 다리에 대한 정보를 저장 및 정답을 체크하는 클래스

- [x]  다리 정보 저장
- [x]  정답인지 체크
    - [x]  입력한 값이 동일한지 비교 (특정 인덱스만)
    - [x]  다리를 모두 건넜을 때 전체가 동일한지 비교


<br>

### PlayerMovement

> 사용자에게 입력 받은 이동할 칸에 대한 유효성 검사 및 선택 칸에 따른 결과를 도출하는 클래스

- [x]  입력 값 유효성 검사
    - [x]  U 입력 : 위 칸으로 이동
    - [x]  D 입력 : 아래 칸으로 이동
    - [x]  그 외 값 입력 : 예외 발생
        - 에러 문구는 “[ERROR]”로 시작되어야 한다

          → ex) `[ERROR] 위 칸으로 이동할 시 'U', 아래 칸으로 이동할 시 'D'를 입력해 주셔야 합니다.`

- [x]  사용자 이동 값 누적 저장


<br>

### CurrentBridgeMap

> 사용자의 이동에 따른 현재 다리의 그림을 만들어주는 클래스

- [x]  다리 그림 업데이트
    - 위아래 중 선택 값, 정답 여부에 따라 다리 그림을 업데이트한다 
    - [x]  위쪽 다리 업데이트
    - [x]  아래쪽 다리 업데이트


- [x]  현재 다리 맵 가져오기
    - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
    - 다리 칸의 구분은 `|`(앞뒤 공백 포함) 문자열로 구분


<br>

### InputView

> 사용자가 입력해야 하는 기능을 모아둔 클래스

- [x]  다리 길이 입력
    - [x]  입력 값이 숫자가 아니라면 예외 발생
        - 에러 문구는 “[ERROR]”로 시작되어야 한다

          → ex) `[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.`
    - [x]  숫자 타입으로 반환한다
- [x]  이동할 칸 입력
- [x]  게임 재시도 및 종료 입력

<br>

### OutputView

> 사용자에게 출력되는 기능들을 모아둔 클래스

- [x]  게임 시작 알림 메시지 출력
- [x]  이동칸 선택에 대한 결과 출력
- [x]  게임 결과 출력
    - [x]  게임 성공 여부 출력
    - [x]  총 시도 횟수 출력

<br>

---
## 예외 사항
### 1. 다리 길이 입력

> 에러 발생 메시지 : `다리 길이는 3부터 20 사이의 숫자여야 합니다.`

1. 입력 값이 숫자가 아닌 경우
    - try-catch 문을 통해 숫자가 아니거나 정수형의 범위를 넘어간 값은 예외를 발생시키도록 함
2. 입력 값이 3미만, 20초과인 경우

<br>

### 2. 이동할 칸 입력

> 에러 발생 메시지 : `위 칸으로 이동할 시 'U', 아래 칸으로 이동할 시 'D'를 입력해 주셔야 합니다.`

1. 입력 값이 U or D가 아닌 경우
    - U, D의 소문자를 비롯한 모든 문자열을 입력한 경우 예외를 발생시키도록 함

<br>

### 3. 게임 재시도 여부 입력

> 에러 발생 메시지 : `게임 재시도 시 'R', 종료 시 'Q'를 입력해 주셔야 합니다.`

1. 입력 값이 R or Q가 아닌 경우
    - R, Q의 소문자를 비롯한 모든 문자열을 입력한 경우 예외를 발생시키도록 함

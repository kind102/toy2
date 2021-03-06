#[정책문서]

###[정책문서 Wiki]
* [주문상태 정책](https://wiki.woowa.in/pages/viewpage.action?pageId=161801591)
* [가격 정책](https://wiki.woowa.in/pages/viewpage.action?pageId=167819034)
* [장바구니 정책](https://wiki.woowa.in/pages/viewpage.action?pageId=157466373)
* [주문/결제 정책](https://wiki.woowa.in/pages/viewpage.action?pageId=157466401)
* [재주문 정책](https://wiki.woowa.in/pages/viewpage.action?pageId=171936281)
* [기능명세](https://wiki.woowa.in/pages/viewpage.action?pageId=157453787)


###[기능명세]
| 유형 | 기능 명세 |
|---|---|
| 주문 |사용자는 사장님에게 음식과 관련된 요청사항을 남길 수 있다. |
| 주문 |사용자는 라이더에게 배달과 관련된 요청사항을 남길 수 있다. |
| 주문 | 사용자는 결제할 금액과 내역을 확인할 수 있다. |
| 주문/가게 | 사용자는 배달과 관련된 회사의 주의사항을 확인할 수 있다. |
| 주문/결제 | 사용자는 주문 금액을 확인하고 결제를 시도 할 수 있다. |
| 결제 | 사용자는 결제 수단을 선택할 수 있다.  |
| 결제/동의 | 사용자는 결제를 위한 동의 문구를 확인할 수 있다. |
| 회원/동의 | 사용자는 개인정보가 제3자에게 제공될 수 있음을 확인할 수 있다.  |
| 배달지 | 사용자는 현재 배달정보를 확인할 수 있다. |
| 배달지 | 사용자는 주문을 수령할 사람의 휴대폰 번호를 변경할 수 있다. |
| 쿠폰 | 사용자는 보유 쿠폰을 확인 및 사용할 수 있다.  |


###[정책]
* 장바구니 지면
    * 회원에게만 제공된다.
    * 장바구니는 회원당 1개만 존재 하며 서버어서 24시간 유지된다.  
      (장바구니가 갱신되면 다시 24시간 유지)
    * 장바구니에 여러 가게의 메뉴를 담을 수 없다.
        * 다른 가게의 메뉴를 담는 경우 기존 장바구니를 비우고 새로 담는다.
    * 장바구니 유효성 체크(장바구니 내에서 수량 변경시 동일하게 체크 된다.)
        ```
        * 메뉴 품절, 삭제
        * 메뉴 옵션 수량 변경
        * 옵션 품절, 삭제
        * 메뉴-옵션 연결 해제
        * 메뉴-옵션 가격 변경
        * 메뉴 할인정보 변경
        ```
    * 장바구니에서 주문하기 요청 가능.


* 주문 지면
    * 주문하기 요청 시 매번 주문번호가 생성된다.
    * 장바구니 품목이 바뀌어도 진행 중 주문에는 영향을 주지 않는다.
    * 사용자는 사장님에게 요청사항을 남길 수 있다.
        * 60자까지 입력 가능
    * 사용자는 라이더에게 배달과 관련된 요청사항을 남길 수 있다.
        * 60자까지 입력 가능
    * 사용자는 보유 큐폰을 확인 및 사용할 수 있다.
    * 사용자는 결제할 금액과 내역을 확인 할 수 있다.
    * 사용자는 결제 수단을 선택할 수 있다.
    * 사용자는 배달관련해서 회사의 주의사항을 확인할 수 있다.
    * 사용자는 개인정보가 제3자에게 제공될 수 있음을 확인할 수 있다.
        * 약관페이지
        * 개인정보 제3자 제공 정책 노출 및 저장 : 회원서비스에 저
    * 사용자는 결제를 위한 동의 문구를 확인할 수 있다.
    * 사용자는 주문 금액을 확인하고 결제를 시도할 수 있다.
    * 주문 유효성 체크
        ```
        * 가게 상태
            * 가게 운영중 상태
            * 배달권역 체크
        * 메뉴 품절, 삭제
        * 메뉴 옵션 수량 변경
        * 옵션 품절, 삭제
        * 메뉴-옵션 연결 해제
        * 메뉴-옵션 가격 변경
        * 메뉴 할인정보 변경
        * 배달료 프로모션 변
        ```


* 결제 요청
    * 주문은 생성 후, 30분간 유효하다.
    * 결제 요청 유효성 체크
        ```
        * 상세주소 입력 여부
        * 전화번호 입력 여부
        * 쿠폰 유효성
            * 이미 사용한 쿠폰
            * 사용 기간 만료된 쿠폰
            * 할인적용 주문 금액(?)
        ```


* 재주문
    * 장바구니에 다른 메뉴가 담겨 있는 경우 비우고 새로 담는다.
    * 이 후의 유효성 검증은 `장바구니 생성`, `주문 생성`, `결제 요청` 과 동일하다.
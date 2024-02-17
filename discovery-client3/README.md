Spring Cloud EurekaClient3

Eureka 를 통한 API 통신 테스트 중 로드밸런싱 테스트

[테스트 내용]
1. Client에서 Eureka 를 이용해 서비스 네임으로 API를 호출할 때 이중화된 서비스에서 정상적으로 통신이 되는가에 대한 테스트
2. Client2 통신 중 client2 서비스를 종료하여 client3로 통신이 넘어가는지 확인

[통신방향]
1. 로드밸런싱
discovery-client -> discovery-client2  OR  discovery-client -> discovery-client3
2. discovery-client2를 중지
discovery-client -> discovery-client3

[결과]
1. client 에서 api 호출시 client2 와 client3 를 번갈아가며 호출함
2. 이후 client2 서비스를 중지하였을 때 10초가량의 시간동안 번갈아가며 호출을 시도하여 client2에 호출했을때는 에러페이지를,
client3에 호출됐을때는 정상적으로 값을 불러왔다
3. 10초가량의 시간이 지난 후 client3번에만 호출을하여 에러페이지 없이 정상적으로 값을 불러왔다.
4. 이후 client2를 재가동하였을때 10초가량은 client3번에만 호출하여 값을 가져왔다.
5. 10초가량의 시간이 지난 후 client2 와 client3 를 번갈아가며 호출하였음.

* Eureka Server에서 정상적으로 로드밸런싱을 해주는것으로 확인.
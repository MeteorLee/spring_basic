# 스프링 MVC


# 구조

## Controller

실제 코드 구현 부분이라고 생각하면 됨

## View

실제 출력해서 브라우저에 보이는 부분

## Model

뷰와 컨트롤러 사이에 연결할 때 전달하는 객체 Model

이때까지 파라미터로 자주 사용하였는데

```
public String getMember(Model model) {

...

model.addAttribute("member", memberid);
}
```

이런 식으로 자주 사용하였는데 사실 이 모델이 어떤 의미인지 잘 알지 못했는데 이번에 잘 알게 됨

MVC의 정확한 구조에 대한 이해를 얻게 됨
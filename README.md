##### declare-styleable이라는 태그를 통해 attr name에 attribute 이름을 정의하고 어떤 format으로 정의할 것인지 정한다.
```
<resources>
    <declare-styleable name="AniButton"> <!-- 재정의할 객체 이름-->
        <attr name = "animation" format = "string"/> <!-- 들어갈게 resource와 string 밖에 없다. 다른 타입은 자동완성 나온다 하더라도 허용이 안됨/-->
        <attr name = "delimeter" format = "string"/>
    </declare-styleable>
</resources>
```

##### activity_layout.xml에 버튼에 custom을 통해 attribute의 속성을 넣어줄 수 있음, animation 속성과 delimeter 속성 모두 String 타입이므로 각각 true와 true2라는 String 값을 입력하였음
```
<com.example.customview.AniButton
        ...
        ...
        custom:animation="true2"
        custom:delimeter="true"/>
```

##### java 코드에서 버튼의 생성자를 만들어 준다음
```java
public AniButton(Context context, AttributeSet attrs) { //속성들이 이 파라미터에 담겨서 넘어온다.
        super(context, attrs);
```
##### attrs.xml에 정의된 속성을 가져온다.
```java
TypedArray typed = context.obtainStyledAttributes(attrs, R.styleable.AniButton);
```
##### 해당 이름으로 정의된 속성의 개수를 가져온다.
```java
int size = typed.getIndexCount();
```
##### 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
```java
for(int i=0; i<size; i++){
            // 현재 배열에 있는 속성 아이디 가져오기
            int current_attr = typed.getIndex(i);
            switch(current_attr){
                case R.styleable.AniButton_animation :
                  ...
                  break;
                case R.styleable.AniButton_delimeter :
                  ...
                  break;
              }
}
```

##### View를 customize 해서 넣는 방법이 2가지가 있음
##### 1. 코드 상에서 뷰를 만들어 넣는 방법
##### 2. xml로 만들어서 넣는 방법

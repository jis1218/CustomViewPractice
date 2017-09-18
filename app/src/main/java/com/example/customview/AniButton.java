package com.example.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by 정인섭 on 2017-09-18.
 */

/*
animation 속성이 true일 경우 scale 애니메이션을 사용해서 클릭시 살짝 커졌다 작아지는 버튼을 만들어 보시오
 */

public class AniButton extends AppCompatButton { //AppComptButton은 하위버젼 호환성을 제공을 해준다.
// AppCompat이라고 prefix가 붙은 애들은 하위버전 호환 제공, v4, v7이라고 붙어 있는 애들이 있는데 v7이 v4에 있는 애들을 다 호환한다.
// 하지만 예외도 있음

    public AniButton(Context context, AttributeSet attrs) { //속성들이 이 파라미터에 담겨서 넘어온다.
        super(context, attrs);

        // 1. attrs.xml에 정의된 속성을 가져온다
        // 우리가 만들어놓은 자원을 사용할 때에는 context를 가면 된다. 함수로 다 정의되어 있다.
        TypedArray typed = context.obtainStyledAttributes(attrs, R.styleable.AniButton); //내가 정의한 값이 있는 것만 꺼내어 준다.
        // 2. 해당 이름으로 정의된 속성의 개수를 가져온다.
        int size = typed.getIndexCount();
        Log.d("AniButton", "size = " + size);
        // 3. 반복문을 돌면서 해당 속성에 대한 처리를 해준다.
        for (int i = 0; i < size; i++) {
            // 현재 배열에 있는 속성 아이디 가져오기
            int current_attr = typed.getIndex(i);
            switch (current_attr) {
                case R.styleable.AniButton_animation:
                    String animation = typed.getString(current_attr);
                    if ("true".equals(animation)) { //현업에서는 animation.equals("true")라고 쓰기보다는 반대로 쓴다. animation이 null이면 죽을 수 있으므로
                        String currentText = getText().toString();
                        setText("[animation]\n" + currentText);
                        setOnTouchListener(new OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {

                                //보통은 getAction을 switch로 잡는다.
                                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                                    AniButton.this.setText("하하하");
                                }
                                return false; //터치한다음 드래그를 했을 때 다음 액션에 대한 호출이 있느냐 없느냐를 반환함
                            }
                        });
                        setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                ObjectAnimator aniX = ObjectAnimator.ofFloat(AniButton.this, "scaleX", 1.0f, 1.2f, 1.0f);
                                ObjectAnimator aniY = ObjectAnimator.ofFloat(AniButton.this, "scaleY", 1.0f, 1.2f, 1.0f);

                                AnimatorSet set = new AnimatorSet();

                                set.playTogether(aniX, aniY);
                                set.setDuration(3000);
                                set.start();


//                                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.anim);
//                                startAnimation(anim);
//                                anim.setAnimationListener(new Animation.AnimationListener() {
//                                    @Override
//                                    public void onAnimationStart(Animation animation) {
//
//                                    }
//
//                                    @Override
//                                    public void onAnimationEnd(Animation animation) {
//                                        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.animback);
//                                        startAnimation(anim);
//                                    }
//
//                                    @Override
//                                    public void onAnimationRepeat(Animation animation) {
//
//                                    }
//                                });
                            }
                        });
                    }
                    break;

                case R.styleable.AniButton_delimeter:
                    String animation2 = typed.getString(current_attr);
                    if ("true".equals(animation2)) { //현업에서는 animation.equals("true")라고 쓰기보다는 반대로 쓴다. animation이 null이면 죽을 수 있으므로
                        String currentText = getText().toString();
                        setText("[true]\n" + currentText);
                    }
                    break;
            }
        }
    }


}

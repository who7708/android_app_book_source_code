package com.ansen.activityanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;

import ansen.activityanimation.R;

/**
 *
 * @author ansen
 * @create time 2018/2/26
 */
public class SharedElementActivity extends AppCompatActivity implements View.OnClickListener{
    private View viewShareOne;
    private TextView viewShareTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        viewShareOne=findViewById(R.id.view_share_one);
        viewShareTwo=findViewById(R.id.view_share_two);

        findViewById(R.id.rl_root).setOnClickListener(this);
        viewShareTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.rl_root){
            finish();
        }else if(view.getId()==R.id.view_share_two){//开启过渡效果
            Intent intent = new Intent(this, SecondShareElemActivity.class);

            Pair onePair = new Pair<>(viewShareOne, ViewCompat.getTransitionName(viewShareOne));
            Pair twoPair = new Pair<>(viewShareTwo, ViewCompat.getTransitionName(viewShareTwo));

            ActivityOptionsCompat transitionActivityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this, onePair, twoPair);
            ActivityCompat.startActivity(this,intent, transitionActivityOptions.toBundle());
        }
    }
}

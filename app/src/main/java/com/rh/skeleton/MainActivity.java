package com.rh.skeleton;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        logging.log(getTag(), ioUtils);
    }

    @Override
    protected String getTag() {
        return MainActivity.class.getSimpleName();
    }


}

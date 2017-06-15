package com.speedata.uhf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UhfManager mManager;
    private static final String TAG = "Reginer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager = UhfManager.getUHFService(this);
        initView();
    }

    private void initView() {
        Button mBtnOpenDev = (Button) findViewById(R.id.btn_open_dev);
        mBtnOpenDev.setOnClickListener(this);
        Button mBtnCloseDev = (Button) findViewById(R.id.btn_close_dev);
        mBtnCloseDev.setOnClickListener(this);
        Button mBtnInventoryStart = (Button) findViewById(R.id.btn_inventory_start);
        mBtnInventoryStart.setOnClickListener(this);
        Button mBtnInventoryStop = (Button) findViewById(R.id.btn_inventory_stop);
        mBtnInventoryStop.setOnClickListener(this);
        Button mBtnReadArea = (Button) findViewById(R.id.btn_read_area);
        mBtnReadArea.setOnClickListener(this);
        Button mBtnReadArea1 = (Button) findViewById(R.id.btn_read_area1);
        mBtnReadArea1.setOnClickListener(this);
        Button mBtnWriteArea1 = (Button) findViewById(R.id.btn_write_area1);
        mBtnWriteArea1.setOnClickListener(this);
        Button mBtnWriteArea = (Button) findViewById(R.id.btn_write_area);
        mBtnWriteArea.setOnClickListener(this);
        Button mBtnSelectCard = (Button) findViewById(R.id.btn_select_card);
        mBtnSelectCard.setOnClickListener(this);
        Button mBtnSetAntennaPower = (Button) findViewById(R.id.btn_set_antenna_power);
        mBtnSetAntennaPower.setOnClickListener(this);
        Button mBtnGetAntennaPower = (Button) findViewById(R.id.btn_get_antenna_power);
        mBtnGetAntennaPower.setOnClickListener(this);
        Button mBtnSetFreqRegion = (Button) findViewById(R.id.btn_set_freq_region);
        mBtnSetFreqRegion.setOnClickListener(this);
        Button mBtnGetFreqRegion = (Button) findViewById(R.id.btn_get_freq_region);
        mBtnGetFreqRegion.setOnClickListener(this);
        Button mBtnSetPassword = (Button) findViewById(R.id.btn_set_password);
        mBtnSetPassword.setOnClickListener(this);
        Button mBtnSetLock = (Button) findViewById(R.id.btn_set_lock);
        mBtnSetLock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int intResult = 0;
        String strResult = null;
        switch (v.getId()) {
            case R.id.btn_open_dev:
                intResult = mManager.openDev();
                break;

            case R.id.btn_close_dev:
                mManager.closeDev();
                break;
            case R.id.btn_inventory_start:
                mManager.inventoryStart();
                break;
            case R.id.btn_inventory_stop:
                mManager.inventoryStop();
                break;
            case R.id.btn_read_area:
                strResult = mManager.readArea(0, null, null, null);
                break;
            case R.id.btn_read_area1:
                strResult = Arrays.toString(mManager.readAreaByte(0, 0, 0, 0));
                break;
            case R.id.btn_write_area1:
                intResult = mManager.writeArea(0, null, null, null, null);
                break;
            case R.id.btn_write_area:
                intResult = mManager.writeAreaByte(0, 0, 0, null);
                break;
            case R.id.btn_select_card:
                intResult = mManager.selectCard(null);
                break;
            case R.id.btn_set_antenna_power:
                intResult = mManager.setAntennaPower(0);
                break;
            case R.id.btn_get_antenna_power:
                intResult = mManager.getAntennaPower();
                break;
            case R.id.btn_set_freq_region:
                intResult = mManager.setFreqRegion(0);
                break;
            case R.id.btn_get_freq_region:
                intResult = mManager.getFreqRegion();
                break;
            case R.id.btn_set_password:
                intResult = mManager.setPassword(0, null, null);
                break;
            case R.id.btn_set_lock:
                intResult = mManager.setLock(0, 0, 0);
                break;

        }
        if (intResult == 0) {
            Log.d(TAG, "success");
        }
        Log.d(TAG, strResult);
    }
}

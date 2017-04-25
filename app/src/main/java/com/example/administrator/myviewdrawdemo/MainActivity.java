package com.example.administrator.myviewdrawdemo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.administrator.myviewdrawdemo.R.id.sb_size;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_savesd)
    RadioButton mBtnSavesd;
    @BindView(R.id.btn_revoke)
    RadioButton mBtnRevoke;
    @BindView(R.id.btn_clean)
    RadioButton mBtnClean;
    @BindView(R.id.btn_picselect)
    RadioButton mBtnPicselect;
    @BindView(R.id.btn_drawcycle)
    RadioButton mBtnDrawcycle;
    @BindView(R.id.btn_drawrec)
    RadioButton mBtnDrawrec;
    @BindView(R.id.btn_line)
    RadioButton mBtnNull;
    @BindView(R.id.rg_drawgraphics)
    RadioGroup mRgDrawgraphics;
    @BindView(sb_size)
    SeekBar mSbSize;
    @BindView(R.id.iv_paintstyle)
    ImageView mIvPaintstyle;
    @BindView(R.id.ll_paint_style)
    LinearLayout mLlPaintStyle;
    @BindView(R.id.ll_paint_color)
    LinearLayout mLlPaintColor;
    @BindView(R.id.ll_paint_size)
    LinearLayout mLlPaintSize;
    @BindView(R.id.ll_bottom_boardstyle)
    LinearLayout mLlBottomBoardstyle;
    @BindView(R.id.myview)
    MyView mMyView;
    private boolean isshow = true;
    private int select_paint_color_index = 0;
    private int select_paint_style_index = 0;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);
        }

        ButterKnife.bind(this);
        mSbSize.setOnSeekBarChangeListener(new MySeekChangeListener());
    }


    class MySeekChangeListener implements SeekBar.OnSeekBarChangeListener{


        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mMyView.selectPaintSize(seekBar.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            mMyView.selectPaintSize(seekBar.getProgress());

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
    @OnClick({R.id.btn_savesd, R.id.btn_revoke, R.id.btn_clean, R.id.btn_picselect, R.id.btn_drawcycle, R.id.btn_drawrec, R.id.btn_line, R.id.ll_paint_style, R.id.ll_paint_color, R.id.ll_paint_size})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_savesd:
                Log.i("AAAAAAAAAAAA", "onClick:btn_savesd ");
                try {
                    mMyView.saveToSDCard();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_revoke:
                Log.i("AAAAAAAAAAAA", "onClick:btn_revoke ");

                mMyView.undo();
                break;
            case R.id.btn_clean:
                mMyView.redo();
                break;
            case R.id.btn_picselect:
                mMyView.recover();
                break;
            case R.id.btn_drawcycle:
                mMyView.drawCircle();
                break;
            case R.id.btn_drawrec:
                mMyView.drawrec();
                break;
            case R.id.btn_line:
                mMyView.drawline();
                break;
            case R.id.ll_paint_style:
                showMoreDialog(view);
                mSbSize.setVisibility(View.GONE);
                break;
            case R.id.ll_paint_color:
                showPaintColorDialog(view);
                mSbSize.setVisibility(View.GONE);
                break;
            case R.id.ll_paint_size:
                if(isshow) {
                    mSbSize.setVisibility(View.VISIBLE);
                    isshow = !isshow;
                }else{
                    mSbSize.setVisibility(View.GONE);
                    isshow = !isshow;
                }
                break;
        }
    }

    public void showPaintColorDialog(View parent){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("选择画笔颜色：");
        alertDialogBuilder.setSingleChoiceItems(R.array.paintcolor, select_paint_color_index, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                select_paint_color_index = which;
                mMyView.selectPaintColor(which);
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.create().show();
    }

    public void showMoreDialog(View parent){
        new AlertDialog.Builder(this).setTitle("选择画笔样式").setSingleChoiceItems(R.array.paintstyle, select_paint_style_index, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mMyView.selectPaintStyle(which);
                select_paint_style_index = which;
                dialog.dismiss();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();

    }

}

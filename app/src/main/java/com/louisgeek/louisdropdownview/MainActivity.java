package com.louisgeek.louisdropdownview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.louisgeek.dropdownviewlib.ClassfiySeletView;
import com.louisgeek.dropdownviewlib.DateSelectView;
import com.louisgeek.dropdownviewlib.DropDownView;
import com.louisgeek.dropdownviewlib.MultiSelectView;
import com.louisgeek.dropdownviewlib.MultiSelectView_HasChild;
import com.louisgeek.dropdownviewlib.ProCateSelectView;
import com.louisgeek.dropdownviewlib.ProvinceCityAreaSelectView;
import com.louisgeek.dropdownviewlib.javabean.MultiSelectHasChildBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    List<Map<String, Object>> mMultiSelectMapListOut;
  List<MultiSelectHasChildBean> mMultiSelectHasChildBeanList;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MultiSelectView_HasChild idmsvgac = (MultiSelectView_HasChild) findViewById(R.id.id_msv_gac);

        final ProCateSelectView idpcsv = (ProCateSelectView) findViewById(R.id.id_pcsv);
        final ProvinceCityAreaSelectView idpcasv = (ProvinceCityAreaSelectView) findViewById(R.id.id_pcasv);
        final DateSelectView iddsv = (DateSelectView) findViewById(R.id.id_dsv);
        final DropDownView idddv = (DropDownView) findViewById(R.id.id_ddv);
        initData();
       // initHasChildData();

        final MultiSelectView multiSelectView= (MultiSelectView) findViewById(R.id.id_msv);
        multiSelectView.setupMultiSelectMapListOutter(mMultiSelectMapListOut);

       /* final MultiSelectView_HasChild id_msv_gac= (MultiSelectView_HasChild) findViewById(R.id.id_msv_gac);
        Log.d("tag", "louis:1 onCreate: mMultiSelectHasChildBeanList:"+mMultiSelectHasChildBeanList);*/
       //### id_msv_gac.setupMultiSelectHasChildBeanListOutter(mMultiSelectHasChildBeanList);

      /*  final Button id_btn= (Button) findViewById(R.id.id_btn);
        id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_btn.setText(id_msv_gac.getSelectedKey());
            }
        });*/
        final ClassfiySeletView id_csv = (ClassfiySeletView) findViewById(R.id.id_csv);



        idpcasv.setOnClickListener(new ProvinceCityAreaSelectView.onViewClickListener() {
            @Override
            public void onClick(String provice, String proviceId, String city, String cityId, String area, String areaId) {
                Log.e(TAG, "onClick() called with: provice = [" + provice + "], proviceId = [" + proviceId + "], city = [" + city + "], cityId = [" + cityId + "], area = [" + area + "], areaId = [" + areaId + "]");
            }
        });

        Button id_btn= (Button) findViewById(R.id.id_btn);
        id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"=================DropDownView======================");
                Log.e(TAG, "onClick:getSelectKey "+idddv.getSelectKey());
                Log.e(TAG, "onClick: getSelectName"+idddv.getSelectName());
                Log.e(TAG,"=================DateSelectView======================");
                Log.e(TAG, "onClick: getNowSelectData"+iddsv.getNowSelectData());
                Log.e(TAG, "onClick: getNowSelectDataFixedNowData"+iddsv.getNowSelectDataFixedNowData());
                Log.e(TAG,"=================ProvinceCityAreaSelectView======================");
                Log.e(TAG, "onClick: getProvinceCityAreaKey"+idpcasv.getProvinceCityAreaKey());
                Log.e(TAG, "onClick: getProvinceCityAreaNameStr"+idpcasv.getProvinceCityAreaNameStr());
                Log.e(TAG, "onClick: getProvinceCityAreaNameStrWithOutFix"+idpcasv.getProvinceCityAreaNameStrWithOutFix());
                Log.e(TAG,"=================ProCateSelectView======================");
                Log.e(TAG, "onClick: getProCateKey"+idpcsv.getProCateKey());
                Log.e(TAG, "onClick: getProCateNameOnlyChild"+idpcsv.getProCateNameOnlyChild());
                Log.e(TAG, "onClick: getProCateKeyOnlyChildId"+idpcsv.getProCateKeyOnlyChildId());
                Log.e(TAG,"=================MultiSelectView======================");
                Log.e(TAG, "onClick: getSelectedKey"+multiSelectView.getSelectedKey());
                Log.e(TAG,"==================MultiSelectView_HasChild=====================");
                Log.e(TAG, "onClick: getSelectedKey"+idmsvgac.getSelectedKey());
                Log.e(TAG,"==================ClassfiySeletView=====================");
                Log.e(TAG, "onClick: getSelectedClassfiyKey"+id_csv.getSelectedClassfiyKey());
                Log.e(TAG, "onClick: getSelectedClassfiyKeyWithoutFix"+id_csv.getSelectedClassfiyKeyWithoutFix());
            }
        });


    }

    private void initData() {
        mMultiSelectMapListOut=new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("name", "name" + i);
            map.put("key", "key" + i);
            map.put("checked", false);
            mMultiSelectMapListOut.add(map);
        }
    }


}

package id.orzdevs.apps;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.orzdevs.apps.adapter.AdaptListData;
import id.orzdevs.apps.models.MData;

public class ActMain extends AppCompatActivity {

    private Activity actThis;

    private List<MData> DataList;
    private RecyclerView rvChecklist;

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        actThis = ActMain.this;

        rvChecklist = findViewById(R.id.rvChecklist);

        token = getIntent().getStringExtra("token").trim();

        DataList = new ArrayList<>();
        getDataChecklist();
    }

    private void getDataChecklist(){

        for (int i=0;i<10;i++){
            String data = "checklist "+i;
            DataList.add(new MData(data));
        }

        AdaptListData adapter = new AdaptListData(actThis, DataList);
        GridLayoutManager firstManager = new GridLayoutManager(actThis,1);
        firstManager.setOrientation(GridLayoutManager.VERTICAL);
        rvChecklist.setLayoutManager(firstManager);
        rvChecklist.setNestedScrollingEnabled(true); //smootscroll
        rvChecklist.setAdapter(adapter);
        rvChecklist.invalidate(); //smootscroll
    }
}
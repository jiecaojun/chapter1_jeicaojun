package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.io.InputStream;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        RecyclerView List = findViewById(R.id.rv_list);

        LinearLayoutManager LLManager = new LinearLayoutManager(this);
        LLManager.setOrientation(LinearLayoutManager.VERTICAL);
        List.setLayoutManager(LLManager);
        List.setHasFixedSize(true);
        List<Message> messages = null;


        try{
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
        } catch(Exception exception){
            exception.printStackTrace();
        }

        GreenAdapter mAdapter;
        mAdapter = new GreenAdapter(messages);
        List.setAdapter(mAdapter);
    }


}
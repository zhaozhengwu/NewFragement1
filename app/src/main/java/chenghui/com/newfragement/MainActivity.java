package chenghui.com.newfragement;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private TopFragement topFragement;
    private Button button;
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                topFragement=new TopFragement();
                Bundle bundle=new Bundle();
                bundle.putString("key","我是Activity发送的数据"+i);
                topFragement.setArguments(bundle);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.f1,topFragement);
                fragmentTransaction.addToBackStack("zhi");
                fragmentTransaction.commit();
            }
        });

    }
}

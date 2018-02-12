package com.example.admin.retrofitfresher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.retrofitfresher.data.model.Post;
import com.example.admin.retrofitfresher.data.remote.APIService;
import com.example.admin.retrofitfresher.data.remote.ApiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private APIService mAPIService = ApiUtils.getAPIService();

    @BindView(R.id.et_title)
    EditText titleEt;

    @BindView(R.id.et_body)
    EditText bodyEt;

    @BindView(R.id.btn_submit)
    Button submitBtn;

    @BindView(R.id.tv_response)
    TextView mResponseTv;




    @OnClick(R.id.btn_submit) void submit(){
        String title = bodyEt.getText().toString().trim();
        String body = bodyEt.getText().toString().trim();
        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)){
            sendPost(title, body);
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }



    // Method to post
    public void sendPost(String title, String body) {
        mAPIService.savePost(title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


//        mAPIService.savePost(title, body, 1).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//                if(response.isSuccessful()) {
//                    showResponse(response.body().toString());
//                    Log.i(TAG, "post submitted to API." + response.body().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                Log.e(TAG, "Unable to submit post to API.");
//            }
//        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}

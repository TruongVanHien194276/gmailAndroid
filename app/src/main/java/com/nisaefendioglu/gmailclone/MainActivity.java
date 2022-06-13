package com.nisaefendioglu.gmailclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView gmailListView;
    final ArrayList<MailList> mailList = new ArrayList<>();
    FloatingActionButton sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMessage = findViewById(R.id.sendMessage);
        sendMessage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(),SendMessage.class);
            startActivity(intent);
        });

        gmailListView = findViewById(R.id.gmailListView);

        mailList.add(new MailList("Truong Van Hien","MSSV: 20194276 - Address: Thai Binh","H",R.menu.circle));
        mailList.add(new MailList("Phong Dao Tao","Phòng Đào tạo thông tin tới các em về việc mở đăng ký tốt nghiệp Đợt 2021.2A theo Thông báo được đính kèm email này.\n" +
                "Thông báo cũng sẽ được đăng trên Cổng thông tin sinh viên tại địa chỉ: ctt.hust.edu.vn\n","P",R.menu.circle2));
        mailList.add(new MailList("Pham Duc Hao 20200200","Hao ngu - MSSV: 20200200 - Address: Nam Dinh","H",R.menu.circle3));
        mailList.add(new MailList("Luu Toan Thang 20173583","MSSV: 20173583 - Address: Hai Phong","T",R.menu.circle4));
        mailList.add(new MailList("Bui Thi Huong Tra 20215150","MSSV: 20215150 - Address: Bac Giang","T",R.menu.circle5));
        mailList.add(new MailList("Truong CNTT&TT","Xin chào Trương Văn Hiển,\n" +
                "Bạn đã đăng ký thành công nguyện vọng cho học phần IT4991 - Thực tập kỹ thuật","S",R.menu.circle));
        mailList.add(new MailList("Duong Minh Hieu 20176584","THƯ MỜI TÂN GIA","H",R.menu.circle2));
        mailList.add(new MailList("Phong CTCT","Cảm ơn bạn đã đăng ký tham gia Tọa đàm về Xây dựng, phát triển và tham gia các CLB/Tổ/ Đội/Nhóm của sinh viên - “BK Club Talk” kỳ 20212.","C",R.menu.circle3));

        MailAdapter mailAdapter = new MailAdapter(this, mailList);
        if (gmailListView != null) {
            gmailListView.setAdapter(mailAdapter);
        }

        gmailListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplication(),MailDetails.class);
            startActivity(intent);
        });

    }
}
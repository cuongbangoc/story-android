package code.example.storyandroid;

import java.util.ArrayList;
import java.util.Arrays;

import webserviceUTIL.Doctruyen;
import webserviceUTIL.Tienich;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView mainListView;
	private ArrayAdapter<String> listAdapter;
	GridView gridView;

	// Thay mảng bằng nội dung get về
	String[] array_text_listCategory = new String[] { "Android",
			"iOS", "Windows", "Blackberry" };
	String[] array_id_listCategory = new String[] { "1",
		"2", "3", "4" };
	String[] array_text_Label_story = new String[] { "Mercury", "Venus",
			"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
	String[] array_id_Label_story = new String[] { "1", "2",
			 "3" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Bắt sự kiện Login
	public void login(View view) {
		// this.setContentView(R.layout.signup_layout);

		// chuyển sang Danh sách thể laoị truyện
		if (checkLogin()) {
			setContentView(R.layout.grid_view_layout);
			gridView = (GridView) findViewById(R.id.gridView1);
			
			//Hiển thị danh sách truyện
			Tienich tienich = new Tienich();
			String listCate = tienich.getListCategory();
			
			//Cắt dữ liệu
			String[] s1 = listCate.split("#");
			array_text_listCategory = new String[s1.length];
			array_id_listCategory = new String[s1.length];
			for(int i = 0;i < s1.length;i++){
				//Fill dữ liệu lên danh sách
				String[] s2 = s1[i].split("_");
				array_id_listCategory[i] = s2[0];
				array_text_listCategory[i] = s2[1];
			}
			gridView.setAdapter(new ImageAdapter(this, array_text_listCategory));
			
			gridView.setOnItemClickListener(new OnItemClickListener() {

				// Bắt sự kiện chọn 1 thể loại truyện trong danh sách
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {

					// Toast.makeText(getApplicationContext(),((TextView)
					// v.findViewById(R.id.grid_item_label)).getText(),
					// Toast.LENGTH_SHORT).show();
					// chuyển sang danh sách truyện
					forwardListStory(array_id_listCategory[position],position);
				}
			});
		} else {
			Toast.makeText(getApplicationContext(),
					"Tên đăng nhập hoặc mật khẩu không chính xác",
					Toast.LENGTH_SHORT).show();
		}

	}

	// Chuyển sang trang đăng ký
	// Bắt sự kiện nút Signup trong trang đăng nhập
	public void forwardSignup(View view) {
		this.setContentView(R.layout.signup_layout);
		// forwardStoryContent();

	}

	public void forwardListStory(String idCate,int positionCateTitle) {
		setContentView(R.layout.list_story);

		// Find the ListView resource.
		mainListView = (ListView) findViewById(R.id.storyListView);

		// Create and populate a List of planet names.
		
		//Lấy dữ liệu từ web về
		Tienich tienich = new Tienich();
		String listStoryWeb = tienich.getListStory(idCate);
		
		//Cắt dữ liệu
		String[] s1 = listStoryWeb.split("#");
		array_text_Label_story = new String[s1.length];
		array_id_Label_story = new String[s1.length];
		for(int i = 0;i < s1.length;i++){
			//Fill dữ liệu lên danh sách
			String[] s2 = s1[i].split("_");
			array_id_Label_story[i] = s2[0];
			array_text_Label_story[i] = s2[1];
		}
		
		TextView titleCate = (TextView) findViewById(R.id.catestoryTitle);
		titleCate.setText(array_text_listCategory[positionCateTitle]);
		ArrayList<String> listStory = new ArrayList<String>();
		listStory.addAll(Arrays.asList(array_text_Label_story));

		// Create ArrayAdapter using the planet list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.row_list_story,
				listStory);

//		// Add thêm nếu muốn
//		listAdapter.add("Ceres");
//		listAdapter.add("Pluto");
//		listAdapter.add("Haumea");
//		listAdapter.add("Makemake");
//		listAdapter.add("Eris");

		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter(listAdapter);

		// Bắt sự kiện chọn 1 truyện trong danh sách
		mainListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parrent, View v,
					int position, long id) {
				// TODO Auto-generated method stub

				// Thay content này bằng nội dung Get về
				
				forwardStoryContent(array_id_Label_story[position]);
			}
		});
	}

	public void forwardStoryContent(String id) {

		setContentView(R.layout.story_content);
		
		//Lấy dữ liệu về xử lý
		Tienich tienich = new Tienich();
		String storyWeb = tienich.getStory(id);
		
		//Tách dữ liệu
		String[] ss = storyWeb.split("_");
		TextView tieudeTruyen = (TextView) findViewById(R.id.storyTitle);
		tieudeTruyen.setText(ss[0]);
		Doctruyen doctruyen = new Doctruyen(storyWeb);
		doctruyen.doc();
		TextView textview = (TextView) findViewById(R.id.storyContent);
		textview.setText(ss[1]);
	}

	

	// Kiểm tra đăng nhập
	public boolean checkLogin() {
		EditText username = (EditText) findViewById(R.id.username);
		EditText password = (EditText) findViewById(R.id.password);
		Tienich t = new Tienich();
		Boolean result = t.checkLogin(username.getText().toString(), password
				.getText().toString());

		if (result)
			return true;
		else
			return false;
	}
	
	// Bắt sựu kiện nút Back trong form đăng ký
		public void comebackLogin(View view) {
			setContentView(R.layout.login_layout);
		}
		//Bắt sư kiện nút back form đọc truyện
	public void comebackListStory(View view) {
		setContentView(R.layout.list_story);
	}
	
	//Bắt sự kiện nút back form list Story
	public void comebackListCategory(View view) {
		setContentView(R.layout.grid_view_layout);
	}
}

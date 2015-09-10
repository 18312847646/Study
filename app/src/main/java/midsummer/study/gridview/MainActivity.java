package midsummer.study.gridview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.gridview_main)
public class MainActivity extends InitializeView implements AdapterView.OnItemClickListener
{
	@ViewById
	GridView gridView;
	
	private List<Map<String, Object>> dataList;
	private int[] icon = {R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock, R.drawable.games_control, R.drawable.messenger, R.drawable.ringtone, R.drawable.settings, R.drawable.speech_balloon, R.drawable.weather, R.drawable.world, R.drawable.youtube};
	private String[] iconName = {"通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置", "语音", "天气", "浏览器", "视频"};
	private SimpleAdapter adapter;
	
	@AfterViews
	public void MainActivity()
	{
		initializeview();
		// 1. 准备数据源
		// 2. 新建适配器（SimpleAdapter）
		// 3. GridView加载适配器
		// 4. GridView配置事件监听器（OnItemClickListener）
		dataList = new ArrayList<Map<String, Object>>();
		adapter = new SimpleAdapter(this, getData(), R.layout.gridview_item, new String[]{"image", "text"}, new int[]{R.id.image, R.id.text});
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}
	
	private List<Map<String, Object>> getData()
	{
		for (int i = 0; i < icon.length; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			dataList.add(map);
		}
		return dataList;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		ShowToast("我是" + iconName[position]);
	}
}

package midsummer.study.listview;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.listview_main)
public class MainActivity extends InitializeView implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener
{
	@ViewById
	ListView listview;
	private ArrayAdapter<String> array_adapter;
	private SimpleAdapter simple_adapter;
	private List<Map<String, Object>> dataList;

	@AfterViews
	public void MainActivity()
	{
		initializeview();

		// 1. 新建一个数据适配器
		// ArrayAdapter(上下文，当前ListView加载的每一个列表所对应的布局文件,数据源)
		// SimpleAdapter（Context context, List<? extends Map<String, ?>> data,int resource, String[] from, int[] to）
		/**
		 * context：上下文
		 * data：数据源（List<? extends Map<String,?>> data）一个Map所组成的List集合
		 * 		 每一个Map都会去对应ListView列表中的一行
		 * 		 每一个Map（键-值对）中的键必须包含所有在from中所指定的键
		 * resource：列表项的布局文件ID
		 * from：Map中的键名
		 * to：绑定数据视图中的ID，与from成对应关系
		 */
		// 2. 适配器加载数据源
		String[] array_data = {"aaa" , "bbb" , "ccc" , "ddd"};
		dataList = new ArrayList<Map<String, Object>>();
		array_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_data);
		simple_adapter = new SimpleAdapter(this, getData(), R.layout.listview_item, new String[]{"image" , "text"}, new int[]{R.id.image , R.id.text});
		// 3. 视图加载适配器
		// 两种适配器
		// listview.setAdapter(array_adapter);
		listview.setAdapter(simple_adapter);

		// 点击事件
		listview.setOnItemClickListener(this);
		listview.setOnScrollListener(this);
	}

	/**
	 * 数据源
	 *
	 * @return
	 */
	private List<Map<String, Object>> getData()
	{
		for(int i = 0; i < 30; i++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", R.mipmap.ic_launcher);
			map.put("text", "77." + i);
			dataList.add(map);
		}
		return dataList;
	}

	/**
	 * Item单击事件
	 *
	 * @param parent
	 * @param view
	 * @param position
	 * @param id
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		String text = listview.getItemAtPosition(position) + "";
		Toast.makeText(this, "position=" + position + "text=" + text, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Item滑动事件
	 *
	 * @param view
	 * @param scrollState
	 */
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState)
	{
		switch(scrollState)
		{
			case SCROLL_STATE_FLING:
				Log.i("77.", "手指离开屏幕前用力划了一下，视图仍依靠惯性继续滑动");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("image", R.mipmap.ic_launcher);
				map.put("text", "新增");
				dataList.add(map);
				// 重新通知UI线程刷新界面
				simple_adapter.notifyDataSetChanged();
				break;
			case SCROLL_STATE_IDLE:
				Log.i("77.", "视图已经停止滑动");
				break;
			case SCROLL_STATE_TOUCH_SCROLL:
				Log.i("77.", "手指没有离开屏幕，视图正在滑动");
				break;
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
	{

	}
}

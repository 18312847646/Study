package midsummer.study.spinner;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.spinner_main)
public class MainActivity extends InitializeView implements AdapterView.OnItemSelectedListener
{
	@ViewById
	TextView textView;
	@ViewById
	Spinner spinner;
	
	private List<String> list;
	private ArrayAdapter<String> adapter;
	
	@AfterViews
	public void MainActivity()
	{
		initializeview();
		
		textView.setText("选择的城市是北京");
		// 1. 设置数据源
		list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		
		// 2. 新建ArrayAdapter（数组适配器）
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		
		// 3. adapter设置一个下拉列表样式
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		// 4. spinner加载适配器
		spinner.setAdapter(adapter);
		
		// 5. spinner设置监听器
		spinner.setOnItemSelectedListener(this);
	}
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{
		String cityName = adapter.getItem(position);
		//String cityName=list.get(position );
		
		textView.setText("选择的城市是" + cityName);
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
		
	}
}

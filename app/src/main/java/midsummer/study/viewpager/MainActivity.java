package midsummer.study.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.viewpager_main)
public class MainActivity extends InitializeView implements ViewPager.OnPageChangeListener
{
	@ViewById
	TextView textView;
	@ViewById
	ViewPager pager;
	@ViewById
	PagerTabStrip tab;
	private List<View> viewList;
	private List<String> titliList;
	
	private List<Fragment> fragmentList;
	
	@AfterViews
	public void MainActivity()
	{
		initializeview();
		
		viewList = new ArrayList<View>();
		/**
		 * 通过View对象去作为ViewPager的数据源
		 */
		View view1 = View.inflate(this, R.layout.asynctask_main, null);
		View view2 = View.inflate(this, R.layout.gridview_main, null);
		View view3 = View.inflate(this, R.layout.listview_main, null);
		View view4 = View.inflate(this, R.layout.picker_main, null);
		View view5 = View.inflate(this, R.layout.progressbar_main, null);
		View view6 = View.inflate(this, R.layout.spinner_main, null);
		View view7 = View.inflate(this, R.layout.webview_main, null);
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		viewList.add(view5);
		viewList.add(view6);
		viewList.add(view7);
		
		/**
		 * 通过Fragment作为ViewPager的数据源
		 */
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new MyFragment0());
		fragmentList.add(new MyFragment1());
		fragmentList.add(new MyFragment2());
		fragmentList.add(new MyFragment3());
		
		// 位ViewPager页卡设置标题
		titliList = new ArrayList<String>();
		titliList.add(getString(R.string.AsyncTask));
		titliList.add(getString(R.string.gridView));
		titliList.add(getString(R.string.listview));
		titliList.add(getString(R.string.picker));
		titliList.add(getString(R.string.progressBar));
		titliList.add(getString(R.string.spinner));
		titliList.add(getString(R.string.webView));
		
		// 为PagerTabStrip设置一些属性
		tab.setDrawFullUnderline(false);
		
		// 创建PagerAdapter的适配器
		MyPagerAdapter adapter = new MyPagerAdapter(viewList, titliList);
		// ViewPager加载适配器
		//pager.setAdapter(adapter);
		
		MyFragmentPagerAdapter adapter1 = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, titliList);
		//pager.setAdapter(adapter1);
		
		MyFragmentPagerAdapter1 adapter2 = new MyFragmentPagerAdapter1(getSupportFragmentManager(), fragmentList, titliList);
		pager.setAdapter(adapter2);
		pager.setOnPageChangeListener(this);
	}
	
	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
	{
		
	}
	
	@Override
	public void onPageSelected(int position)
	{
		ShowToast("当前第" + position + "页");
	}
	
	@Override
	public void onPageScrollStateChanged(int state)
	{
	}
}

package midsummer.study;

import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.main)
public class MainActivity extends InitializeView
{
	@AfterViews
	public void mainActivity()
	{
		initializeview();
	}
	
	@Click({R.id.listview, R.id.picker, R.id.asynctask, R.id.gridView, R.id.spinner, R.id.progressBar, R.id.webView, R.id.viewpager, R.id.flipper})
	public void button(View view)
	{
		switch (view.getId())
		{
			// 添加按钮要记得在上面加上id
			case R.id.listview:
				OpenActivity(midsummer.study.listview.MainActivity_.class);
				break;
			case R.id.picker:
				OpenActivity(midsummer.study.picker.MainActivity_.class);
				break;
			case R.id.gridView:
				OpenActivity(midsummer.study.gridview.MainActivity_.class);
				break;
			case R.id.spinner:
				OpenActivity(midsummer.study.spinner.MainActivity_.class);
				break;
			case R.id.progressBar:
				OpenActivity(midsummer.study.progressbar.MainActivity_.class);
				break;
			case R.id.asynctask:
				OpenActivity(midsummer.study.asynctask.MainActivity_.class);
				break;
			case R.id.webView:
				OpenActivity(midsummer.study.webview.MainActivity_.class);
				break;
			case R.id.viewpager:
				OpenActivity(midsummer.study.viewpager.MainActivity_.class);
				break;
			case R.id.flipper:
				OpenActivity(midsummer.study.viewflipper.MainActivity_.class);
				break;
		}
	}
}

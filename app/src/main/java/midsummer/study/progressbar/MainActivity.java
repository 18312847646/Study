package midsummer.study.progressbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.progressbar_main)
public class MainActivity extends InitializeView
{
	@ViewById
	TextView text;
	@ViewById
	ProgressBar progressBar;
	@ViewById
	Button add, reduce, reset, show;
	
	private ProgressDialog progressDialog;
	
	@AfterViews
	public void MainActivity()
	{
		initializeview();
		
		// 获取第一进度
		int first = progressBar.getProgress();
		// 获取第二进度
		int second = progressBar.getSecondaryProgress();
		// 获取最大进度
		int max = progressBar.getMax();
		text.setText("第一进度：" + (int) (first / (float) max * 100) + "% 第二进度：" + (int) (second / (float) max * 100) + "%");
	}
	
	@Click({R.id.add, R.id.reduce, R.id.reset, R.id.show})
	public void click(View view)
	{
		switch (view.getId())
		{
			case R.id.add:
				// 增加第一进度和第二进度10个刻度
				progressBar.incrementProgressBy(10);
				progressBar.incrementSecondaryProgressBy(10);
				break;
			case R.id.reduce:
				// 减少第一进度和第二进度10个刻度
				progressBar.incrementProgressBy(-10);
				progressBar.incrementSecondaryProgressBy(-10);
				break;
			case R.id.reset:
				// 重置为默认值
				progressBar.setProgress(50);
				progressBar.setSecondaryProgress(80);
				break;
			case R.id.show:
				/**
				 * 页面显示风格
				 */
				// 新建ProgressDialog对象
				progressDialog = new ProgressDialog(MainActivity.this);
				// 设置显示风格
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				// 设置标题
				progressDialog.setTitle("下载中");
				// 设置对话框文字信息
				progressDialog.setMessage("正在下载");
				// 设置图标
				progressDialog.setIcon(R.mipmap.ic_launcher);
				
				/**
				 * 设置ProgressBar的属性
				 */
				// 设置最大进度
				progressDialog.setMax(100);
				// 设定初始化的进度
				progressDialog.incrementProgressBy(50);
				// 进度条是明确显示进度
				progressDialog.setIndeterminate(false);
				
				/**
				 * 设置一个确定按钮
				 */
				progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						ShowToast("正在下载");
					}
				});
				// 是否可以通过返回按钮退出对话框
				progressDialog.setCancelable(true);
				// 显示ProgressDialog
				progressDialog.show();
				break;
		}
		text.setText("第一进度：" + (int) (progressBar.getProgress() / (float) progressBar.getMax() * 100) + "% 第二进度：" + (int) (progressBar.getSecondaryProgress() / (float) progressBar.getMax() * 100) + "%");
	}
}
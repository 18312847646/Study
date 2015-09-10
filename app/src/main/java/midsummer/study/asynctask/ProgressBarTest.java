package midsummer.study.asynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.asynctask_progressbar)
public class ProgressBarTest extends InitializeView
{
	@ViewById
	ProgressBar progressBar;
	
	private MyAsyncTask mTask;
	
	@AfterViews
	protected void ProgressBarTest()
	{
		initializeview();
		mTask = new MyAsyncTask();
		// 启动异步任务
		mTask.execute();
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		//不为空且running
		if (mTask != null || mTask.getStatus() == AsyncTask.Status.RUNNING)
		{
			//cancel只是将对应的AsyncTask标记为cancel，并不是真正的取消线程的执行
			mTask.cancel(true);
		}
	}
	
	class MyAsyncTask extends AsyncTask<Void, Integer, Void>
	{
		@Override
		protected void onPostExecute(Void result)
		{
			super.onPostExecute(result);
			startActivity(new Intent(ProgressBarTest.this, ImageTest_.class));
			ProgressBarTest.this.finish();
		}
		
		@Override
		protected Void doInBackground(Void... params)
		{
			//模拟进度更新
			for (int i = 0; i < 100; i++)
			{
				if (isCancelled())
				{
					break;
				}
				publishProgress(i);
				try
				{
					Thread.sleep(20);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Integer... values)
		{
			//获取进度条更新值
			super.onProgressUpdate(values);
			if (isCancelled())
			{
				return;
			}
			progressBar.setProgress(values[0]);
		}
	}
}

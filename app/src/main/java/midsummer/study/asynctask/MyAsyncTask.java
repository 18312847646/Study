package midsummer.study.asynctask;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void>
{
	// 第二执行
	@Override
	protected Void doInBackground(Void... params)
	{
		Log.i("77", "doInBackground");
		//传入进度值
		publishProgress();
		return null;
	}

	// 最先执行
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		Log.i("77", "onPreExecute");
	}

	//第三执行
	@Override
	protected void onPostExecute(Void aView)
	{
		super.onPostExecute(aView);
		Log.i("77", "onPostExecute");
	}

	//获取进度，更新进度条
	@Override
	protected void onProgressUpdate(Void... values)
	{
		super.onProgressUpdate(values);
		Log.i("77", "onProgressUpdate");
	}
}

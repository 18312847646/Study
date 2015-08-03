package midsummer.study.asynctask;

import android.content.Intent;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.asynctask_main)
public class MainActivity extends InitializeView
{
	@AfterViews
	public void MainActivity()
	{
		initializeview();
		MyAsyncTask task = new MyAsyncTask();
		task.execute();
	}


	@Click({R.id.asynctask_internet_pictures , R.id.asynctask_schedule_spdate})
	public void button(View view)
	{
		switch(view.getId())
		{
			case R.id.asynctask_internet_pictures:
				startActivity(new Intent(this, ImageTest_.class));
				break;
			case R.id.asynctask_schedule_spdate:
				startActivity(new Intent(this, ProgressBarTest_.class));
				break;
		}
	}
}

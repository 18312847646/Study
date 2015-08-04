package midsummer.study;

import android.content.Intent;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.main)
public class MainActivity extends InitializeView
{
	@AfterViews
	public void MainActivity()
	{
		initializeview();
	}

	@Click({R.id.asynctask , R.id.listview})
	public void button(View view)
	{
		switch(view.getId())
		{
			case R.id.asynctask:
				startActivity(new Intent(this, midsummer.study.asynctask.MainActivity_.class));
				break;
			case R.id.listview:
				startActivity(new Intent(this, midsummer.study.listview.MainActivity_.class));
				break;
		}
	}


}

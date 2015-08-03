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

	@Click(R.id.asynctask)
	public void button(View view)
	{
		startActivity(new Intent(this, midsummer.study.asynctask.MainActivity_.class));
	}


}

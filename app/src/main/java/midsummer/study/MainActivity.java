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

    @Click({R.id.listview, R.id.picker, R.id.asynctask, R.id.gridView, R.id.spinner})
    public void button(View view)
    {
        switch (view.getId())
        {
            // 添加按钮要记得在上面加上id
            case R.id.listview:
                startActivity(new Intent(this, midsummer.study.listview.MainActivity_.class));
                break;
            case R.id.picker:
                startActivity(new Intent(this, midsummer.study.picker.MainActivity_.class));
                break;
            case R.id.asynctask:
                startActivity(new Intent(this, midsummer.study.asynctask.MainActivity_.class));
                break;
            case R.id.gridView:
                startActivity(new Intent(this, midsummer.study.gridview.MainActivity_.class));
                break;
            case R.id.spinner:
                startActivity(new Intent(this, midsummer.study.spinner.MainActivity_.class));
                break;
        }
    }
}

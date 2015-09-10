package midsummer.study.picker;

import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Calendar;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.picker_main)
public class MainActivity extends InitializeView
{
	@ViewById
	TimePicker timePicker;
	@ViewById
	DatePicker datePicker;
	
	private Calendar cal;
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	@AfterViews
	public void MainActivity()
	{
		initializeview();
		// 获取日历的一个对象
		cal = Calendar.getInstance();
		// 获取年月日时分秒的信息
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		setTitle(year + "-" + month + "-" + day + "  " + hour + ":" + minute);
		
		// datePicker
		datePicker.init(year, cal.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener()
		{
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
			{
				setTitle(year + "-" + (monthOfYear) + 1 + "-" + dayOfMonth);
			}
		});
		
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener()
		{
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
			{
				setTitle(hourOfDay + ":" + minute);
			}
		});

/*        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
		{
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                setTitle(year + "-" + (monthOfYear) + 1 + "-" + dayOfMonth);
            }
        }, year, cal.get(Calendar.MONTH), day).show();
*/
		
		new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener()
		{
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute)
			{
				setTitle(hourOfDay + ":" + minute);
			}
		}, hour, minute, true).show();
	}
}

package midsummer.study.viewflipper;

import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.viewflipper_main)
public class MainActivity extends InitializeView
{
	@ViewById
	ViewFlipper flipper;
	private float startX;

	private int[] resId = {R.drawable.address_book, R.drawable.calendar, R.drawable.camera, R.drawable.clock, R.drawable.games_control,};

	@AfterViews
	public void MainActivity()
	{
		initializeview();
		
		for (int i = 0; i < resId.length; i++)
		{
			flipper.addView(getImageView(resId[i]));
		}

		// 为ViewFlipper添加动画效果
/*		flipper.setInAnimation(this,R.anim.abc_fade_in);
		flipper.setOutAnimation(this,R.anim.abc_fade_out);
		// 设置ViewFlipper视图切换的时间间隔
		flipper.setFlipInterval(5000);
		// 开始播放
		flipper.startFlipping();*/
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		switch (event.getAction())
		{
			// 手指落下
			case MotionEvent.ACTION_DOWN:
				startX = event.getX();
				break;
			// 手指滑动
			case MotionEvent.ACTION_MOVE:
				// 向右滑动看前一页
				if (event.getX() - startX > 50)
				{
					flipper.setInAnimation(this, R.anim.abc_fade_in);
					flipper.setOutAnimation(this, R.anim.abc_fade_out);
					// 显示前一页
					flipper.showPrevious();
				}
				// 向左滑动看后一页
				if (startX - event.getX() > 50)
				{
					flipper.setInAnimation(this, R.anim.abc_fade_in);
					flipper.setOutAnimation(this, R.anim.abc_fade_out);
					// 显示后一页
					flipper.showPrevious();
				}
				break;
			// 手指离开
			case MotionEvent.ACTION_UP:
				break;
		}
		return super.onTouchEvent(event);
	}

	private ImageView getImageView(int resId)
	{
		ImageView image = new ImageView(this);
		//image.setImageResource(resId);
		image.setBackgroundResource(resId);
		return image;
	}
}

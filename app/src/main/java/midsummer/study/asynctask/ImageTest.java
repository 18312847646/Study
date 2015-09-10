package midsummer.study.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import midsummer.study.R;

/**
 * 执行顺序：
 * <p/>
 * new MyAsyncTask().execute(URL):传递一个或多个参数进去
 * onPreExecute(): 初始化操作
 * doInBackground(String... params): 开始真正的异步处理，最后返回指定类型
 * onPostExecute(Bitmap bitmap): 获取所返回的结果
 */

/**
 * onPreExecute:加载进度条
 * doInBackground:下载网络数据
 * onPostExecute:显示图片
 */
@EActivity(R.layout.asynctask_image)
public class ImageTest extends AppCompatActivity
{
	private static String URL = "http://www.vivalaplay.com/wp-content/uploads/2014/08/acu_arno_elise_artwork_kybx2.jpg";
	@ViewById
	ImageView image;
	@ViewById
	ProgressBar progressbar;
	
	@AfterViews
	protected void ImageTest()
	{
		//设置传递进入的参数
		new MyAsyncTask().execute(URL);
	}
	
	/**
	 * <URL类型，进度值类型，返回值类型>
	 */
	class MyAsyncTask extends AsyncTask<String, Void, Bitmap>
	{
		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			//显示ProgressBar
			progressbar.setVisibility(View.VISIBLE);
		}
		
		/**
		 * 操作UI
		 * 设置图像
		 */
		@Override
		protected void onPostExecute(Bitmap bitmap)
		{
			super.onPostExecute(bitmap);
			// 隐藏ProgressBar
			progressbar.setVisibility(View.GONE);
			image.setImageBitmap(bitmap);
		}
		
		/**
		 * String... params可变长数组
		 * 可传递不止一个参数
		 */
		@Override
		protected Bitmap doInBackground(String... params)
		{
			//1.获取传递进来的参数
			//取出对应URL
			String url = params[0];
			Bitmap bitmap = null;
			//定义网络连接对象
			URLConnection connection;
			//用于获取数据的输入流
			InputStream is;
			try
			{
				//2.网络操作
				//获取网络连接对象
				connection = new URL(url).openConnection();
				//获取输入流
				is = connection.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				//人为睡眠3秒钟
				//Thread.sleep(500);
				//通过decodeStream将输入流解析成bitmap
				bitmap = BitmapFactory.decodeStream(bis);
				//关闭输入流
				is.close();
				bis.close();
			} catch (MalformedURLException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
/*			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
*/
			//将bitmap作为返回值
			return bitmap;
		}
	}
}

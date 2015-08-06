package midsummer.study.webview;

import android.app.ProgressDialog;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import midsummer.study.InitializeView;
import midsummer.study.R;

@EActivity(R.layout.webview_main)
public class MainActivity extends InitializeView
{
	@ViewById
	WebView webView;

	private ProgressDialog dialog;

	@AfterViews
	public void MainActivity()
	{
		initializeview();

		// 本地资源
		//webView.loadUrl("file:///android_asset/baidu.html");
		//Web资源
		webView.loadUrl("http://www.baidu.com");

		// 覆盖WebView默认通过第三方或者是系统浏览器打开网页的行为，使得网页在WebView中打开
		// WebViewClient帮助WebView去处理一些页面控制和请求通知
		webView.setWebViewClient(new WebViewClient()
		{
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				// 返回值是true的时候控制网页在WebView中打开
				// 如果是false调用系统浏览器或者第三方浏览器
				view.loadUrl(url);
				// return super.shouldOverrideUrlLoading(view,url);
				return true;
			}
		});

		// 启用支持JavaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		// WebView加载页面优先使用缓存加载
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

		webView.setWebChromeClient(new WebChromeClient()
		{
			@Override
			public void onProgressChanged(WebView view, int newProgress)
			{
				// newProgress 1-100之间的整数
				if (newProgress == 100)
				{
					//页面加载完毕，关闭ProgressDialog
					closeDialog();
				} else
				{
					// 网页正在加载，打开ProgressDialog
					openDialog(newProgress);
				}
			}

			private void closeDialog()
			{
				if (dialog != null && dialog.isShowing())
				{
					dialog.dismiss();
					dialog = null;
				}
			}

			private void openDialog(int newProgress)
			{
				if (dialog == null)
				{
					dialog = new ProgressDialog(MainActivity.this);
					dialog.setTitle("正在加载");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
				} else
				{
					dialog.setProgress(newProgress);
				}
			}
		});
	}

	// 改写物理按键--返回的逻辑
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			// Log.i("77.",webView.getUrl());
			if (webView.canGoBack())
			{
				//返回上一页
				webView.goBack();
				return true;
			} else
			{
				//退出程序
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
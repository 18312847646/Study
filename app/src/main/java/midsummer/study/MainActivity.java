package midsummer.study;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
{
	// 初始化toolbar
	@ViewById
	Toolbar toolbar;
	// 初始化侧边栏
	@ViewById
	DrawerLayout drawer;
	// 初始化版本号
	@ViewById
	TextView version;
	// 初始化开发者
	@ViewById
	TextView developer;
	// 初始化群
	@ViewById
	TextView group;
	// 初始化源码
	@ViewById
	TextView github;

	@AfterViews
	public void UI()
	{
		setSupportActionBar(toolbar);
		// 打开 up button
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// 当做 drawer toggle 放入 toolbar
		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
		drawerToggle.syncState();
		drawer.setDrawerListener(drawerToggle);
		initialization();
	}

	@Background
	public void initialization()
	{
		// 设置关于页的版本号
		version.setText(getVersion());

		// 显示文字并设置链接
		// 创建一个 SpannableString对象
		SpannableString qq = new SpannableString("\u4F5C\u8005\u0051\u0051\uFF1A\u0039\u0035\u0031\u0032\u0030\u0033\u0035\u0039\u0038");
		// 设置超链接
		qq.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=jzWp1dTM-vhFloHOeO6-6kyLAovJsfSA"), 5, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// SpannableString对象设置给TextView
		developer.setText(qq);
		// 设置TextView可点击
		developer.setMovementMethod(LinkMovementMethod.getInstance());

		// 显示文字并设置链接
		// 创建一个 SpannableString对象
		SpannableString q = new SpannableString("\u0051\u0051\u53CD\u9988\u7FA4\uFF1A\u0032\u0034\u0037\u0037\u0030\u0038\u0030\u0037\u0038");
		// 设置超链接
		q.setSpan(new URLSpan("http://qm.qq.com/cgi-bin/qm/qr?k=Oi8I9tFyxfvyOugCzIAfLotzC0GZBTIf"), 6, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// SpannableString对象设置给TextView
		group.setText(q);
		// 设置TextView可点击
		group.setMovementMethod(LinkMovementMethod.getInstance());

		// 显示文字并设置链接
		// 创建一个 SpannableString对象
		SpannableString git = new SpannableString("\u83B7\u5F97\u6E90\u7801\uFF1A\u0053\u0074\u0075\u0064\u0079");
		// 设置超链接
		git.setSpan(new URLSpan("https://github.com/18312847646/Study.git"), 5, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// SpannableString对象设置给TextView
		github.setText(git);
		// 设置TextView可点击
		github.setMovementMethod(LinkMovementMethod.getInstance());
	}

	// 获得版本号
	private String getVersion()
	{
		try
		{
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			String version = info.versionName;
			return this.getString(R.string.version) + version;
		} catch(Exception e)
		{
			e.printStackTrace();
			return this.getString(R.string.version);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();

		if(id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

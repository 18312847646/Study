package midsummer.study.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class MyFragmentPagerAdapter1 extends FragmentStatePagerAdapter
{
	private List<Fragment> fragmentList;
	private List<String> titleList;

	public MyFragmentPagerAdapter1(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList)
	{
		super(fm);
		this.fragmentList = fragmentList;
		this.titleList = titleList;
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return titleList.get(position);
	}

	@Override
	public Fragment getItem(int position)
	{
		return fragmentList.get(position);
	}

	@Override
	public int getCount()
	{
		return fragmentList.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position)
	{
		return super.instantiateItem(container, position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object)
	{
		super.destroyItem(container, position, object);
	}
}

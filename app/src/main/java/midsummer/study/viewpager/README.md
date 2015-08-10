#Study

##Personal learning materials

###平时学习记录的资料，仅供学习交流之用
* 学习者：[  77.](http://wpa.qq.com/msgrd?v=3&uin=951203598&site=qq&menu=yes "点击这里联系作者")<br>
* 学习群：[King、技术交流群](http://shang.qq.com/wpa/qunwpa?idkey=a1488cba8fc51aaa456a82105afafa34276957bd41337abcd0e593a098d9c56a "点击加群")<br>

####ViewPager学习笔记：

#####加载显示的页卡
* 将layout布局转换成view对象<br>
>(1)LayoutInflater lf = getLayoutInflater().from(this);<br>
>(2)View.inflate(content,resource,root);<br>

#####配置Adapter
* PagerAdapter 数据源：List<View>
* FragmentPagerAdapter 数据源：List<Fragment>
* FragmentStatePagerAdapter 数据源：List<Fragment>

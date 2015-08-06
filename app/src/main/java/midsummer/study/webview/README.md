#Study

##Personal learning materials

###平时学习记录的资料，仅供学习交流之用
* 学习者：[  77.](http://wpa.qq.com/msgrd?v=3&uin=951203598&site=qq&menu=yes "点击这里联系作者")<br>
* 学习群：[King、技术交流群](http://shang.qq.com/wpa/qunwpa?idkey=a1488cba8fc51aaa456a82105afafa34276957bd41337abcd0e593a098d9c56a "点击加群")<br>

####WebView学习笔记：

#####在WebView中使用JavaScript
* 如果想要在加载到WebView中的Web页面使用JavaScript，需要在WebView中启用JavaScript。
* 启用JavaScript可以通过WebView中带有的WebSettings来启用它。
* 通过getSettings()来获取WebSettings的值，然后通过setJavaScriptEnabled()来启用JavaScript。

#####后退与前进
* 当你的WebView覆盖了URL加载，它会自动生成历史访问记录。
* 你可以通过goBack()或goForward()向前或向后访问已访问过的站点。

#####判断页面加载过程
* 由于有些网页可能加载缓慢，所以我们需要去判断页面的加载过程，制作进度条给予用户良好的体验效果。
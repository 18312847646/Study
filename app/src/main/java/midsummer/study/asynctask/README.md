#Study

##Personal learning materials

###平时学习记录的资料，仅供学习交流之用
* 学习者：[  77.](http://wpa.qq.com/msgrd?v=3&uin=951203598&site=qq&menu=yes "点击这里联系作者")<br>
* 学习群：[King、技术交流群](http://shang.qq.com/wpa/qunwpa?idkey=a1488cba8fc51aaa456a82105afafa34276957bd41337abcd0e593a098d9c56a "点击加群")<br>

####AsyncTask学习笔记：

#####构建AsyncTask子类的参数
* AsyncTask<Params,Progress,Result>是一个抽象类，通常用于被继承
* 继承AsyncTask需要指定如下三个泛型参数

>Params：启动任务时输入参数的类型<br>
>Progress：后台任务执行中返回进度值的类型<br>
>Result：后台执行任务完成后返回结果的类型<br>

#####构建AsyncTask子类的回调方法
* doInBackground：必须重写，异步执行后台线程将要完成的任务
* onPreExecute：执行后台耗时操作前被调用，通常完成一些初始化操作
* onPostExecute：当doInBackground()完成后，系统会自动调用onPostExecute()方法，并将doInBackground方法返回的值传递给该方法
* onProgressUpdate：在doInBackground()方法中调用publishProgress()方法更新任务的执行进度后，就会触发该方法

#####AsyncTask运行顺序
* onPreExecute
* 　　　↓
* doInBackground
* 　　　↓
* onProgressUpdate
* 　　　↓
* onPostExecute

#####AsyncTask注意事项
* 必须在UI线程中创建AsyncTask的实例
* 必须在UI线程中调用AsyncTask的execute()方法
* 重写的四个方法是系统自动调用的，不应手动调用
* 每个AsyncTask只能被执行一次，多次调用将会引发异常
* 只有doInBackground运行在其他线程，其他的方法运行在主线程
* 其他方法可以去更新UI，唯一doInBackground需要做异步处理
* 不能在doInBackground更新UI

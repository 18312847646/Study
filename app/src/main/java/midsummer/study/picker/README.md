#Study

##Personal learning materials

###平时学习记录的资料，仅供学习交流之用
* 学习者：[  77.](http://wpa.qq.com/msgrd?v=3&uin=951203598&site=qq&menu=yes "点击这里联系作者")<br>
* 学习群：[King、技术交流群](http://shang.qq.com/wpa/qunwpa?idkey=a1488cba8fc51aaa456a82105afafa34276957bd41337abcd0e593a098d9c56a "点击加群")<br>

####Picker学习笔记：

#####选择器（Picker）
* OnDateChangedListener
>当用户更改了DatePicker里的年、月、日时，将触发OnDateChangedListener监听器的OnDateChanged()事件
* OnTimeChangedListener
>当用户更改了TimePicker里的时、分时，将触发OnTimeChangedListener监听器的OnTimeChanged()事件

* OnDateSetListener
>当用户更改了DatePickerDialog里的年、月、日时，将触发OnDateSetListener监听器的OnDateSet()事件
* OnTimeSetListener
>当用户更改了TimePickerDialog里的时、分时，将触发OnTimeSetListener监听器的OnTimeSet()事件

#####注意事项
* DatePicker对象以init()这个方法来指定DatePicker初始化的年、月日及OnDateSetListener的事件；而TimePicker对象则是直接以setOnTimeChangedListener()事件来处理时间改变时程序要做的操作
* DatePickerDialog和TimePickerDialog与前面这两种类型的对象最大的区别在于DatePicker和TimePicker是直接显示在画面上，而DatePickerDialog和TimePickerDialog对象则是以弹出Dialog的方式来显示。
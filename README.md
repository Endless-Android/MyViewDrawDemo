#项目简介
本项目是一个自定义View实现画画板涂鸦的小项目，展示了画画板的基本功能，包括简单的画直线，矩形，圆形等，实现了画笔的可调节粗细功能，还有画笔颜色等的选择设置，步骤的恢复与撤销等小功能。
#使用的开源项目
## butterknife
###Android studio用户可以直接通过导入以下两个依赖即可
####[compile 'com.jakewharton:butterknife:8.5.1'](compile 'com.jakewharton:butterknife:8.5.1')
####[annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'](annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1')
#学习目标
* 自定义view的基本使用与理解
* 对自定义view的基本运用
* 熟练的使用Android 中的Paint,Canvas等基本绘图
* 增加对代码的熟练度

￼#项目简介
本项目是一个自定义View实现画画板涂鸦的小项目，展示了画画板的基本功能，包括简单的画直线，矩形，圆形等，实现了画笔的可调节粗细功能，还有画笔颜色等的选择设置，步骤的恢复与撤销等小功能。
#使用的开源项目
## butterknife
###Android studio用户可以直接通过导入以下两个依赖即可
####[compile 'com.jakewharton:butterknife:8.5.1'](compile 'com.jakewharton:butterknife:8.5.1')
####[annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'](annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1')
#学习目标
* 自定义view的基本使用与理解
* 对自定义view的基本运用
* 熟练的使用Android 中的Paint,Canvas等基本绘图
* 增加对代码的熟练度

# 功能需求
*  点击屏幕上的任何一个icon按钮均会实现相对的事件
# Android6.0动态权限管理

￼
Andrioid6.0对权限进行了分组，涉及到用户敏感信息的权限只能动态的去获取。当应用的targetSdkVersion小于23时， 会默认采用以前的权限管理机制，当targetSdkVersion大于等于23时并且运行在Andorid6.0系统上，它才会采用这套新的权限管理机制。
## 参考
[适配Android6.0动态权限管理](http://www.jianshu.com/p/a37f4827079a)
[Android 6.0权限管理的解析与实战](http://www.jianshu.com/p/a1edba708761)
## 动态获取写磁盘权限
本小案例涉及图片的存储，需要读写磁盘的权限
``` 
 /**
 * 是否有写磁盘权限
 */
 if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
             
                
 /**
 * 申请权限
 */
  ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);  
```
# 基本功能演示
￼

# 功能需求
*  点击屏幕上的任何一个icon按钮均会实现相对的事件
# Android6.0动态权限管理

￼
Andrioid6.0对权限进行了分组，涉及到用户敏感信息的权限只能动态的去获取。当应用的targetSdkVersion小于23时， 会默认采用以前的权限管理机制，当targetSdkVersion大于等于23时并且运行在Andorid6.0系统上，它才会采用这套新的权限管理机制。
## 参考
[适配Android6.0动态权限管理](http://www.jianshu.com/p/a37f4827079a)
[Android 6.0权限管理的解析与实战](http://www.jianshu.com/p/a1edba708761)
## 动态获取写磁盘权限
本小案例涉及图片的存储，需要读写磁盘的权限
``` 
 /**
 * 是否有写磁盘权限
 */
 if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
             
                
 /**
 * 申请权限
 */
  ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 1001);  
```

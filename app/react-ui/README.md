# Mekatok React App
> 一个基于umiJS,dvaJS和antd的前端框架

```node
react-ui
	|- config																										# 配置文件
	|- disk																										  # 打包编译的数据目录
	|- mock																											# Mock服务,基于Express.
	|- public																										# 公共文件,打包后copy至输出目录
	|- src																											# 代码路径
		|- document.ejs																						# HTML模板
		|- .umi																										# 临时文件目录,由umi自动维护
		|- .umi-production																				# 同上
		|- layouts																								# 布局文件目录
			|- login																								# 登录页面
			|- register																							# 注册页面
			|- frame																								# 框架页面
		|- pages																									# 路由组件目录
		|- models																									# 模型目录
			|- action
			|- saga
		|- app.ts																									# 运行时配置文件
		|- global.ts																							# 全局配置文件
	|- .env																											# 环境变量配置
	|- .umirc.ts																								# umi内置功能和插件的配置
	|- .umirc.**.ts																							# 对应环境(UMI_ENV)的配置
	|- .umirc.local.ts																					# 本地环境的配置,最高优先级
	
	
```


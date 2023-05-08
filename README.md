# Mekatok

![Logo](./docs/images/mekatok.png)

<p align="center">
	<img alt="JDK" src="https://img.shields.io/badge/JDK-17-green.svg" />
    <img alt="GitHub" src="https://img.shields.io/github/license/guocay/mekatok">
</p>

## 简介

Mekatok是一个基于 **SpringBoot** 使用 **DDD思维** 的 **开盖即用** 的开发包, 说白了就是一个缝合怪...

## 信条

1. 润物无声 - 只做增强不做改变,Mekatok引入的技术栈均不改变原工具使用逻辑,仅在原有基础上做符合现有业务的增强;
2. 志同道合 - 寻找和培养更多拥有相近编码价值观,业务抽象能力和工作效率的小伙伴;

## 名称由来

Mekatok的名字来源于网络游戏"魔兽世界"中,联盟阵营侏儒领袖 -- 大工匠梅卡托克的缩写.

愿工匠精神鼓舞你我前进!!!

## 项目结构

```
mekatok
 |- docs                                                        	# 说明文档
 |- example                                                 		# 示例代码
 |- mekatok-adaper                                 			# 适配器模块
 |- mekatok-adaper-dubbo                                 		# 适配器模块 - Dubbo连接器(消费者)
 |- mekatok-adaper-rocketmq                                 		# 适配器模块 - RocketMQ连接器(消费者)
 |- mekatok-adaper-web                                 			# 适配器模块 - web
 |- mekatok-adaper-webflux                                 		# 适配器模块 - webflux
 |- mekatok-adaper-webmvc                                 		# 适配器模块 - webmvc
 |- mekatok-adaper-websocket                                 		# 适配器模块 - websocket
 |- mekatok-application                                 		# 应用模块
 |- mekatok-core                                 			# 核心模块
 |- mekatok-core-exception                                 		# 核心模块 - 异常及断言
 |- mekatok-domain                                 			# 领域模块
 |- mekatok-infrastructure                                 		# 基础设施模块
 |- mekatok-infrastructure-curator                              	# 基础设施模块 - ZooKeeper连接器
 |- mekatok-infrastructure-dubbo                                	# 基础设施模块 - Dubbo连接器(生产者)
 |- mekatok-infrastructure-elasticsearch                        	# 基础设施模块 - ElasticSearch连接器
 |- mekatok-infrastructure-liquibase                            	# 基础设施模块 - 数据库版本管理器
 |- mekatok-infrastructure-mybatis                              	# 基础设施模块 - RDBS连接器
 |- mekatok-infrastructure-redisson                             	# 基础设施模块 - Redis连接器
 |- mekatok-infrastructure-rocketmq                             	# 基础设施模块 - RocketMQ连接器(生产者)
 |- .editorconfig                                             		# 编辑器格式设置
 |- lombok.config                                             		# Lombok基础配置文件
```

## 其他

![异常信息定义](./docs/images/error-code.png)

## 帮助文档

* Coming Soon

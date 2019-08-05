首先在mysql中运行sql文件，建立相关数据库。

###上传模版api

**URL**

/upload

**请求方式**

post

**请求参数**

| 参数         | 类型          | 必需 |
| :----------- | :------------ | :--- |
| templatefile | MultipartFile | 是   |

**返回结果**

| 参数   | 类型       | 描述                         |
| :----- | :--------- | :--------------------------- |
| String | templateId | 返回模版文件的标识templateId |

**过程**

1. 上传template模版文件到oss，取得返回的结果，如模版路径、模版templateId，并将结果存储到数据库；
2. 返回templateId到前端。



###将json数据套入到模版当中api

**URL**

post

**请求方式**

post

**请求参数**

| 参数       | 类型   | 必需 |
| :--------- | :----- | :--- |
| templateId | String | 是   |
| jsonData   | String | 是   |

**返回结果**

| 参数      | 类型 | 描述                                  |
| :-------- | :--- | :------------------------------------ |
| reportUrl | url  | 通过url能再次发送请求，获得最终模版； |

**过程1**

1. 通过templateId从数据库中找到文件的oss路径，将其设为freemarker的模版来源；

2. 解析jsondata并将其填入到上述template当中，同时将jsondata填入到数据库中；
3. 返回url，在返回到url中调用findreport



###报告显示api

**URL**

findreport

**请求方式**

get

**请求参数**

| 参数     | 类型   | 必需 |
| :------- | :----- | :--- |
| jsonid   | String | 是   |
| template | String | 是   |

**返回结果**

| 参数   | 类型   | 描述       |
| :----- | :----- | :--------- |
| report | String | report内容 |

**过程1**

1. 通过templateId从数据库中找到文件的oss路径，通过jsonid找到jsondata，将两者结合；

2. 将两者结合的字符串返回到页面


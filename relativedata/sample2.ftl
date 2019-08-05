<!DOCTYPE html>
<html lang="en">
<head>
    <title>sample2</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        html {
            font-size: 14px;
            font-weight: 400;
        }
        .exp {
            font-size: 12px;
            color: lightgray;
        }
    </style>
</head>
<body>
<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>

<dl>
    <dt>字符串</dt>
    <dd>姓名：<span class="exp">${name}</span></dd>
    <dd>年龄：<span class="exp">${age}</span></dd>
</dl>

</body>
</html>
<html>
<p>我们${haha}</p>
<p>你好吗？${maplist.name}</p>
<p>你好？${maplist.age}</p>
<p>你吗？${maplist.address}</p>
<p>你？${maplist.ad!}</p>

Welcome ${user!}!
Welcome ${user!'your name'}!
或者
${user?if_exists}

${user?default('your name')}

如果user找不到值，会输出
Welcome !
Welcome your name!
否则freemarker会报错

</html>
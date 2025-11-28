import com.tencent.cloud.cos.util.MD5;

import java.util.Date;

public class COSServiceTest3 {
public static void main(String[] args) {
/*
访问 URL 格式
http://DomainName/Filename?sign=timestamp-rand-uid-md5hash

算法说明:
timestamp：十进制（UNIX 时间戳）。
rand：随机字符串，0 - 100位随机字符串，由大小写字母与数字组成。
uid：0
md5hash：MD5（文件路径-timestamp-rand-uid-自定义密钥）。
请求示例
http://cloud.tencent.com/test.jpg?sign=1582791032-im1acp76sx9sdqe601v-0-dd63f95e739ed4b47427a129d21ef4e3
注意：
计算 MD5 时，若请求路径为 http://cloud.tencent.com/test.jpg，则计算 MD5 时路径为/test.jpg。
*/

String cdnKey = "xxxxxxxxxxxxxxx";
String objectName = "xxxxxxxxxx";

Date now = DateUtils.getMiPaasNowChinaTime();
Date expiration = DateUtils.dateAddYear(now, 80);

StringBuilder signContentOrigin = new StringBuilder()
.append(expiration.getTime() / 1000).append("-")
.append(UUIDUtil.gen32RandomString()).append("-")
.append(0).append("-");

String signMd5Origin = new StringBuilder().append("/").append(objectName).append("-")
.append(signContentOrigin)
.append(cdnKey).toString();

String signMd5 = MD5.stringToMD5(signMd5Origin);

StringBuilder stringBuilder = new StringBuilder();
String uri = "https://xxxxxx.com.cn/" + objectName;
String url = stringBuilder.append(uri).append("?sign=")
.append(signContentOrigin).append(signMd5)
.toString();

System.out.println(url);
}
}

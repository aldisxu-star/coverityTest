
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



System.out.println(cdnKey+objectName);
}
}

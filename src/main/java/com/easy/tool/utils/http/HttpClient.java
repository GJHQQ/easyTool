package com.easy.tool.utils.http;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 高俊
 * @create 2021-08-2021/8/27-17:11
 */
public class HttpClient {

    /**
     * 发送post请求
     * @param urlC  请求url
     * @param jsonObject    接送类型数据
     * @param headMap   自定请求头
     * @return 返回json字符串
     */
    public static String sendPost(String urlC , JSONObject jsonObject, Map<String,Object> headMap) {
        StringBuffer sb = new StringBuffer("");

        try {
            URL url = new URL(urlC);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setRequestProperty("charset", "utf-8");
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            // 设置自定义请求头
            connection = setHead(connection,headMap);

            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(jsonObject.toString().getBytes("UTF-8"));
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            String lines;
            while((lines = reader.readLine()) != null) {
                sb.append(lines);
            }

            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 发送get请求
     * @param urlC 请求地址
     * @param map   get请求携带的数据
     * @param headMap   需要自定的请求头
     * @return json字符串
     */
    public static String sendGet(String urlC, Map<String ,Object> map, Map<String ,Object> headMap) {
        String sb = "";

        // 判断键是否存在
        if (map != null && map.keySet().size() > 0){
            // 存在开始拼字符串
            urlC += "?";
            Set<String> keySet = map.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()){
                // 需要先定义一个key，否则两次使用指针就会往后移两次
                String key = iterator.next();
                urlC += key + "=" + map.get(key);
                // 下一个为真拼接 &&
                if (iterator.hasNext()){
                    urlC += "&&";
                }
            }
        }

        try {
            URL url = new URL(urlC);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();//开发访问此连接
            //设置访问时长和相应时长
            connection.setConnectTimeout(5*1000);//设置连接时间为5秒
            connection.setReadTimeout(5*1000);//设置读取时间为5秒

            // 设置自定头
            setHead(connection,headMap);

            int code = connection.getResponseCode();//获得相应码
            if(code == 200){//相应成功，获得相应的数据
                InputStream is = connection.getInputStream();//得到数据流（输入流）
                byte[] buffer = new byte[1024];
                int length = 0;
                String data = "";
                while((length = is.read(buffer)) != -1){
                    String str = new String(buffer,0,length);
                    data += str;
                }
                sb = data;
            }
        } catch (MalformedURLException var8) {
            var8.printStackTrace();
        } catch (UnsupportedEncodingException var9) {
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        return sb;
    }

    /**
     * 设置自定头
     * @param connection HttpURLConnection
     * @param map
     * @return
     */
    private static HttpURLConnection setHead(HttpURLConnection connection,Map<String,Object> map){

        if (map != null && map.keySet().size() > 0){
            Set<String> keySet = map.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                connection.setRequestProperty(key,String.valueOf(map.get(key)));
            }
        }
        return connection;
    }
}

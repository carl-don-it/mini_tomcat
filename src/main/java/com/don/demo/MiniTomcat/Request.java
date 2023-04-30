package com.don.demo.MiniTomcat;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 把socket的消息按照http协议的格式封装在request中
 * 请求资料的集合体，
 *
 * @author Carl Don
 * @version V1.0
 * @date 2020年01月14日 下午 7:38
 */
@Data
public class Request {
	private InputStream inputStream;
	private String method;
	private String url;

	public Request(InputStream inputStream) throws IOException {
		this.inputStream = inputStream;
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		//把客户端请求信息的第一行读取出来 GET /11_Net/web/index.html HTTP/1.1
		String line = br.readLine();
		//把读取的信息进行切割,只要中间部分 /web/index.html
		String[] arr = line.split(" ");
		//把路径前边的/去掉,进行截取 web/index.html
		url = arr[1].trim();
		method = arr[0].trim();

		System.out.println(Thread.currentThread().getName() + ":::" + line);
		//while (line != null) {//会阻塞
			line = br.readLine();
			System.out.println(Thread.currentThread().getName() + ":::" + line);
		//}

	}

}

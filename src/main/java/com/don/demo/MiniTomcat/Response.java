package com.don.demo.MiniTomcat;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 用于后面相应请求的时候使用
 *
 * @author Carl Don
 * @version V1.0
 * @date 2020年01月14日 下午 7:39
 */
@Data
public class Response {
	public Response(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	private OutputStream outputStream;

	public void write(String s) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		// 写入HTTP协议响应头,固定写法
		stringBuilder.append("HTTP/1.1 200 OK\r\n").append("Content-Type:text/html\r\n").append("\r\n").append("<!DOCTYPE html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <title>Title</title>\n" +
				"</head>\n" +
				"<body>\n").append(s).append(("</body>\n" +
				"</html>    "));
		byte[] bytes = stringBuilder.toString().getBytes();
		outputStream.write(bytes);

	}
}

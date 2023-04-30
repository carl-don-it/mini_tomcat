package com.don.demo.MiniTomcat;

import java.io.IOException;

/**
 * 前文说Tomcat是满足Servlet规范的容器，那么自然Tomcat需要提供API。这里你看到了Servlet常见的doGet/doPost/service方法。
 *
 * @author Carl Don
 * @version V1.0
 * @date 2020年01月14日 下午 7:22
 */
public abstract class Servlet {

	public void service(Request request, Response response) throws IOException {
		String method = request.getMethod();
		if (method == null) {
			throw new RuntimeException();
		} else if (method.equals("GET")) {
			doGet(request, response);
		} else if (method.equals("POST")) {
			doPost(request, response);
		}
	}

	public void doGet(Request request, Response response) throws IOException {
		doPost(request, response);
	}

	public void doPost(Request request, Response response) throws IOException {
			response.write("抽象servlet");
	}
}

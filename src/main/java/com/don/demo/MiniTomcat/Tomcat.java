package com.don.demo.MiniTomcat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * todo
 *
 * @author Carl Don
 * @version V1.0
 * @date 2020年01月14日 下午 7:38
 */
@AllArgsConstructor
@NoArgsConstructor
public class Tomcat {
	private int port = 8080;
	public static Map<String, Servlet> map = new HashMap<>();

	public void start() throws IOException {
		initial();
		//创建一个服务器
		ServerSocket server = new ServerSocket(port);

		while (true) {
			Socket socket = server.accept();

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Request request = new Request(socket.getInputStream());
						Response response = new Response(socket.getOutputStream());
						dispatch(request, response);
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	//分发给恰当的servlet
	private void dispatch(Request request, Response response) throws IOException {
		String url = request.getUrl();
		Servlet servlet = map.get(url);
		servlet.service(request, response);
	}

	public static void main(String[] args) throws IOException {
		new Tomcat().start();
	}

	//初始化servlet和对应的url
	public void initial() {
		map.put("/servlet1", new ServletImpl());
		map.put("/servlet2", new ServletImpl2());
		map.put("/file/relative", new ServletImpl2());
	}

}

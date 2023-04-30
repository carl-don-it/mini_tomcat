package com.don.demo.MiniTomcat;

import java.io.IOException;

/**
 * todo
 *
 * @author Carl Don
 * @version V1.0
 * @date 2020年01月14日 下午 11:05
 */
public class ServletImpl extends Servlet {
	@Override
	public void doPost(Request request, Response response) throws IOException {
		response.write("ServletImpl");
	}
}

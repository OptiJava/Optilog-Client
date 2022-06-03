package com.optilog.log.web;

import com.optilog.log.Optilog;
import com.optilog.util.tools.LocalField;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/optilog")
public class LogServlet extends HttpServlet {
	public static String s = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Optilog instance = (Optilog) LocalField.getField("instance");
		LocalField.removeField("instance");
		PrintWriter print = resp.getWriter();
		instance.writer = print;
		print.write("<h1>Welcome to Optilog!<h1>");
		new Thread(() -> {
			while (!Objects.equals(s, "###0x00//Optilog:%CloseTomcatHttpServer")) {
				if (s != null) {
					print.write(s);
				}
			}
		}).start();
	}
	
	public static void setClose() {
		LogServlet.s = "###0x00//Optilog:%CloseTomcatHttpServer";
	}
}

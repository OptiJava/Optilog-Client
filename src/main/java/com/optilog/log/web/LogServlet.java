package com.optilog.log.web;

import com.optilog.log.Optilog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/optilog")
public class LogServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter print = resp.getWriter();
		print.write("<h1>Welcome to Optilog!<h1>");
	}
	
	public static void logAppender(String s, Optilog instance) {
	
	}
}

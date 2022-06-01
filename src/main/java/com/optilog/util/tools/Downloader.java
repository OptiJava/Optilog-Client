package com.optilog.util.tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {
	public static void Download(String URL) {
		try {
			URL url = new URL(URL);
			String fileName = "";
			int index = url.getFile().lastIndexOf(".");
			if (index != -1) {
				fileName = url.getFile().substring(index);
			}
			HttpURLConnection urlConnection = ((HttpURLConnection) url.openConnection());
			
			InputStream is = urlConnection.getInputStream();
			
			FileOutputStream fos = new FileOutputStream("UrlDown" + fileName);
			
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			
			fos.close();
			is.close();
			urlConnection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

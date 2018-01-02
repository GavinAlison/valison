package com.getResource;

import java.io.File;

public class GetPath {
	public void getPath() {
		// 1
		System.out.println(System.getProperty("user.dir"));
		// 2
		File directory = new File("");// 设置当前文件夹
		//D:\workspace\valison
		try {
			System.out.println(directory.getCanonicalPath());// 获取标准的路径
			//D:\workspace\valison
			System.out.println(directory.getAbsolutePath());// 获取绝对路径
			//D:\workspace\valison
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3
		// 方式三
		System.out.println(GetPath.class.getResource("/"));
		//file:/D:/workspace/valison/WebRoot/WEB-INF/classes/
		System.out.println(GetPath.class.getResource(""));
		//file:/D:/workspace/valison/WebRoot/WEB-INF/classes/com/getResource/
		// 方式4
		System.out.println(GetPath.class.getClassLoader().getResource(""));
		//file:/D:/workspace/valison/WebRoot/WEB-INF/classes/
		System.out.println(GetPath.class.getClassLoader().getResource(
				"source.xml"));

	}
	public static void main(String[] args) {
		GetPath g = new GetPath();
		g.getPath();
	}
}

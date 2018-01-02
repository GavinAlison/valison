package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class FileUtils {
	public final static String SOURCEPATH = "E:\\205\\pms-1228\\pms_src";
	public final static String DESTPATH = "E:\\205\\pms-1228\\pms";
	public final static String LOGPATH = "E:\\205\\pms-1228\\log.txt";
	public final static String OPERATPATH = "E:\\205\\pms-1228\\operate.txt";

	public final static String PATH = "D:\\workspace\\pms205\\WebRoot";
	public final static String WEBINF = "WEB-INF\\classes";

	/**
	 * 根据sourcePath去寻找源文件，找到将该文件复制到指定的目录下
	 * 
	 * @param sourcepath
	 * @param destpath
	 * @throws Exception
	 */
	public static void copyDir(String sourcepath, String destpath)
			throws Exception {
		/**
		 * tempDestPath：循环的目的路径,复制的目的文件<br>
		 * tempPath: 循环的源路径 <br>
		 * tempSource: 复制的源文件
		 */
		String tempDestPath = "", tempPath = "", tempSource = "";
		File tempFile = null;
		File sourceFile = new File(sourcepath);
		String[] listFile = sourceFile.list();
		File destFile = new File(destpath);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}
		for (int i = 0; i < listFile.length; i++) {
			tempPath = sourcepath + File.separator + listFile[i];
			tempFile = new File(tempPath);
			// 处理src和WebRoot文件夹，避免dest的文件中含有src和WebRoot的文件夹
			if ("src".equalsIgnoreCase(listFile[i])) {
				tempDestPath = destpath + File.separator
						+ listFile[i].replace("src", FileUtils.WEBINF);
			} else if ("WebRoot".equalsIgnoreCase(listFile[i])) {
				tempDestPath = destpath + File.separator
						+ listFile[i].replace("WebRoot", "");
			} else {
				tempDestPath = destpath + File.separator + listFile[i];
			}
			if (tempFile.isDirectory()) {
				copyDir(tempPath, tempDestPath);
			}
			if (tempFile.isFile()) {
				// 区分src和WebRoot
				// String tempSource = "";
				// 防止更新补丁包名字包含src或者WebRoot字符
				if (tempPath.contains("\\src")) {
					tempSource = FileUtils.PATH
							+ File.separator
							+ tempPath.replace(FileUtils.SOURCEPATH + "\\src",
									FileUtils.WEBINF);

				} else if (tempPath.contains("\\WebRoot")) {
					tempSource = FileUtils.PATH
							+ File.separator
							+ tempPath.replace(FileUtils.SOURCEPATH
									+ "\\WebRoot", "");
				}
				// 遇到.class文件的处理
				if (listFile[i].endsWith(".java")) {
					// 取出父目录
					File parentFile = new File(tempSource).getParentFile();
					String[] subFiles = parentFile.list();
					for (int j = 0; j < subFiles.length; j++) {
						if (subFiles[j].startsWith(listFile[i].replace(".java",
								""))) {
							tempSource = tempSource.substring(0, tempSource
									.lastIndexOf("\\") + 1)
									+ subFiles[j];
							tempDestPath = tempDestPath.substring(0,
									tempDestPath.lastIndexOf("\\") + 1)
									+ subFiles[j];
							copyFile(tempSource, tempDestPath);
						}
					}
				} else
					copyFile(tempSource, tempDestPath);
			}
		}
	}

	public static void copyFile(String sourcePath, String destPath)
			throws Exception {
		FileInputStream in = null;
		FileOutputStream out = null;
		FileWriter writer = null;
		try {
			File sourceFile = new File(sourcePath);
			File destFile = new File(destPath);
			File operatFile = new File(FileUtils.OPERATPATH);
			File logFile = new File(FileUtils.LOGPATH);
			// 源文件不存在写入日志信息中
			if (!sourceFile.exists()) {
				if (!logFile.exists()) {
					logFile.createNewFile();
				}
				try {
					writer = new FileWriter(logFile, true);
					writer.write(sourcePath + "不存在！\r\n");
					writer.flush();
					return;
				} finally {
					if (writer != null) {
						writer.close();
					}
				}
			}
			in = new FileInputStream(sourceFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[2097152];
			int bytesRead = 0;
			while ((bytesRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, bytesRead);
			}
			out.flush();

			if (!operatFile.exists()) {
				operatFile.createNewFile();
			}
			try {
				writer = new FileWriter(operatFile, true);
				writer.write(sourcePath + "\r\n");
				writer.flush();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("====开始=======");
			long startTime = System.currentTimeMillis();
			FileUtils.copyDir(FileUtils.SOURCEPATH, FileUtils.DESTPATH);
			long endTime = System.currentTimeMillis();
			System.out.println("运行时间:" + (endTime - startTime) + "ms");
			System.out.println("====结束=======");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

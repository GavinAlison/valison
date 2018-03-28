package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDemo {
	final static String separator = "\r\n";
	final static String path1 = "E:\\v\\qwe\\2";
	final static String path2 = "C:\\uninstall.log";
	final static String path3 = "D:\\test\\writeFile\\wpms.txt";
	final static String xpath1 = "E:\\a\\asd";
	final static String xpath2 = "E:\\a\\123.txt";
	final static String xpath3 = "file.txt";
	// final static String sourcePath = "E:\\205\\pms-1104_2";

	final static String SOURCEPATH = "E:\\a\\12";
	final static String destPath = "E:\\a\\13\\pms";
	final static String PATH = "D:\\workspace\\pms205\\WebRoot";
	final static String WEBINF = "WEB-INF\\classes";
	final static String LOGPATH = "E:\\a\\13\\log.txt";

	public static void main(String[] args) {
		// FileDemo f = new FileDemo();
		// File flie = new File("E:\\a\\12\\Web*");
		// System.out.println(flie.exists());
		// File sourceFile = new File(sourcePath);
		// File destFile = new File(destPath);
		// System.out.println(sourceFile.isDirectory());
		// try {
		// copyDir2(FileDemo.SOURCEPATH, destPath);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// String fileStr = "E:\\a\\demo1\\1105.txt";
		// String fileStr_1 = "E:\\a\\1105";
		// String fileStr1 = "E:\\a\\demo1\\1105.txt";
		// String fileStr2 = "E:\\a\\demo1\\111";
		// String fileStr3 = "E:\\a\\demo1\\1106.exe";
		// String fileStr4 = "E:\\tools\\工具\\360se8.1.1.406.exe";
		// String fileStr5 = "E:\\a\\writefile.txt";
		// f.showDir(new File("E:\\a"));

		// 列举125-128所有的文件记录

		File f = new File(FileDemo.path1);
		showDir(f);
	}

	/**
	 * 根据sourcePath去寻找源文件，找到将该文件复制到指定的目录下
	 * 
	 * @param sourcepath
	 * @param destpath
	 * @throws Exception
	 */
	public static void copyDir2(String sourcepath, String destpath)
			throws Exception {
		File sourceFile = new File(sourcepath);
		String[] listFile = sourceFile.list();
		File destFile = new File(destpath);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}
		for (int i = 0; i < listFile.length; i++) {
			String tempPath = sourcepath + File.separator + listFile[i];
			File tempFile = new File(tempPath);
			String tempDestPath = "";
			if ("src".equalsIgnoreCase(listFile[i])) {
				tempDestPath = destpath + File.separator
						+ listFile[i].replace("src", FileDemo.WEBINF);
			} else if ("WebRoot".equalsIgnoreCase(listFile[i])) {
				tempDestPath = destpath + File.separator
						+ listFile[i].replace("WebRoot", "");
			} else {
				tempDestPath = destpath + File.separator + listFile[i];
			}
			if (tempFile.isDirectory()) {
				copyDir2(tempPath, tempDestPath);
			}
			if (tempFile.isFile()) {
				// 区分src和WebRoot
				String tempSource = "";
				if (tempPath.contains("src")) {
					tempSource = FileDemo.PATH
							+ File.separator
							+ tempPath.replace(FileDemo.SOURCEPATH + "\\src",
									FileDemo.WEBINF);

				} else if (tempPath.contains("WebRoot")) {
					tempSource = FileDemo.PATH
							+ File.separator
							+ tempPath.replace(FileDemo.SOURCEPATH
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
							tempSource = tempSource.replace(listFile[i],
									subFiles[j]);
							tempDestPath = tempDestPath.replace(listFile[i],
									subFiles[j]);
						}
					}
				}
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
			File logFile = new File(FileDemo.LOGPATH);
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
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public void test01() {
		File f1 = new File("C:\\uninstall.log");
		File f2 = new File("D:\\test\\writeFile", "wpms.txt");
		File f3 = new File("D:" + File.separator + "test\\writeFile");
		File f4 = new File(f3, "wpmsDemo.txt");
		System.out.println(f1 + FileDemo.separator + f2 + FileDemo.separator
				+ f3 + FileDemo.separator + f4);
	}

	public void test02(String pathName) {
		File f = new File(pathName);
		/*
		 * mkdir()---boolean :创建此抽象路径名指定的目录, 父目录必须存在, 不存在则返回false；该文件存在返回false
		 */
		// System.out.println(f.mkdir());
		/*
		 * mkdirs()---boolean: 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		 * 不存在该file，创建file目录，父目录不存在，同样也会创建，返回true;否则返回false，
		 */
		// System.out.println(f.mkdirs());
		/*
		 * delete()---boolean: 删除此抽象路径名表示的文件或目录。 删除成功，返回true，删除失败，返回false
		 */
		// System.out.println(f.delete());
		// deleteOnExit()--boolean: 在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。没法测试
		// f.deleteOnExit();
		/*
		 * canExecute()--boolean: 测试应用程序是否可以自行此抽象路径名的文件,
		 * 可以是目录，可以是.txt，可以是.exe,注意，是应用程序可以自行，
		 * 并不是所有的exe都是可执行程序，内部需要引用入口，简单点说就是双击可运行.
		 */
		// System.out.println(f.canExecute());
		/*
		 * canRead()--boolean: 测试应用程序是否可以读取此抽象路径名表示的文件。
		 */
		// System.out.println(f.canRead());
		/*
		 * canWrite()--boolean: 测试应用程序是否可以修改此抽象路径名表示的文件。
		 */
		// System.out.println(f.canWrite());
		/*
		 * exists()--boolean: 测试文件是否存在
		 */
		// System.out.println(f.exists());
		/*
		 * isDirectory()--boolean: 测试此抽象路径名（file）是否为一个目录
		 */
		// System.out.println(f.isDirectory());
		/*
		 * isFile()--boolean: 测试file是否为一个文件
		 */
		// System.out.println(f.isFile());
		/*
		 * isHidden()--boolean: 测试file是否是隐藏文件
		 */
		// System.out.println(f.isHidden());
		/*
		 * isAbsolute()--boolean: 测试file是否是绝对路径
		 */
		// System.out.println(f.isAbsolute());
		/*
		 * getName()--String: 返回file的名称字符串
		 */
		// System.out.println(f.getName());
		/*
		 * getPath()--String: 返回file的路径名称字符串
		 */
		// System.out.println(f.getPath());
		/*
		 * getAbsolutePath()--String: 返回file的绝对路径名字符串
		 */
		// System.out.println(f.getAbsolutePath());
		/*
		 * getParent()--String : 返回父路径名字符串，没有则为null
		 */
		// System.out.println(f.getParent());
		/*
		 * lastModified()--long: 返回file的最后一次修改时间,距离1970-1-1
		 * 00:00:00的时间差数，以当前日期-(1970-1-1)；如果该文件是相对路径下的，lastmodify为0
		 */
		// System.out.println(StaticMethod.parseToDateString(new Date(f
		// .lastModified()), "yyyy-MM-dd"));
		/*
		 * length()--long： 返回文件的长度, 目录返回为0, 文件，返回文件内容字符的长度
		 */
		// System.out.println(f.length());
		/*
		 * renameTo(destname)--boolean:
		 * 重新命名该file,那么该操作可能无法获得成功。应该始终检查返回值，以确保重命名操作成功。
		 */
		// System.out.println(f.renameTo(new File("E:\\a\\rename.txt")));
		/*
		 * listRoots --String[]: 列出可用的文件系统的根, unix下为/, windows下为各盘符与各盘符下的第一文件夹
		 */
		// f.listRoots();
		/*
		 * list()--String[]： 返回字符串数组， 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
		 * 如果此抽象路径名不表示一个目录，那么此方法将返回
		 * null。否则返回一个字符串数组，每个数组元素对应目录中的每个文件或目录。表示目录本身及其父目录的名称不包括在结果中
		 * 。每个字符串是一个文件名，而不是一条完整路径。
		 * 
		 * 不保证所得数组中的相同字符串将以特定顺序出现，特别是不保证它们按字母顺序出现。
		 */
		// System.out.println(f.list());
		// ArrayUtils.foreach(f.list());
		/*
		 * 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录。除了返回数组中的字符串必须满足过滤器外，此方法的行为与
		 * list() 方法相同。如果给定 filter 为
		 * null，则接受所有名称。否则，当且仅当在此抽象路径名及其表示的目录中的文件名或目录名上调用过滤器的
		 * FilenameFilter.accept(java.io.File, java.lang.String) 方法返回 true
		 * 时，该名称才满足过滤器。 返回true的字符，过滤成功.
		 */
		// String[] strArr = f.list(new FilenameFilter() {
		//
		// public boolean accept(File dir, String name) {
		// if ("1.txt".equals(name)) {
		// return true;
		// }
		// return false;
		// }
		// });
		// ArrayUtils.foreach(strArr);
		//
		/*
		 * createNewFile():
		 * 当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。检查文件是否存在，若不存在则创建该文件
		 * ，这是单个操作，对于其他所有可能影响该文件的文件系统活动来说，该操作是不可分的。
		 */
		/*
		 * delete(): 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除。
		 */
		try {
			System.out.println(f.createNewFile());// 当文件存在时返回false
			System.out.println(f.delete());// 当文件不存在时返回false
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 列出所有磁盘下的文件和文件夹
	public void test03() {
		// File.listRoots()---列出可用的文件系统的根, unix下为/, windows下为各盘符与各盘符下的第一文件夹
		File[] files = File.listRoots();
		for (File file : files) {
			System.out.println(file);
			if (file.length() > 0) {
				// file.list()---返回一个字符串数组，每个字符串存储的是文件的全称
				String[] filenames = file.list();
				for (String filename : filenames) {
					System.out.println(filename);
				}
			}
		}
	}

	// 文件过滤
	public void test04() {
		File[] files = File.listRoots();
		for (File file : files) {
			System.out.println(file);
			if (file.length() > 0) {
				String[] filenames = file.list(new FilenameFilter() {
					// file 过滤目录 name 文件名
					public boolean accept(File file, String filename) {
						return filename.endsWith(".mp3");
					}
				});
				for (String filename : filenames) {
					System.out.println(filename);
				}
			}
		}
	}

	// 利用递归列出全部文件
	public static void showDir(File dir) {
		// System.out.println(dir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				showDir(file);
			else
				System.out.println(file);
		}
	}

	// 移动文件
	// 找出d盘下所有的 .java 文件，拷贝至 D:\jad 目录下，并将所有文件的类型由.java 修改为.jad 。
	public static void moveFile(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory())
				moveFile(file);
			else {
				if (file.getName().endsWith(".java"))
					file.renameTo(new File("D:\\jad\\"
							+ file.getName().substring(0,
									file.getName().lastIndexOf('.')) + ".jad"));
			}
		}
	}

	@SuppressWarnings("unused")
	private static void copyFileUsingJava7Files(File source, File dest)
			throws IOException {
		// Files.copy(source.toPath(), dest.toPath());
	}

	@SuppressWarnings("unused")
	private static void copyFileUsingFileStreams(File source, File dest)
			throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			input.close();
			output.close();
		}
	}

	public static void copyDir(String sourcepath, String destpath)
			throws Exception {
		File sourceFile = new File(sourcepath);
		String[] listFile = sourceFile.list();
		File destFile = new File(destpath);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}
		for (int i = 0; i < listFile.length; i++) {
			String tempPath = sourcepath + File.separator + listFile[i];
			File tempFile = new File(tempPath);
			if (tempFile.isDirectory()) {
				copyDir(tempPath, destpath + File.separator + listFile[i]);
			}
			if (tempFile.isFile()) {
				copyFile(tempPath, destpath + File.separator + listFile[i]);
			}
		}
	}

}

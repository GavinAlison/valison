//package com.alison.stream.servlet;
//
//import java.io.File;
//public class Demo {
//	public static void main(String[] args) {
//		// File file = new File("d:/test/writeFile/wpms.text");
//		// // File file1 = new File("d:/test/writeFile/wpms");
//		// Path pathOther = file.toPath();
//
//		// System.out.println(pathOther);
//		// System.out.println(file1.toPath().resolveSibling("wpms.text"));
//		// Files.move(file.toPath(), file.toPath().resolveSibling("wpms"),
//		// StandardCopyOption.REPLACE_EXISTING);
//
////		Path path = FileSystems.getDefault().getPath(f.getAbsolutePath());
////		Files.move(path, path.resolveSibling(fileName));
//		/*
//		 * // 获得path方法一,d:/test/writeFile/wpms.text Path path =
//		 * FileSystems.getDefault().getPath("d:/test/writeFile", "wpms.text");
//		 * System.out.println(path.getNameCount()); //
//		 * 获得path方法二，用File的toPath()方法获得Path对象 File file = new
//		 * File("d:/test/writeFile/wpms.text"); Path pathOther = file.toPath();
//		 * // 0,说明这两个path是相等的 System.out.println(path.compareTo(pathOther)); //
//		 * 获得path方法三 Path path3 = Paths.get("d:/test/writeFile", "wpms.text");
//		 * System.out.println(path3.toString());
//		 * 
//		 * // join two paths Path path4 = Paths.get("d:/test/writeFile");
//		 * System.out.println("path4: " + path4.resolve("wpms.text"));
//		 * System.out.println("--------------分割线---------------"); try { if
//		 * (Files.isReadable(path)) { //
//		 * 注意此处的newBufferedRead的charset参数，如果和所要读取的文件的编码不一致，则会抛出异常 //
//		 * java的新特性，不用自己关闭流 BufferedReader br = Files.newBufferedReader(path,
//		 * Charset .defaultCharset());// new BufferedReader(new //
//		 * FileReader(new // File("e:/logs/access.log")));// String line = "";
//		 * while ((line = br.readLine()) != null) { System.out.println(line); }
//		 * } else { System.err.println("cannot readable"); } } catch
//		 * (IOException e) { System.err.println("error charset"); }
//		 */
//
////		Path movefrom = FileSystems.getDefault().getPath(
////				"D:\\test\\writeFile\\wpms.txt");
////		Path target = FileSystems.getDefault().getPath(
////				"D:\\test\\writeFile\\wpmsDemo.txt");
////		Path target_dir = FileSystems.getDefault()
////				.getPath("D:\\test\\writeFile");
////		
////		System.out.println(movefrom.toFile().exists());
////		String path = "D:\\test\\writeFile\\wpms.txt";
////		File file = new File(path);
////		System.out.println(file.isFile());
////		try {
////			Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
////			Files.move(target, target.resolveSibling("wpms.txt"));
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		
////		try {
////            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
////        } catch (IOException e) {
////           e.printStackTrace();
////        }
//
//		File f1 = new File("D:\\test\\writeFile\\wpmsDemo.txt");
////		System.out.println(f1.toPath());
//		try {
////			Files.move(f1.toPath(), f1.toPath().resolveSibling("wpms.txt"));
//		System.out.println(f1.toPath());
//		try {
//			Files.move(f1.toPath(), f1.toPath().resolveSibling("wpms.txt"));
//		} catch (Exception e) {
//			//  
//		}
//		
//	}
//
//package com.alison.stream.servlet;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//
//public class Demo {
//	public static void main(String[] args) {
//		// File file = new File("d:/test/writeFile/wpms.text");
//		// // File file1 = new File("d:/test/writeFile/wpms");
//		// Path pathOther = file.toPath();
//
//		// System.out.println(pathOther);
//		// System.out.println(file1.toPath().resolveSibling("wpms.text"));
//		// Files.move(file.toPath(), file.toPath().resolveSibling("wpms"),
//		// StandardCopyOption.REPLACE_EXISTING);
//
////		Path path = FileSystems.getDefault().getPath(f.getAbsolutePath());
////		Files.move(path, path.resolveSibling(fileName));
//		/*
//		 * // 获得path方法一,d:/test/writeFile/wpms.text Path path =
//		 * FileSystems.getDefault().getPath("d:/test/writeFile", "wpms.text");
//		 * System.out.println(path.getNameCount()); //
//		 * 获得path方法二，用File的toPath()方法获得Path对象 File file = new
//		 * File("d:/test/writeFile/wpms.text"); Path pathOther = file.toPath();
//		 * // 0,说明这两个path是相等的 System.out.println(path.compareTo(pathOther)); //
//		 * 获得path方法三 Path path3 = Paths.get("d:/test/writeFile", "wpms.text");
//		 * System.out.println(path3.toString());
//		 * 
//		 * // join two paths Path path4 = Paths.get("d:/test/writeFile");
//		 * System.out.println("path4: " + path4.resolve("wpms.text"));
//		 * System.out.println("--------------分割线---------------"); try { if
//		 * (Files.isReadable(path)) { //
//		 * 注意此处的newBufferedRead的charset参数，如果和所要读取的文件的编码不一致，则会抛出异常 //
//		 * java的新特性，不用自己关闭流 BufferedReader br = Files.newBufferedReader(path,
//		 * Charset .defaultCharset());// new BufferedReader(new //
//		 * FileReader(new // File("e:/logs/access.log")));// String line = "";
//		 * while ((line = br.readLine()) != null) { System.out.println(line); }
//		 * } else { System.err.println("cannot readable"); } } catch
//		 * (IOException e) { System.err.println("error charset"); }
//		 */
//
////		Path movefrom = FileSystems.getDefault().getPath(
////				"D:\\test\\writeFile\\wpms.txt");
////		Path target = FileSystems.getDefault().getPath(
////				"D:\\test\\writeFile\\wpmsDemo.txt");
////		Path target_dir = FileSystems.getDefault()
////				.getPath("D:\\test\\writeFile");
////		
////		System.out.println(movefrom.toFile().exists());
////		String path = "D:\\test\\writeFile\\wpms.txt";
////		File file = new File(path);
////		System.out.println(file.isFile());
////		try {
////			Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
////			Files.move(target, target.resolveSibling("wpms.txt"));
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		
////		try {
////            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
////        } catch (IOException e) {
////           e.printStackTrace();
////        }
//
//		File f1 = new File("D:\\test\\writeFile\\wpmsDemo.txt");
//		System.out.println(f1.toPath());
//		try {
//			Files.move(f1.toPath(), f1.toPath().resolveSibling("wpms.txt"));
//		} catch (Exception e) {
//			//  
//		}
//		
//	}
//
//=======
//package com.alison.stream.servlet;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//
//public class Demo {
//	public static void main(String[] args) {
//		// File file = new File("d:/test/writeFile/wpms.text");
//		// // File file1 = new File("d:/test/writeFile/wpms");
//		// Path pathOther = file.toPath();
//
//		// System.out.println(pathOther);
//		// System.out.println(file1.toPath().resolveSibling("wpms.text"));
//		// Files.move(file.toPath(), file.toPath().resolveSibling("wpms"),
//		// StandardCopyOption.REPLACE_EXISTING);
//
////		Path path = FileSystems.getDefault().getPath(f.getAbsolutePath());
////		Files.move(path, path.resolveSibling(fileName));
//		/*
//		 * // 获得path方法一,d:/test/writeFile/wpms.text Path path =
//		 * FileSystems.getDefault().getPath("d:/test/writeFile", "wpms.text");
//		 * System.out.println(path.getNameCount()); //
//		 * 获得path方法二，用File的toPath()方法获得Path对象 File file = new
//		 * File("d:/test/writeFile/wpms.text"); Path pathOther = file.toPath();
//		 * // 0,说明这两个path是相等的 System.out.println(path.compareTo(pathOther)); //
//		 * 获得path方法三 Path path3 = Paths.get("d:/test/writeFile", "wpms.text");
//		 * System.out.println(path3.toString());
//		 * 
//		 * // join two paths Path path4 = Paths.get("d:/test/writeFile");
//		 * System.out.println("path4: " + path4.resolve("wpms.text"));
//		 * System.out.println("--------------分割线---------------"); try { if
//		 * (Files.isReadable(path)) { //
//		 * 注意此处的newBufferedRead的charset参数，如果和所要读取的文件的编码不一致，则会抛出异常 //
//		 * java的新特性，不用自己关闭流 BufferedReader br = Files.newBufferedReader(path,
//		 * Charset .defaultCharset());// new BufferedReader(new //
//		 * FileReader(new // File("e:/logs/access.log")));// String line = "";
//		 * while ((line = br.readLine()) != null) { System.out.println(line); }
//		 * } else { System.err.println("cannot readable"); } } catch
//		 * (IOException e) { System.err.println("error charset"); }
//		 */
//
////		Path movefrom = FileSystems.getDefault().getPath(
////				"D:\\test\\writeFile\\wpms.txt");
////		Path target = FileSystems.getDefault().getPath(
////				"D:\\test\\writeFile\\wpmsDemo.txt");
////		Path target_dir = FileSystems.getDefault()
////				.getPath("D:\\test\\writeFile");
////		
////		System.out.println(movefrom.toFile().exists());
////		String path = "D:\\test\\writeFile\\wpms.txt";
////		File file = new File(path);
////		System.out.println(file.isFile());
////		try {
////			Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
////			Files.move(target, target.resolveSibling("wpms.txt"));
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		
////		try {
////            Files.move(movefrom, target, StandardCopyOption.REPLACE_EXISTING);
////        } catch (IOException e) {
////           e.printStackTrace();
////        }
//
//		File f1 = new File("D:\\test\\writeFile\\wpmsDemo.txt");
//		System.out.println(f1.toPath());
//		try {
//			Files.move(f1.toPath(), f1.toPath().resolveSibling("wpms.txt"));
//		} catch (Exception e) {
//			//  
//		}
//		
//	}
//
//}
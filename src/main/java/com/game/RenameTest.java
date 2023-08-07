package com.game;

import java.io.File;

public class RenameTest {

	public static void main(String[] args) {
		String rootPath = "/Users/ayeong-kim/Documents/dev/works/html/img";
		String targetPath = "/Users/ayeong-kim/Documents/dev/works/html/img/cards";
		File rootFile = new File(rootPath);
		File[] dirs = rootFile.listFiles();
		for(File dir : dirs) {
			if(dir.isDirectory()) {
				File[] files = dir.listFiles();
				for(File file : files) {
					String name = file.getName();
					if(name.contains("Th")) {
						continue;
					}
					name = name.substring(0,2);
					if("1a".equals(name)) {
						name = "01";
					} else if(name.contains("_")) {
						name = "0".substring(0,1);
					}
					String path = file.getParent()  + name + ".png";
					System.out.println(path);
//					file.renameTo(new File(path));
				}
			}
		}
	}
}

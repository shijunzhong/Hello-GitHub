package com.paul.util.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class FileUtil {
	private FileUtil() {
		//
	}

	/**
	 * IO复制文件
	 * 
	 * @param source
	 * @param target
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void fileCopy(String source, String target) throws FileNotFoundException, IOException {
		try (InputStream is = new FileInputStream(source)) {
			try (OutputStream os = new FileOutputStream(target)) {
				byte[] buffer = new byte[4096];
				int readPoint;
				while ((readPoint = is.read(buffer)) != -1) {
					os.write(buffer, 0, readPoint);
				}
			}
		}
	}

	/**
	 * NIO复制文件
	 * 
	 * @param source
	 * @param target
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void fileCopyNIO(String source, String target) throws FileNotFoundException, IOException {
		try (FileInputStream is = new FileInputStream(source)) {
			try (FileOutputStream os = new FileOutputStream(target)) {
				ByteBuffer buffer = ByteBuffer.allocate(4096);
				FileChannel isChannel = is.getChannel();
				FileChannel osChannel = os.getChannel();
				while (isChannel.read(buffer) != -1) {
					buffer.flip();
					osChannel.write(buffer);
					buffer.clear();
				}
			}
		}
	}

	public static int getStringOccur(String fileName, String key) throws FileNotFoundException, IOException {
		int count = 0;
		try (FileReader fr = new FileReader(fileName)) {
			try (BufferedReader br = new BufferedReader(fr)) {
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb = sb.append(line);
					count = sb.toString().split(key).length - 1;
				}
			}
		}
		return count;
	}
}

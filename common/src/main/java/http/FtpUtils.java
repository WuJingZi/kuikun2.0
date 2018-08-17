package http;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import sys.ServiceException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FtpUtils {


	private static String ftpUrl="xy-studio.cn";

	private static String dir="/var/ftp/pub/kuikun/";

	private static String userName="ftpuser";

	private static String password="undefined";

	private static int port=21;

	private static String yunUrl="ftp://xy-studio.cn/pub/kuikun/";


	/**
	 * ftp上传单个文件
	 * @param fileName 要上传的文件全路径名
	 * @throws IOException
	 */
	public static String upload(MultipartFile multipartFile, String fileName) throws IOException {
		FTPClient ftpClient = new FTPClient();
		InputStream localFileStream = null;
		try {
			ftpClient.connect(ftpUrl,port);
			ftpClient.login(userName, password);
			ftpClient.enterLocalPassiveMode();
			localFileStream =multipartFile.getInputStream();
// 设置上传目录
			if(!ftpClient.changeWorkingDirectory(dir)){
				if(!ftpClient.makeDirectory(dir)){
					throw new ServiceException("创建目录"+dir+"失败");
				}
			};
			ftpClient.changeWorkingDirectory(dir);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("gbk");
// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile(fileName, localFileStream);
			return fileName;
		} catch(FileNotFoundException e){
			throw new ServiceException("文件不存在");
		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			IOUtils.closeQuietly(localFileStream);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				throw new ServiceException("关闭ftp异常");
			}
		}
	}
}

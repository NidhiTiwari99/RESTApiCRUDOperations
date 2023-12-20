package mypackage.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import net.bytebuddy.build.ToStringPlugin.Enhance.Prefix;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

	 private String uploadDir;


	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}

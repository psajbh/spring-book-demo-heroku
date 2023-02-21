package com.jhart.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConfigPropertyBuilder {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String FILE_ENCODING = "file.encoding";
	private static final String FILE_ENCODING_PKG = "file.encoding.pkg";
	private static final String FILE_SEPERATOR = "file.separator";
	private static final String JAVA_CLASS_VERSION = "java.class.version";
	private static final String JAVA_LIBRARY_PATH = "java.library.path";
	private static final String JAVA_RUNTIME_NAME = "java.runtime.name";
	private static final String JAVA_RUNTIME_VERSION = "java.runtime.version";
	private static final String JAVA_SPECIFICATION_NAME = "java.specification.name";
	private static final String JAVA_SPECIFICATIION_VENDOR = "java.specification.vendor";
	private static final String JAVA_VENDOR = "java.vendor";
	private static final String JAVA_VENDOR_URL = "java.vendor.url";
	private static final String JAVA_VERSION = "java.version";
	private static final String JAVA_VM_NAME = "java.vm.name";
	private static final String JAVA_VM_SPECIFICATION = "java.vm.specification.version";
	private static final String JAVA_VM_SPECIFICATION_VENDOR = "java.vm.specification.vendor";
	private static final String JAVA_VM_VENDOR = "java.vm.vendor";
	private static final String JAVA_VM_VENDOR_URL = "java.vendor.url";
	private static final String JAVA_VM_VERSION = "java.vm.version";
	private static final String OS_NAME = "os.name";
	private static final String OS_VERSION = "os.version";
	private static final String SPRING_DEVSTOOLS_RESTART_ENABLED = "spring.devtools.restart.enabled";
	private static final String SUN_JAVA_COMMAND = "sun.java.command";
	private static final String SUN_JNU_ENCODING = "sun.jnu.encoding";
	private static final String USER_DIR = "user.dir";
	private static final String USER_LANGUAGE = "user.language";
	
	public ConfigPropertyBuilder() {}
	
	public String getConfigProperties() {
		log.debug("ConfigPropertyBuilder - getConfigProperties()");
		StringBuilder sb = new StringBuilder();
		sb.append(FILE_ENCODING + ": " + System.getProperty(FILE_ENCODING )+System.lineSeparator());
		sb.append(FILE_ENCODING_PKG + ": " + System.getProperty(FILE_ENCODING_PKG)+System.lineSeparator());
		sb.append(FILE_SEPERATOR + ": " + System.getProperty(FILE_SEPERATOR)+System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(JAVA_CLASS_VERSION + ": " + System.getProperty(JAVA_CLASS_VERSION)+System.lineSeparator());
		sb.append(JAVA_RUNTIME_NAME + ": " + System.getProperty(JAVA_RUNTIME_NAME)+System.lineSeparator());
		sb.append(JAVA_RUNTIME_VERSION + ": " + System.getProperty(JAVA_RUNTIME_VERSION)+System.lineSeparator());
		sb.append(JAVA_SPECIFICATION_NAME + ": " + System.getProperty(JAVA_SPECIFICATION_NAME)+System.lineSeparator());
		sb.append(JAVA_SPECIFICATIION_VENDOR + ": " + System.getProperty(JAVA_SPECIFICATIION_VENDOR)+System.lineSeparator());
		sb.append(JAVA_VENDOR + ": " + System.getProperty(JAVA_VENDOR)+System.lineSeparator());
		sb.append(JAVA_VENDOR_URL + ": " + System.getProperty(JAVA_VENDOR_URL)+System.lineSeparator());
		sb.append(JAVA_VERSION + ": " + System.getProperty(JAVA_VERSION)+System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(JAVA_LIBRARY_PATH + ": " + System.getProperty(JAVA_LIBRARY_PATH)+System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(JAVA_VM_NAME + ": " + System.getProperty(JAVA_VM_NAME)+System.lineSeparator());
		sb.append(JAVA_VM_SPECIFICATION + ": " + System.getProperty(JAVA_VM_SPECIFICATION)+System.lineSeparator());
		sb.append(JAVA_VM_SPECIFICATION_VENDOR + ": " + System.getProperty(JAVA_VM_SPECIFICATION_VENDOR)+System.lineSeparator());
		sb.append(JAVA_VM_VENDOR + ": " + System.getProperty(JAVA_VM_VENDOR)+System.lineSeparator());
		sb.append(JAVA_VM_VENDOR_URL + ": " + System.getProperty(JAVA_VM_VENDOR_URL)+System.lineSeparator());
		sb.append(JAVA_VM_VERSION + ": " + System.getProperty(JAVA_VM_VERSION)+System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(OS_NAME + ": " + System.getProperty(OS_NAME)+System.lineSeparator());
		sb.append(OS_VERSION + ": " + System.getProperty(OS_VERSION)+System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(SPRING_DEVSTOOLS_RESTART_ENABLED + ": " + System.getProperty(SPRING_DEVSTOOLS_RESTART_ENABLED)+System.lineSeparator());
		sb.append(SUN_JAVA_COMMAND + ": " + System.getProperty(SUN_JAVA_COMMAND)+System.lineSeparator());
		sb.append(SUN_JNU_ENCODING + ": " + System.getProperty(SUN_JNU_ENCODING)+System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(USER_DIR + ": " + System.getProperty(USER_DIR)+System.lineSeparator());
		sb.append(USER_LANGUAGE + ": " + System.getProperty(USER_LANGUAGE)+System.lineSeparator());
		log.debug("ConfigPropertyBuilder - getConfigProperties() completed");
		return sb.toString();
	}

}

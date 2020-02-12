package com.guicedee.guicedservlets.webservices.implementations;

import com.guicedee.guicedinjection.GuiceConfig;
import com.guicedee.guicedinjection.interfaces.IGuiceConfigurator;

public class WebServiceScannerConfig implements IGuiceConfigurator {
	@Override
	public GuiceConfig configure(GuiceConfig config) {

		config.setAnnotationScanning(true);
		config.setMethodInfo(true);
		config.setClasspathScanning(true);
		config.setFieldInfo(true);

		return config;
	}

}
